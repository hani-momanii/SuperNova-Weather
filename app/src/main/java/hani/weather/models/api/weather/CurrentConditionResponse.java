
package hani.weather.models.api.weather;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;

public class CurrentConditionResponse extends RealmObject {

    @SerializedName("observation_time")
    @Expose
    private String observationTime;
    @SerializedName("temp_C")
    @Expose
    private String tempC;
    @SerializedName("temp_F")
    @Expose
    private String tempF;
    @SerializedName("weatherCode")
    @Expose
    private String weatherCode;
    @SerializedName("weatherIconUrl")
    @Expose
    private RealmList<WeatherIconUrlResponse> weatherIconUrl = new RealmList<>();
    @SerializedName("weatherDesc")
    @Expose
    private RealmList<WeatherDescResponse> weatherDesc = new RealmList<>();
    @SerializedName("windspeedMiles")
    @Expose
    private String windspeedMiles;
    @SerializedName("windspeedKmph")
    @Expose
    private String windspeedKmph;
    @SerializedName("winddirDegree")
    @Expose
    private String winddirDegree;
    @SerializedName("winddir16Point")
    @Expose
    private String winddir16Point;
    @SerializedName("precipMM")
    @Expose
    private String precipMM;
    @SerializedName("humidity")
    @Expose
    private String humidity;
    @SerializedName("visibility")
    @Expose
    private String visibility;
    @SerializedName("pressure")
    @Expose
    private String pressure;
    @SerializedName("cloudcover")
    @Expose
    private String cloudcover;
    @SerializedName("FeelsLikeC")
    @Expose
    private String feelsLikeC;
    @SerializedName("FeelsLikeF")
    @Expose
    private String feelsLikeF;

    /**
     * 
     * @return
     *     The observationTime
     */
    public String getObservationTime() {
        return observationTime;
    }

    /**
     * 
     * @param observationTime
     *     The observation_time
     */
    public void setObservationTime(String observationTime) {
        this.observationTime = observationTime;
    }

    public CurrentConditionResponse withObservationTime(String observationTime) {
        this.observationTime = observationTime;
        return this;
    }

    /**
     * 
     * @return
     *     The tempC
     */
    public String getTempC() {
        return tempC;
    }

    /**
     * 
     * @param tempC
     *     The temp_C
     */
    public void setTempC(String tempC) {
        this.tempC = tempC;
    }

    public CurrentConditionResponse withTempC(String tempC) {
        this.tempC = tempC;
        return this;
    }

    /**
     * 
     * @return
     *     The tempF
     */
    public String getTempF() {
        return tempF;
    }

    /**
     * 
     * @param tempF
     *     The temp_F
     */
    public void setTempF(String tempF) {
        this.tempF = tempF;
    }

    public CurrentConditionResponse withTempF(String tempF) {
        this.tempF = tempF;
        return this;
    }

    /**
     * 
     * @return
     *     The weatherCode
     */
    public String getWeatherCode() {
        return weatherCode;
    }

    /**
     * 
     * @param weatherCode
     *     The weatherCode
     */
    public void setWeatherCode(String weatherCode) {
        this.weatherCode = weatherCode;
    }

    public CurrentConditionResponse withWeatherCode(String weatherCode) {
        this.weatherCode = weatherCode;
        return this;
    }

    /**
     * 
     * @return
     *     The weatherIconUrl
     */
    public List<WeatherIconUrlResponse> getWeatherIconUrl() {
        return weatherIconUrl;
    }

    /**
     * 
     * @param weatherIconUrl
     *     The weatherIconUrl
     */
    public void setWeatherIconUrl(RealmList<WeatherIconUrlResponse> weatherIconUrl) {
        this.weatherIconUrl = weatherIconUrl;
    }

    public CurrentConditionResponse withWeatherIconUrl(RealmList<WeatherIconUrlResponse> weatherIconUrl) {
        this.weatherIconUrl = weatherIconUrl;
        return this;
    }

    /**
     * 
     * @return
     *     The weatherDesc
     */
    public List<WeatherDescResponse> getWeatherDesc() {
        return weatherDesc;
    }

    /**
     * 
     * @param weatherDesc
     *     The weatherDesc
     */
    public void setWeatherDesc(RealmList<WeatherDescResponse> weatherDesc) {
        this.weatherDesc = weatherDesc;
    }

    public CurrentConditionResponse withWeatherDesc(RealmList<WeatherDescResponse> weatherDesc) {
        this.weatherDesc = weatherDesc;
        return this;
    }

    /**
     * 
     * @return
     *     The windspeedMiles
     */
    public String getWindspeedMiles() {
        return windspeedMiles;
    }

