package hani.weather.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import hani.weather.R;
import hani.weather.models.Weather;
import hani.weather.models.api.weather.HourlyResponse;
import hani.weather.utils.Utility;

/**
 * Created by hani.momanii on 9/3/16.
 */
public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.HomeViewHolder> {

    private Weather weather;
    private int rowLayout;
    private Context context;

    public ForecastAdapter(Context context, Weather weather) {
        this.weather = weather;
        this.rowLayout = R.layout.forecast_item;
        this.context = context;
    }

    public static class HomeViewHolder extends RecyclerView.ViewHolder {
        TextView forecastDayTextView, forecastMaxTemp, forecastMinTemp, morningTemp, afternoonTemp, eveningTemp, nightTemp;
        ImageView morningImage, afternoonImage, eveningImage, nightImage;
        View view;

        public HomeViewHolder(View v) {
            super(v);
            view = v;

            forecastDayTextView = (TextView) v.findViewById(R.id.forecast_day_textView);
            forecastMaxTemp = (TextView) v.findViewById(R.id.forecast_max_temperature_text_view);
            forecastMinTemp = (TextView) v.findViewById(R.id.forecast_min_temperature_text_view);

            morningTemp = (TextView) v.findViewById(R.id.day_morning_dgree_value);
            afternoonTemp = (TextView) v.findViewById(R.id.day_afternoon_dgree_value);
            eveningTemp = (TextView) v.findViewById(R.id.day_evening_dgree_value);
            nightTemp = (TextView) v.findViewById(R.id.day_night_dgree_value);

            morningImage = (ImageView) v.findViewById(R.id.morning_image);
            afternoonImage = (ImageView) v.findViewById(R.id.afternoon_image);
            eveningImage = (ImageView) v.findViewById(R.id.evening_image);
            nightImage = (ImageView) v.findViewById(R.id.night_image);
        }
    }

    @Override
    public ForecastAdapter.HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final HomeViewHolder holder, final int position) {


        if (Utility.checkInternetConnection(context)) {
            if (position == 0) {
                holder.forecastDayTextView.setText("Today");
            } else {
                holder.forecastDayTextView.setText(Utility.getDayNameFromDate(weather.getWeather().get(position).getDate()));
            }
        }else{
            holder.forecastDayTextView.setText(Utility.getDayNameFromDate(weather.getWeather().get(position).getDate())+" "+weather.getWeather().get(position).getDate());
        }

        holder.forecastMaxTemp.setText(weather.getWeather().get(position).getMaxtempC());
        holder.forecastMinTemp.setText(weather.getWeather().get(position).getMintempC());

        List<HourlyResponse> hourlyResponses = weather.getWeather().get(position).getHourly();

        if (hourlyResponses.size() > 0) {
            holder.morningTemp.setText(hourlyResponses.get(0).getTempC() + (char) 0x00B0);
            holder.morningImage.setImageResource(Utility.getImageIdFromDescription(weather.getWeather().get(position).getHourly().get(0).getWeatherDesc().get(0).getValue()));
        }

        if (hourlyResponses.size() > 1) {
            holder.afternoonTemp.setText(hourlyResponses.get(1).getTempC() + (char) 0x00B0);
            holder.afternoonImage.setImageResource(Utility.getImageIdFromDescription(weather.getWeather().get(position).getHourly().get(1).getWeatherDesc().get(0).getValue()));
        }

        if (hourlyResponses.size() > 2) {
            holder.eveningTemp.setText(hourlyResponses.get(2).getTempC() + (char) 0x00B0);
            holder.eveningImage.setImageResource(Utility.getImageIdFromDescription(weather.getWeather().get(position).getHourly().get(2).getWeatherDesc().get(0).getValue()));
        }


        if (hourlyResponses.size() > 3) {
            holder.nightTemp.setText(hourlyResponses.get(3).getTempC() + (char) 0x00B0);
            holder.nightImage.setImageResource(Utility.getImageIdFromDescription(weather.getWeather().get(position).getHourly().get(3).getWeatherDesc().get(0).getValue()));
        }
    }

    @Override
    public int getItemCount() {
        return weather.getWeather().size();
    }


}