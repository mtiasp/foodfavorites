package se.mtiasp.foodfavorites.presenter;

import android.os.Handler;

import java.util.ArrayList;

import se.mtiasp.foodfavorites.model.FoodItem;
import se.mtiasp.foodfavorites.SearchContract;

import timber.log.Timber;

public class SearchPresenter implements SearchContract.Presenter {

    private static final int DELAY_AFTER_SELECT_IN_MILLIS = 2000;
    private static final int MIN_QUERY_LENGTH = 3;

    private SearchContract.View view;
    private SearchContract.Model model;

    private boolean timeoutStarted;
    private String lastQuery;

    public SearchPresenter(SearchContract.Model model) {
        this.model = model;
        model.setPresenter(this);
    }

    @Override
    public void onSearchQuery(String query) {
        Timber.d("onSearchQuery: '" + query + "'");

        lastQuery = query;

        if (query.length() < MIN_QUERY_LENGTH) {
            view.showEmptySearchResult();

        } else if (query.length() >= MIN_QUERY_LENGTH) {
            model.searchForFood(query);
        }
    }

    @Override
    public void onSearchCompleted(ArrayList<FoodItem> foodItems) {
        if (isViewAttached()) {
            view.showSearchResult(foodItems);
        }
    }

    @Override
    public void onSelectFoodItem(FoodItem foodItem, boolean selected) {
        Timber.d("onSelectFoodItem: '" + foodItem.getTitle() + "' :" + selected);
        model.updateSelectedForFoodItem(foodItem, selected);
        hideSearchAfterTimeout();
    }

    @Override
    public void onRemoveFoodItem(FoodItem foodItem) {
        Timber.d("onRemoveFoodItem: '" + foodItem.getTitle() + "'");
        model.updateSelectedForFoodItem(foodItem, false);
    }

    @Override
    public void onFetchAllSelectedFood() {
        model.getAllSelectedFoodItems();
    }

    @Override
    public void onAllSelectedFoodFetched(ArrayList<FoodItem> foodItems) {
        if (isViewAttached()) {
            view.showAllSelectedFood(foodItems);
            lastQuery = null;
        }
    }

    @Override
    public void onCloseSearch() {
        view.showEmptySearchResult();
        model.getAllSelectedFoodItems();
    }

    @Override
    public void onRestoreState() {
        if (lastQuery == null) {
            Timber.d("no searchQuery - displaying all selected food");
            onFetchAllSelectedFood();
        } else {
            view.setSearchQuery(lastQuery);
        }
    }

    @Override
    public void onViewAttached(SearchContract.View view) {
        this.view = view;
    }

    @Override
    public void onViewDetached() {
        view = null;
    }

    @Override
    public void onDestroyed() {
        view = null;
        model.onDestroy();
    }

    private boolean isViewAttached() {
        return view != null;
    }

    private void hideSearchAfterTimeout() {
        if (!timeoutStarted) {
            Timber.d("timeoutStarted!");
            timeoutStarted = true;

            new Handler().postDelayed(() -> {
                if (isViewAttached()) {
                    view.hideSearch();
                    model.getAllSelectedFoodItems();
                }
                timeoutStarted = false;
            }, DELAY_AFTER_SELECT_IN_MILLIS);
        } else {
            Timber.d("timeout already started");
        }
    }
}
