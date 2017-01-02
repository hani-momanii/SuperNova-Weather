package hani.weather.utils;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import hani.weather.BuildConfig;
import hani.weather.models.Weather;
import hani.weather.models.api.weather.WeatherApiResponse;
import hani.weather.models.City;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by hani.momanii on 9/2/16.
 */
public class DatabaseController {
    private static DatabaseController instance;

    private final Realm realm;

    public DatabaseController(Application application) {
        realm = Realm.getDefaultInstance();
    }

    public static DatabaseController with(Application application) {
        if (instance == null) {
            instance = new DatabaseController(application);
        }
        return instance;
    }

    public Realm getRealm() {
        return realm;
    }

    public void addCity(final City city) throws Exception {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(city);
            }
        });
    }

    public void addCityList(final List<City> cities) throws Exception {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.copyToRealmOrUpdate(cities);
            }
        });
    }


    public void addWeather(final Weather weather) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try {
                    realm.copyToRealmOrUpdate(weather);
                } catch (Exception e) {
                    Log.e(Constants.TAG, "" + e.getMessage());
                    realm.cancelTransaction();
                }
            }
        });
    }


    public void clearWeather(final City city) {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try {
                    RealmResults<Weather> result = realm.where(Weather.class).equalTo("city.id", city.getId()).findAll();
                    result.deleteAllFromRealm();
                } catch (Exception e) {
                    Log.e(Constants.TAG, "" + e.getMessage());
                    realm.cancelTransaction();
                }
            }
        });
    }


    public void deleteCity(final City city) throws Exception {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                RealmResults<City> result = realm.where(City.class).equalTo("id", city.getId()).findAll();
                result.deleteAllFromRealm();
            }
        });
    }


    public List<City> getCities() {
        List<City> cities = realm.where(City.class).findAll();
        for (City city : cities) {
            Utility.log(city.getCityName());
        }
        return cities;
    }

    public List<Weather> getWeather(final City city) {
        List<Weather> weathers = realm.where(Weather.class).equalTo("city.id", city.getId()).findAll();

        return weathers;
    }

}

