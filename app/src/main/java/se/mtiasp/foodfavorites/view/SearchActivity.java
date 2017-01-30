package se.mtiasp.foodfavorites.view;

import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.SearchView;

import java.util.ArrayList;

import se.mtiasp.foodfavorites.model.FoodItem;
import se.mtiasp.foodfavorites.R;
import se.mtiasp.foodfavorites.SearchContract;
import se.mtiasp.foodfavorites.presenter.SearchPresenter;
import se.mtiasp.foodfavorites.presenter.SearchPresenterLoader;
import timber.log.Timber;

public class SearchActivity extends AppCompatActivity implements SearchContract.View {

    private static final int LOADER_ID = 101;

    private boolean shouldRestoreState = true;

    private SearchContract.Presenter mPresenter;

    private RecyclerView searchResultRecyclerView;
    private RecyclerView selectedFoodRecyclerView;
    private SearchView searchView;
    private View searchResultView;
    private View selectedFoodView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme);

        setupPresenterLoader();
    }

    private void setupPresenterLoader() {
        getSupportLoaderManager().initLoader(LOADER_ID, null, new LoaderManager.LoaderCallbacks<SearchPresenter>() {

            @Override
            public final Loader<SearchPresenter> onCreateLoader(int id, Bundle args) {
                Timber.d("onCreateLoader");
                return new SearchPresenterLoader(SearchActivity.this);
            }

            @Override
            public void onLoadFinished(Loader<SearchPresenter> loader, SearchPresenter presenter) {
                Timber.d("onLoadFinished");
                SearchActivity.this.mPresenter = presenter;
            }

            @Override
            public void onLoaderReset(Loader<SearchPresenter> loader) {
                Timber.d("onLoaderReset");
                SearchActivity.this.mPresenter = null;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Timber.d("onResume");
        restoreState();
    }

    @Override
    protected void onPause(){
        super.onPause();
        Timber.d("onPause");
        shouldRestoreState = true;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Timber.d("onDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Timber.d("onStart");
        initView();
        mPresenter.onViewAttached(this);
    }

    @Override
    protected void onStop() {
        mPresenter.onViewDetached();
        super.onStop();
        Timber.d("onStop");
    }

    private void initView() {
        Timber.d("initView");

        setContentView(R.layout.activity_main);
        searchResultView = findViewById(R.id.search_result_view);
        searchResultRecyclerView = (RecyclerView) findViewById(R.id.search_result_recycler_view);
        searchResultRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        searchResultRecyclerView.setLayoutManager(layoutManager);

        selectedFoodView = findViewById(R.id.selected_food_view);
        selectedFoodRecyclerView = (RecyclerView) findViewById(R.id.selected_food_recycler_view);
        selectedFoodRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(getApplicationContext());
        selectedFoodRecyclerView.setLayoutManager(layoutManager2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuItem searchMenuItem = menu.findItem(R.id.menuSearch);
        searchView = (SearchView) searchMenuItem.getActionView();
        searchView.setImeOptions(searchView.getImeOptions() | EditorInfo.IME_FLAG_NO_EXTRACT_UI | EditorInfo.IME_FLAG_NO_FULLSCREEN);

        searchView.setOnSearchClickListener(view -> {
            selectedFoodView.setVisibility(View.GONE);
            searchResultView.setVisibility(View.VISIBLE);
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                mPresenter.onSearchQuery(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                mPresenter.onSearchQuery(query);
                return false;
            }
        });

        searchView.setOnCloseListener(() -> {
            mPresenter.onCloseSearch();
            return false;
        });

        restoreState();

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void showSearchResult(ArrayList<FoodItem> foodList) {
        searchResultRecyclerView.setAdapter(createSearchResultAdapter(foodList));
        searchResultRecyclerView.getAdapter().notifyDataSetChanged();
        searchResultView.setVisibility(View.VISIBLE);
        selectedFoodView.setVisibility(View.GONE);
    }

    @Override
    public void showAllSelectedFood(ArrayList<FoodItem> foodList) {
        hideSearch();
        searchResultView.setVisibility(View.GONE);
        selectedFoodView.setVisibility(View.VISIBLE);
        selectedFoodRecyclerView.setAdapter(createSelectedFoodAdapter(foodList));
        selectedFoodRecyclerView.getAdapter().notifyDataSetChanged();
    }

    @Override
    public void showEmptySearchResult() {
        emptySearchResultAdapter();
    }

    @Override
    public void setSearchQuery(String query) {
        if (searchView != null) {
            Timber.d("Setting setSearchQuery to: " + query);
            searchView.onActionViewExpanded();
            searchView.setQuery(query, true);
        } else {
            Timber.d("Failed setSearchQuery to: " + query);
        }
    }

    @Override
    public void hideSearch() {
        if (searchView != null) {
            searchView.onActionViewCollapsed();
        }
    }

    private void emptySearchResultAdapter() {
        searchResultRecyclerView.setAdapter(createSearchResultAdapter(new ArrayList<>()));
        searchResultRecyclerView.getAdapter().notifyDataSetChanged();
    }

    private SearchResultAdapter createSearchResultAdapter(ArrayList<FoodItem> foodList) {
        return new SearchResultAdapter(foodList,
                (foodItem, isSelected) -> mPresenter.onSelectFoodItem(foodItem, isSelected));
    }

    private SelectedFoodAdapter createSelectedFoodAdapter(ArrayList<FoodItem> foodList) {
        return new SelectedFoodAdapter(foodList,
                foodItem -> mPresenter.onRemoveFoodItem(foodItem));
    }

    private void restoreState() {
        if (shouldRestoreState && searchView != null) {
            mPresenter.onRestoreState();
            shouldRestoreState = false;
        }
    }
}
