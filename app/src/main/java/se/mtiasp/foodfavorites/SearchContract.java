package se.mtiasp.foodfavorites;

import java.util.ArrayList;

import se.mtiasp.foodfavorites.model.FoodItem;

public interface SearchContract {

    public interface View {
        void showSearchResult(ArrayList<FoodItem> foodList);
        void showAllSelectedFood(ArrayList<FoodItem> foodList);
        void showEmptySearchResult();
        void setSearchQuery(String query);
        void hideSearch();
    }

    public interface Presenter {
        void onSearchQuery(String query);
        void onSearchCompleted(ArrayList<FoodItem> foodItems);
        void onSelectFoodItem(FoodItem foodItem, boolean selected);
        void onRemoveFoodItem(FoodItem foodItem);
        void onFetchAllSelectedFood();
        void onAllSelectedFoodFetched(ArrayList<FoodItem> foodItems);
        void onCloseSearch();
        void onRestoreState();
        void onViewAttached(SearchContract.View view);
        void onViewDetached();
        void onDestroyed();
    }

    public interface Model {
        void searchForFood(String query);
        void getAllSelectedFoodItems();
        void updateSelectedForFoodItem(FoodItem foodItem, boolean selected);
        void onDestroy();
        void setPresenter(SearchContract.Presenter presenter);
    }
}