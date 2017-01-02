package hani.weather.activities;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import hani.weather.R;
import hani.weather.adapters.SimpleCityAdapter;
import hani.weather.apimanger.ApiHelper;
import hani.weather.callbacks.CitySearchCallBack;
import hani.weather.models.City;
import hani.weather.models.api.city.ResultResponse;
import hani.weather.utils.Constants;
import hani.weather.utils.DatabaseController;
import hani.weather.utils.Utility;

public class CitiesActivity extends AppCompatActivity implements CitySearchCallBack {

    private ArrayList<City> existCitiesList = new ArrayList<>();
    private ArrayList<City> searchCitiesList = new ArrayList<>();
    private final CitySearchCallBack callBack = this;

    private RecyclerView existCities, searchCities;
    private SimpleCityAdapter searchAdapter, existAdapter;
    private EditText cityNameET;
    private TextView noInternet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cities);

        if (getIntent().getParcelableArrayListExtra(Constants.CITY_TAG) != null) {
            existCitiesList = getIntent().getParcelableArrayListExtra(Constants.CITY_TAG);
        } else {
            existCitiesList.addAll(DatabaseController.with(getApplication()).getCities());
        }
        setViewsIds();
        setAdapters();
    }

    private void setViewsIds() {
        existCities = (RecyclerView) findViewById(R.id.cities_recycler_view);
        searchCities = (RecyclerView) findViewById(R.id.search_cities_recycler_view);
        cityNameET = (EditText) findViewById(R.id.city_name_et);
        noInternet = (TextView) findViewById(R.id.no_internet);
        cityNameET.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (Utility.checkInternetConnection(getApplicationContext())) {
                    ApiHelper.getInstance(getApplicationContext()).searchForCity(s.toString(), callBack);
                    if (noInternet.getVisibility() == View.VISIBLE)
                        noInternet.setVisibility(View.GONE);
                } else {
                    noInternet.setVisibility(View.VISIBLE);
                }
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
    }

    private void setAdapters() {
        existAdapter = new SimpleCityAdapter(getApplicationContext(), existCitiesList, false, null);
        existCities.setAdapter(existAdapter);
        existCities.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        searchAdapter = new SimpleCityAdapter(getApplicationContext(), searchCitiesList, true, existAdapter);
        searchCities.setAdapter(searchAdapter);
        searchCities.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

    }

    @Override
    public void onWeatherForecastLoadedSusses(List<City> searchResult) {
        searchCitiesList.clear();
        searchCitiesList.addAll(searchResult);
        searchAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        setResult(Activity.RESULT_OK);
        finish();
    }
}
