package hani.weather.apimanger;

import android.app.Application;
import android.content.Context;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import hani.weather.callbacks.CitySearchCallBack;
import hani.weather.callbacks.WeatherForecastCallback;
import hani.weather.models.City;
import hani.weather.models.Weather;
import hani.weather.models.api.city.ResultResponse;
import hani.weather.models.api.weather.CurrentConditionResponse;
import hani.weather.models.api.weather.WeatherResponse;
import hani.weather.utils.DatabaseController;
import hani.weather.models.api.city.CityResponse;
import hani.weather.models.api.weather.WeatherApiResponse;
import hani.weather.utils.Constants;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hani.momanii on 9/2/16.
 */
public class ApiHelper {

    private static ApiHelper instance = null;
    private static Retrofit retrofitInstance = null;
    private ApiInterface apiInterface = null;
    private Context context = null;

    private ApiHelper(Context context) {
        this.context = context;
    }


    public static ApiHelper getInstance(Context context) {
        if (instance == null) {
            instance = new ApiHelper(context);
        }
        return instance;
    }


    private static Retrofit getRetrofitClient() {
        if (retrofitInstance == null) {
            retrofitInstance = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitInstance;
    }

    private ApiInterface getApiInterface() {
        if (apiInterface == null) {
            apiInterface = getRetrofitClient().create(ApiInterface.class);
        }
        return apiInterface;
    }

    public void searchForCity(String name, final CitySearchCallBack callBack) {
        Map<String, Object> query = new ArrayMap<>();
        query.put(Constants.KEY_PARAM, Constants.API_KEY);
        query.put(Constants.CITY_PARAM, name);
        query.put(Constants.FORMAT_PARAM, Constants.API_RESPONSE_JSON_FORMAT);
        query.put(Constants.TIME_ZONE_PARAM, Constants.TRUE);
        query.put(Constants.ONLY_POPULAR_PARAM, Constants.FALSE);
        query.put(Constants.NUMBER_OF_SEARCH_RESULTS_PARAM, Constants.NUMBER_OF_SEARCH_ITEMS_TO_GET);

        Call<CityResponse> call = getApiInterface().searchForCityRequest(query);
        call.enqueue(new Callback<CityResponse>() {
                         @Override
                         public void onResponse(Call<CityResponse> call, Response<CityResponse> response) {
                             ArrayList<City> cities = new ArrayList<City>();
                             if (response.body() != null && response.body().getSearchApi() != null && response.body().getSearchApi().getResult() != null) {
                                 if (response.isSuccessful() || response.body().getSearchApi().getResult().size() > 0) {
                                     ArrayList<ResultResponse> result = new ArrayList<ResultResponse>();
                                     result.addAll(response.body().getSearchApi().getResult());
                                     for (ResultResponse response1 : result) {
                                         City city = new City();
                                         city.setCityName(response1.getAreaName().get(0).getValue());
                                         city.setCountryName(response1.getCountry().get(0).getValue());
                                         city.setRegion(response1.getRegion().get(0).getValue());
                                         city.setTimeZone(Double.parseDouble(response1.getTimezone().getOffset()));
                                         city.setId(response1.getAreaName().get(0).getValue() + response1.getRegion().get(0).getValue());
                                         cities.add(city);
                                     }
                                 }
                             }
                             callBack.onWeatherForecastLoadedSusses(cities);
                         }

                         @Override
                         public void onFailure(Call<CityResponse> call, Throwable t) {
                             callBack.onWeatherForecastLoadedSusses(new ArrayList<City>());
                         }
                     }

        );
    }

    public void getWeatherForecast(final City city, final WeatherForecastCallback callback) {
        Map<String, Object> query = new ArrayMap<>();
        query.put(Constants.KEY_PARAM, Constants.API_KEY);
        query.put(Constants.CITY_PARAM, city.getCityName());
        query.put(Constants.FORMAT_PARAM, Constants.API_RESPONSE_JSON_FORMAT);
        query.put(Constants.NUMBER_OF_DAYS_PARAM, Constants.NUMBER_OF_DAYS_TO_GET);
        query.put(Constants.NORMAL_WEATHER_PARAM, Constants.TRUE);
        query.put(Constants.CURRENT_CONDITIONS_PARAM, Constants.TRUE);
        query.put(Constants.MONTHLY_CLIMATE_PARAM, Constants.FALSE);
        query.put(Constants.SHOW_COMMENTS_PARAM, Constants.FALSE);
        query.put(Constants.TIME_INTERVAL_PARAM, Constants.TIME_INTERVAL_TO_GET);
        query.put(Constants.LANGUAGE_PARAM, Constants.LANGUAGE);


        Call<WeatherApiResponse> call = getApiInterface().getWeatherInformationRequest(query);
        call.enqueue(new Callback<WeatherApiResponse>() {
            @Override
            public void onResponse(Call<WeatherApiResponse> call, Response<WeatherApiResponse> response) {
                if (response.errorBody() != null && !TextUtils.isEmpty(response.errorBody().toString())) {
                    callback.onWeatherForecastLoadedFailed(response.errorBody().toString());
                    return;
                }

                if (response.isSuccessful() || response.body().getData().getCurrentCondition().size() > 1 || response.body().getData().getWeather().size() > 1) {
                    Weather weather = new Weather();
                    weather.setCity(city);
                    weather.setWeather(response.body().getData().getWeather());
                    weather.setId(city.getId() + response.body().getData().getWeather().get(0).getDate());
                    CurrentConditionResponse currentConditionResponse = response.body().getData().getCurrentCondition().get(0);
                    DatabaseController.with((Application) context).clearWeather(city);

                    DatabaseController.with((Application) context).addWeather(weather);
                    callback.onWeatherForecastLoadedSusses(currentConditionResponse, weather);
                } else {
                    callback.onWeatherForecastLoadedFailed(String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<WeatherApiResponse> call, Throwable t) {
            }
        });
    }

}
