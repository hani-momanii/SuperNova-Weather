package hani.weather.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

import hani.weather.fragments.WeatherFragment;
import hani.weather.models.City;
import hani.weather.models.Weather;
import hani.weather.models.api.weather.CurrentConditionResponse;

/**
 * Created by hani.momanii on 9/4/16.
 */
public class ViewPagerAdapter extends SmartFragmentStatePagerAdapter {

    List<City> cities = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm, List<City> cities) {
        super(fm);
        this.cities = cities;
    }

    @Override
    public Fragment getItem(int position) {
        return WeatherFragment.newInstance(cities.get(position));
    }

    @Override
    public int getCount() {
        return cities.size();
    }
}