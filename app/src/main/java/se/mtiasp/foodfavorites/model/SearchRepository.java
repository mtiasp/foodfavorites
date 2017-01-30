package se.mtiasp.foodfavorites.model;

import android.text.TextUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.realm.Case;
import io.realm.Realm;
import io.realm.RealmQuery;

import okhttp3.ResponseBody;
import retrofit2.Response;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import se.mtiasp.foodfavorites.AppApplication;
import se.mtiasp.foodfavorites.AppConstants;
import se.mtiasp.foodfavorites.SearchContract;

import se.mtiasp.foodfavorites.model.api.ApiService;
import se.mtiasp.foodfavorites.model.api.response.Food;
import se.mtiasp.foodfavorites.model.api.response.FoodResponse;
import se.mtiasp.foodfavorites.model.realm.FoodRealmObject;

import se.mtiasp.foodfavorites.utils.NetworkUtils;

import timber.log.Timber;

public class SearchRepository implements SearchContract.Model {

    @Inject
    public ApiService apiService;

    private Realm realmUI;

    private Subscription fetchSubscription;

    private String query;

    private SearchContract.Presenter presenter;

    public SearchRepository() {
        AppApplication.getInstance().getApiServiceComponent().inject(this);
        realmUI = Realm.getDefaultInstance();
    }

    @Override
    public void setPresenter(SearchContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void searchForFood(String query) {
        this.query = query;

        if (NetworkUtils.isNetworkConnected(AppApplication.getInstance())) {
            Timber.d("Online");
            fetchAndStoreResultsFromAPI(query);
        } else {
            Timber.d("Offline");
            fetchResultsFromRealm();
        }
    }

    private void fetchAndStoreResultsFromAPI(String query) {

        fetchSubscription =
                apiService.getFood(AppConstants.TOKEN, query)
                        .subscribeOn(Schedulers.io())
                        .observeOn(Schedulers.computation())
                        .map(this::writeToRealm)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(foodList -> fetchResultsFromRealm(), this::handleApiError);
    }

    private List<Food> writeToRealm(Response<FoodResponse> foodResponse) {
        List<Food> foodList = new ArrayList<>();

        try {
            foodList = foodResponse.body().getFood();
        } catch (Exception e ) {
            Timber.d("No foodlist in response");
            return null;
        }

        for (Food food : foodList) {
            Realm realm = Realm.getDefaultInstance();
            realm.executeTransaction(transactionRealm -> {
                FoodRealmObject foodRealm = findInRealm(transactionRealm, food.getId());
                if (foodRealm == null) {
                    foodRealm = transactionRealm.createObject(FoodRealmObject.class, food.getId());
                }
                foodRealm.setTitle(food.getTitle());
                foodRealm.setCaloriesDescription(extractCaloriesDescription(food));
            });
            realm.close();
        }

        return foodList;
    }

    private FoodRealmObject findInRealm(Realm realm, Integer id) {
        return realm.where(FoodRealmObject.class).equalTo("id", id).findFirst();
    }

    private void handleApiError(Throwable e) {
        Timber.e(e.getLocalizedMessage());
        fetchResultsFromRealm();
    }

    private void fetchResultsFromRealm() {
        Timber.d("Reading from db for query: " + this.query);
        RealmQuery<FoodRealmObject> realmQuery = realmUI.where(FoodRealmObject.class).contains("title", this.query, Case.INSENSITIVE);
        List<FoodRealmObject> results = realmUI.copyFromRealm(realmQuery.findAllSorted("title"));

        ArrayList<FoodItem> foodArrayList = new ArrayList<>();

        for (FoodRealmObject foodRealmObject : results) {
            FoodItem foodItem = new FoodItem(foodRealmObject);
            foodArrayList.add(foodItem);
        }

        Timber.d("doCallback");

        presenter.onSearchCompleted(foodArrayList);
    }

    @Override
    public void getAllSelectedFoodItems() {
        RealmQuery<FoodRealmObject> query = realmUI.where(FoodRealmObject.class).equalTo("isSelected", true);
        List<FoodRealmObject> results = realmUI.copyFromRealm(query.findAllSorted("title"));

        ArrayList<FoodItem> foodArrayList = new ArrayList<>();

        for (FoodRealmObject foodRealmObject : results) {
            Timber.d("Fetched from realm: " + foodRealmObject.getTitle() + " for query: " + this.query);

            FoodItem foodItem = new FoodItem(foodRealmObject);
            foodArrayList.add(foodItem);
        }

        presenter.onAllSelectedFoodFetched(foodArrayList);
    }

    @Override
    public void updateSelectedForFoodItem(FoodItem foodItem, boolean selected) {
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(transactionRealm -> {
            FoodRealmObject foodRealm = findInRealm(transactionRealm, foodItem.getId());
            foodRealm.setSelected(selected);
        });
        realm.close();
    }

    @Override
    public void onDestroy() {

        if (fetchSubscription != null) {
            fetchSubscription.unsubscribe();
        }

        realmUI.close();
    }

    private String extractCaloriesDescription(Food food) {
        String caloriesDescription = "";

        try {
            float caloriesPer100Gram = food.getCalories();

            // hack to avoid unrealistic values since I don't understand the model yet :-)
            if (caloriesPer100Gram > 1000) {
                return "";
            }

            float caloriesPerGram = caloriesPer100Gram / 100;
            Double servingInGram;

            if (!TextUtils.isEmpty(food.getPcstext())) {
                servingInGram = food.getPcsingram();
            } else {
                servingInGram = food.getGramsperserving();
            }

            String calories;

            if (servingInGram != null && servingInGram > 0) {
                long caloriesPerPcsRounded = Math.round(caloriesPerGram * servingInGram);
                calories = String.valueOf(caloriesPerPcsRounded);
            } else {
                return "";
            }

            caloriesDescription = calories + " kcal";

        } catch (Exception e) {
            Timber.e(e, "Failed to calculate kcal");
        }

        return caloriesDescription;
    }
}
