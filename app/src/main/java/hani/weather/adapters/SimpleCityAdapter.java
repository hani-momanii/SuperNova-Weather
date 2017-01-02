package hani.weather.adapters;

import android.app.Application;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Collections;
import hani.weather.R;
import hani.weather.models.City;
import hani.weather.utils.DatabaseController;

/**
 * Created by hani.momanii on 9/6/16.
 */
public class SimpleCityAdapter extends RecyclerView.Adapter<SimpleCityAdapter.HomeViewHolder> {

    private ArrayList<City> cities;
    private int rowLayout;
    private Context context;
    private boolean isSearch;
    SimpleCityAdapter exitAdapter;

    public SimpleCityAdapter(Context context, ArrayList<City> cities, boolean search, SimpleCityAdapter exitAdapter) {
        this.cities = cities;
        this.rowLayout = R.layout.city_item;
        this.context = context;
        this.isSearch = search;
        this.exitAdapter = exitAdapter;
    }

    public static class HomeViewHolder extends RecyclerView.ViewHolder {
        TextView cityName, countryName;
        ImageView cityAction;
        View view;

        public HomeViewHolder(View v) {
            super(v);
            view = v;

            cityName = (TextView) v.findViewById(R.id.city_name);
            countryName = (TextView) v.findViewById(R.id.country_name);
            cityAction = (ImageView) v.findViewById(R.id.city_action);
        }
    }

    @Override
    public SimpleCityAdapter.HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final HomeViewHolder holder, final int position) {


        holder.cityName.setText(cities.get(position).getCityName());
        holder.countryName.setText(cities.get(position).getCountryName() + "," + cities.get(position).getRegion());
        if (isSearch) {
            holder.cityAction.setImageResource(R.drawable.ic_add_circle_black_36dp);
            holder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if (exitAdapter.cities.contains(cities.get(position))) {
                        Toast.makeText(context, "You have This city !", Toast.LENGTH_LONG).show();
                    } else {
                        try {
                            DatabaseController.with((Application) context).addCity(cities.get(position));
                            exitAdapter.cities.add(cities.get(position));
                            Toast.makeText(context, cities.get(position).getCityName() + " Added", Toast.LENGTH_LONG).show();
                            Collections.reverse(exitAdapter.cities);
                            exitAdapter.notifyDataSetChanged();
                        } catch (Exception e) {
                            DatabaseController.with((Application) context).getRealm().cancelTransaction();
                            Toast.makeText(context, "Failed to add city", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            });

        } else {
            holder.cityAction.setImageResource(R.drawable.ic_cancel_black_48dp);
            holder.cityAction.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        if (cities.size() > 1) {
                            DatabaseController.with((Application) context).deleteCity(cities.get(position));
                            Toast.makeText(context, cities.get(position).getCityName() + " Removed", Toast.LENGTH_LONG).show();
                            cities.remove(cities.get(position));
                            notifyDataSetChanged();
                        } else {
                            Toast.makeText(context, "You can't delete all cities", Toast.LENGTH_LONG).show();
                        }

                    } catch (Exception e) {
                        DatabaseController.with((Application) context).getRealm().cancelTransaction();
                        Toast.makeText(context, "Failed to add city", Toast.LENGTH_LONG).show();
                    }
                }
            });

        }

    }

    @Override
    public int getItemCount() {
        return cities.size();
    }


}