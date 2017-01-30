package se.mtiasp.foodfavorites.presenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import se.mtiasp.foodfavorites.model.FoodItem;
import se.mtiasp.foodfavorites.model.SearchRepository;
import se.mtiasp.foodfavorites.view.SearchActivity;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class SearchPresenterTest {

    @Mock
    SearchActivity view;

    @Mock
    SearchRepository model;

    SearchPresenter presenter;

    @Before
    public void setup() {
        presenter = new SearchPresenter(model);
        presenter.onViewAttached(view);
    }

    @Test
    public void searchQueryWithAllowedLength() throws Exception {
        String query = "kaffe";

        presenter.onSearchQuery(query);

        verify(model, times(1)).searchForFood(query);
    }

    @Test
    public void searchQueryWithLengthTooShort() throws Exception {
        String query = "te";

        presenter.onSearchQuery(query);

        verify(view, times(1)).showEmptySearchResult();
    }

    @Test
    public void searchCompleted() throws Exception {
        ArrayList<FoodItem> foodList = new ArrayList<>();
        foodList.add(new FoodItem(123, "title1", "desc1", false));
        foodList.add(new FoodItem(456, "title2", "desc2", false));

        presenter.onSearchCompleted(foodList);

        verify(view, times(1)).showSearchResult(foodList);
    }

    @Test
    public void removeFoodItem() throws Exception {
        FoodItem foodItem = new FoodItem(123, "title1", "desc1", true);

        presenter.onRemoveFoodItem(foodItem);

        verify(model, times(1)).updateSelectedForFoodItem(foodItem, false);
    }

    @Test
    public void fetchAllSelectedFood() throws Exception {
        presenter.onFetchAllSelectedFood();

        verify(model, times(1)).getAllSelectedFoodItems();
    }

    @Test
    public void allSelectedFoodFetched() throws Exception {
        ArrayList<FoodItem> foodList = new ArrayList<>();
        foodList.add(new FoodItem(123, "title1", "desc1", true));
        foodList.add(new FoodItem(456, "title2", "desc2", true));

        presenter.onAllSelectedFoodFetched(foodList);

        verify(view, times(1)).showAllSelectedFood(foodList);
    }

    @Test
    public void closeSearch() throws Exception {
        presenter.onCloseSearch();

        verify(view, times(1)).showEmptySearchResult();
        verify(model, times(1)).getAllSelectedFoodItems();
    }
}
