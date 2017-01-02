
package hani.weather.models.api.weather;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;

public class DataResponse extends RealmObject {

    @SerializedName("request")
    @Expose
    private RealmList<RequestResponse> request = new RealmList<>();
    @SerializedName("current_condition")
    @Expose
    private RealmList<CurrentConditionResponse> currentCondition = new RealmList<>();
    @SerializedName("weather")
    @Expose
    private RealmList<WeatherResponse> weather = new RealmList<WeatherResponse>();

    /**
     * 
     * @return
     *     The request
     */
    public RealmList<RequestResponse> getRequest() {
        return request;
    }

    /**
     * 
     * @param request
     *     The request
     */
    public void setRequest(RealmList<RequestResponse> request) {
        this.request = request;
    }

    public DataResponse withRequest(RealmList<RequestResponse> request) {
        this.request = request;
        return this;
    }

    /**
     * 
     * @return
     *     The currentCondition
     */
    public RealmList<CurrentConditionResponse> getCurrentCondition() {
        return currentCondition;
    }

    /**
     * 
     * @param currentCondition
     *     The current_condition
     */
    public void setCurrentCondition(RealmList<CurrentConditionResponse> currentCondition) {
        this.currentCondition = currentCondition;
    }

    public DataResponse withCurrentCondition(RealmList<CurrentConditionResponse> currentCondition) {
        this.currentCondition = currentCondition;
        return this;
    }

    /**
     * 
     * @return
     *     The weather
     */
    public RealmList<WeatherResponse> getWeather() {
        return weather;
    }

    /**
     * 
     * @param weather
     *     The weather
     */
    public void setWeather(RealmList<WeatherResponse> weather) {
        this.weather = weather;
    }

    public DataResponse withWeather(RealmList<WeatherResponse> weather) {
        this.weather = weather;
        return this;
    }

}
