package se.mtiasp.foodfavorites;

import android.app.Application;
import io.realm.Realm;
import io.realm.RealmConfiguration;

import se.mtiasp.foodfavorites.model.api.ApiServiceComponent;
import se.mtiasp.foodfavorites.model.api.ApiServiceModule;
import se.mtiasp.foodfavorites.model.api.DaggerApiServiceComponent;

import timber.log.Timber;

public class AppApplication extends Application {

    protected static AppApplication instance;

    protected ApiServiceComponent apiServiceComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = AppApplication.this;

        RealmConfiguration realmConfig = new RealmConfiguration.Builder(this).build();
        Realm.setDefaultConfiguration(realmConfig);

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        /*try {
            Realm.deleteRealm(realmConfig);
            Timber.d("Deleted realm");
        } catch (Exception ex){
            Timber.d("Could not delete realm");
            throw ex;
        }*/

        apiServiceComponent = DaggerApiServiceComponent.builder().apiServiceModule(new ApiServiceModule(AppConstants.API_URL)).build();
    }

    public static AppApplication getInstance() {
        return instance;
    }

    public ApiServiceComponent getApiServiceComponent() {
        return apiServiceComponent;
    }
}
