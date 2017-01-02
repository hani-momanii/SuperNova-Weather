package hani.weather;

import android.app.Application;

import hani.weather.utils.Constants;
import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by hani.momanii on 9/2/16.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .name(Constants.DATA_BASE_NAME)
                .schemaVersion(Constants.DATABASE_VERSION)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}