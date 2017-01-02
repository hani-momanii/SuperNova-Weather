package hani.weather.callbacks;

import java.util.List;

import hani.weather.models.api.weather.CurrentConditionResponse;
import hani.weather.models.Weather;

/**
 * Created by hani.momanii on 9/2/16.
 */
public interface WeatherForecastCallback {
    void onWeatherForecastLoadedSusses(CurrentConditionResponse currentCondition, Weather weather);

    void onWeatherForecastLoadedFailed(int errorCode);
}
