package hani.weather.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Collections;

import hani.weather.R;
import hani.weather.adapters.ViewPagerAdapter;
import hani.weather.fragments.WeatherFragment;
import hani.weather.models.City;
import hani.weather.utils.Constants;
import hani.weather.utils.DatabaseController;

public class MainActivity extends AppCompatActivity implements WeatherFragment.OnFragmentInteractionListener {
/*

    private RelativeLayout currentWeatherParentLayout,parentLayout;
    private ScrollView itemsScrollView;
    private RecyclerView currentDetailsRecyclerView;
    private LinearLayout conditionLinearLayout;*/

    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private ArrayList<City> cities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cities.addAll(DatabaseController.with(getApplication()).getCities());
        Collections.reverse(cities);
        viewPager = (ViewPager) findViewById(R.id.weather_view_pager);
        if (cities.size() > 0) {
            setViewPagerAdapter();
        } else {
            onFragmentInteraction();
        }
    }

    @Override
    public void onFragmentInteraction() {
        Intent intent = new Intent(getApplicationContext(), CitiesActivity.class);
        intent.putParcelableArrayListExtra(Constants.CITY_TAG, cities);
        startActivityForResult(intent, Constants.NEW_CITY_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == Constants.NEW_CITY_CODE) {
                cities.clear();
                cities.addAll(DatabaseController.with(getApplication()).getCities());
                Collections.reverse(cities);
                setViewPagerAdapter();
            }
        }

    }

    public void setViewPagerAdapter() {
        if(viewPagerAdapter!=null){
            viewPagerAdapter.notifyDataSetChanged();
        }
        viewPager.setOffscreenPageLimit(cities.size());
        viewPager.setPageMargin(10);
        viewPager.setPageMarginDrawable(new ColorDrawable(Color.parseColor("#000000")));
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), cities);
        viewPager.setAdapter(viewPagerAdapter);
    }
}
