package se.mtiasp.foodfavorites.presenter;

import android.content.Context;
import android.support.v4.content.Loader;

import se.mtiasp.foodfavorites.model.SearchRepository;

public class SearchPresenterLoader extends Loader<SearchPresenter> {

    private SearchPresenter searchPresenter;

    public SearchPresenterLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        if (searchPresenter != null) {
            deliverResult(searchPresenter);
            return;
        }

        forceLoad();
    }

    @Override
    protected void onForceLoad() {
        SearchRepository model = new SearchRepository();
        searchPresenter = new SearchPresenter(model);

        deliverResult(searchPresenter);
    }

    @Override
    public void deliverResult(SearchPresenter searchPresenter) {
        super.deliverResult(searchPresenter);
    }

    @Override
    protected void onStopLoading() {
    }

    @Override
    protected void onReset() {
        if (searchPresenter != null) {
            searchPresenter.onDestroyed();
            searchPresenter = null;
        }
    }
}