    /**
     * 
     * @param windspeedMiles
     *     The windspeedMiles
     */
    public void setWindspeedMiles(String windspeedMiles) {
        this.windspeedMiles = windspeedMiles;
    }

    public CurrentConditionResponse withWindspeedMiles(String windspeedMiles) {
        this.windspeedMiles = windspeedMiles;
        return this;
    }

    /**
     * 
     * @return
     *     The windspeedKmph
     */
    public String getWindspeedKmph() {
        return windspeedKmph;
    }

    /**
     * 
     * @param windspeedKmph
     *     The windspeedKmph
     */
    public void setWindspeedKmph(String windspeedKmph) {
        this.windspeedKmph = windspeedKmph;
    }

    public CurrentConditionResponse withWindspeedKmph(String windspeedKmph) {
        this.windspeedKmph = windspeedKmph;
        return this;
    }

    /**
     * 
     * @return
     *     The winddirDegree
     */
    public String getWinddirDegree() {
        return winddirDegree;
    }

    /**
     * 
     * @param winddirDegree
     *     The winddirDegree
     */
    public void setWinddirDegree(String winddirDegree) {
        this.winddirDegree = winddirDegree;
    }

    public CurrentConditionResponse withWinddirDegree(String winddirDegree) {
        this.winddirDegree = winddirDegree;
        return this;
    }

    /**
     * 
     * @return
     *     The winddir16Point
     */
    public String getWinddir16Point() {
        return winddir16Point;
    }

    /**
     * 
     * @param winddir16Point
     *     The winddir16Point
     */
    public void setWinddir16Point(String winddir16Point) {
        this.winddir16Point = winddir16Point;
    }

    public CurrentConditionResponse withWinddir16Point(String winddir16Point) {
        this.winddir16Point = winddir16Point;
        return this;
    }

    /**
     * 
     * @return
     *     The precipMM
     */
    public String getPrecipMM() {
        return precipMM;
    }

    /**
     * 
     * @param precipMM
     *     The precipMM
     */
    public void setPrecipMM(String precipMM) {
        this.precipMM = precipMM;
    }

    public CurrentConditionResponse withPrecipMM(String precipMM) {
        this.precipMM = precipMM;
        return this;
    }

    /**
     * 
     * @return
     *     The humidity
     */
    public String getHumidity() {
        return humidity;
    }

    /**
     * 
     * @param humidity
     *     The humidity
     */
    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public CurrentConditionResponse withHumidity(String humidity) {
        this.humidity = humidity;
        return this;
    }

    /**
     * 
     * @return
     *     The visibility
     */
    public String getVisibility() {
        return visibility;
    }

    /**
     * 
     * @param visibility
     *     The visibility
     */
    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    public CurrentConditionResponse withVisibility(String visibility) {
        this.visibility = visibility;
        return this;
    }

    /**
     * 
     * @return
     *     The pressure
     */
    public String getPressure() {
        return pressure;
    }

    /**
     * 
     * @param pressure
     *     The pressure
     */
    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public CurrentConditionResponse withPressure(String pressure) {
        this.pressure = pressure;
        return this;
    }

    /**
     * 
     * @return
     *     The cloudcover
     */
    public String getCloudcover() {
        return cloudcover;
    }

    /**
     * 
     * @param cloudcover
     *     The cloudcover
     */
    public void setCloudcover(String cloudcover) {
        this.cloudcover = cloudcover;
    }

    public CurrentConditionResponse withCloudcover(String cloudcover) {
        this.cloudcover = cloudcover;
        return this;
    }

    /**
     * 
     * @return
     *     The feelsLikeC
     */
    public String getFeelsLikeC() {
        return feelsLikeC;
    }

    /**
     * 
     * @param feelsLikeC
     *     The FeelsLikeC
     */
    public void setFeelsLikeC(String feelsLikeC) {
        this.feelsLikeC = feelsLikeC;
    }

    public CurrentConditionResponse withFeelsLikeC(String feelsLikeC) {
        this.feelsLikeC = feelsLikeC;
        return this;
    }

    /**
     * 
     * @return
     *     The feelsLikeF
     */
    public String getFeelsLikeF() {
        return feelsLikeF;
    }

    /**
     * 
     * @param feelsLikeF
     *     The FeelsLikeF
     */
    public void setFeelsLikeF(String feelsLikeF) {
        this.feelsLikeF = feelsLikeF;
    }

    public CurrentConditionResponse withFeelsLikeF(String feelsLikeF) {
        this.feelsLikeF = feelsLikeF;
        return this;
    }

}
