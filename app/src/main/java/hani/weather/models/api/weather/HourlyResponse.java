
package hani.weather.models.api.weather;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;

public class HourlyResponse  extends RealmObject {

    @SerializedName("time")
    @Expose
    private String time;
    @SerializedName("tempC")
    @Expose
    private String tempC;
    @SerializedName("windspeedKmph")
    @Expose
    private String windspeedKmph;
    @SerializedName("weatherCode")
    @Expose
    private String weatherCode;
    @SerializedName("weatherIconUrl")
    @Expose
    private RealmList<WeatherIconUrlResponse> weatherIconUrl = new RealmList<WeatherIconUrlResponse>();
    @SerializedName("weatherDesc")
    @Expose
    private RealmList<WeatherDescResponse> weatherDesc = new RealmList<WeatherDescResponse>();
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
    @SerializedName("HeatIndexC")
    @Expose
    private String heatIndexC;
    @SerializedName("WindGustKmph")
    @Expose
    private String windGustKmph;
    @SerializedName("FeelsLikeC")
    @Expose
    private String feelsLikeC;
    @SerializedName("chanceofrain")
    @Expose
    private String chanceofrain;
    @SerializedName("chanceofremdry")
    @Expose
    private String chanceofremdry;
    @SerializedName("chanceofwindy")
    @Expose
    private String chanceofwindy;
    @SerializedName("chanceofovercast")
    @Expose
    private String chanceofovercast;
    @SerializedName("chanceofsunshine")
    @Expose
    private String chanceofsunshine;
    @SerializedName("chanceoffrost")
    @Expose
    private String chanceoffrost;
    @SerializedName("chanceofhightemp")
    @Expose
    private String chanceofhightemp;
    @SerializedName("chanceoffog")
    @Expose
    private String chanceoffog;
    @SerializedName("chanceofsnow")
    @Expose
    private String chanceofsnow;
    @SerializedName("chanceofthunder")
    @Expose
    private String chanceofthunder;

    /**
     * 
     * @return
     *     The time
     */
    public String getTime() {
        return time;
    }

    /**
     * 
     * @param time
     *     The time
     */
    public void setTime(String time) {
        this.time = time;
    }

    public HourlyResponse withTime(String time) {
        this.time = time;
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
     *     The tempC
     */
    public void setTempC(String tempC) {
        this.tempC = tempC;
    }

    public HourlyResponse withTempC(String tempC) {
        this.tempC = tempC;
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

    public HourlyResponse withWindspeedKmph(String windspeedKmph) {
        this.windspeedKmph = windspeedKmph;
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

    public HourlyResponse withWeatherCode(String weatherCode) {
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

    public HourlyResponse withWeatherIconUrl(RealmList<WeatherIconUrlResponse> weatherIconUrl) {
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

    public HourlyResponse withWeatherDesc(RealmList<WeatherDescResponse> weatherDesc) {
        this.weatherDesc = weatherDesc;
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

    public HourlyResponse withHumidity(String humidity) {
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

    public HourlyResponse withVisibility(String visibility) {
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

    public HourlyResponse withPressure(String pressure) {
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

    public HourlyResponse withCloudcover(String cloudcover) {
        this.cloudcover = cloudcover;
        return this;
    }

    /**
     * 
     * @return
     *     The heatIndexC
     */
    public String getHeatIndexC() {
        return heatIndexC;
    }

    /**
     * 
     * @param heatIndexC
     *     The HeatIndexC
     */
    public void setHeatIndexC(String heatIndexC) {
        this.heatIndexC = heatIndexC;
    }

    public HourlyResponse withHeatIndexC(String heatIndexC) {
        this.heatIndexC = heatIndexC;
        return this;
    }

    /**
     * 
     * @return
     *     The windGustKmph
     */
    public String getWindGustKmph() {
        return windGustKmph;
    }

    /**
     * 
     * @param windGustKmph
     *     The WindGustKmph
     */
    public void setWindGustKmph(String windGustKmph) {
        this.windGustKmph = windGustKmph;
    }

    public HourlyResponse withWindGustKmph(String windGustKmph) {
        this.windGustKmph = windGustKmph;
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

    public HourlyResponse withFeelsLikeC(String feelsLikeC) {
        this.feelsLikeC = feelsLikeC;
        return this;
    }
    /**
     * 
     * @return
     *     The chanceofrain
     */
    public String getChanceofrain() {
        return chanceofrain;
    }

    /**
     * 
     * @param chanceofrain
     *     The chanceofrain
     */
    public void setChanceofrain(String chanceofrain) {
        this.chanceofrain = chanceofrain;
    }

    public HourlyResponse withChanceofrain(String chanceofrain) {
        this.chanceofrain = chanceofrain;
        return this;
    }

    /**
     * 
     * @return
     *     The chanceofremdry
     */
    public String getChanceofremdry() {
        return chanceofremdry;
    }

    /**
     * 
     * @param chanceofremdry
     *     The chanceofremdry
     */
    public void setChanceofremdry(String chanceofremdry) {
        this.chanceofremdry = chanceofremdry;
    }

    public HourlyResponse withChanceofremdry(String chanceofremdry) {
        this.chanceofremdry = chanceofremdry;
        return this;
    }

    /**
     * 
     * @return
     *     The chanceofwindy
     */
    public String getChanceofwindy() {
        return chanceofwindy;
    }

    /**
     * 
     * @param chanceofwindy
     *     The chanceofwindy
     */
    public void setChanceofwindy(String chanceofwindy) {
        this.chanceofwindy = chanceofwindy;
    }

    public HourlyResponse withChanceofwindy(String chanceofwindy) {
        this.chanceofwindy = chanceofwindy;
        return this;
    }

    /**
     * 
     * @return
     *     The chanceofovercast
     */
    public String getChanceofovercast() {
        return chanceofovercast;
    }

    /**
     * 
     * @param chanceofovercast
     *     The chanceofovercast
     */
    public void setChanceofovercast(String chanceofovercast) {
        this.chanceofovercast = chanceofovercast;
    }

    public HourlyResponse withChanceofovercast(String chanceofovercast) {
        this.chanceofovercast = chanceofovercast;
        return this;
    }

    /**
     * 
     * @return
     *     The chanceofsunshine
     */
    public String getChanceofsunshine() {
        return chanceofsunshine;
    }

    /**
     * 
     * @param chanceofsunshine
     *     The chanceofsunshine
     */
    public void setChanceofsunshine(String chanceofsunshine) {
        this.chanceofsunshine = chanceofsunshine;
    }

    public HourlyResponse withChanceofsunshine(String chanceofsunshine) {
        this.chanceofsunshine = chanceofsunshine;
        return this;
    }

    /**
     * 
     * @return
     *     The chanceoffrost
     */
    public String getChanceoffrost() {
        return chanceoffrost;
    }

    /**
     * 
     * @param chanceoffrost
     *     The chanceoffrost
     */
    public void setChanceoffrost(String chanceoffrost) {
        this.chanceoffrost = chanceoffrost;
    }

    public HourlyResponse withChanceoffrost(String chanceoffrost) {
        this.chanceoffrost = chanceoffrost;
        return this;
    }

    /**
     * 
     * @return
     *     The chanceofhightemp
     */
    public String getChanceofhightemp() {
        return chanceofhightemp;
    }

    /**
     * 
     * @param chanceofhightemp
     *     The chanceofhightemp
     */
    public void setChanceofhightemp(String chanceofhightemp) {
        this.chanceofhightemp = chanceofhightemp;
    }

    public HourlyResponse withChanceofhightemp(String chanceofhightemp) {
        this.chanceofhightemp = chanceofhightemp;
        return this;
    }

    /**
     * 
     * @return
     *     The chanceoffog
     */
    public String getChanceoffog() {
        return chanceoffog;
    }

    /**
     * 
     * @param chanceoffog
     *     The chanceoffog
     */
    public void setChanceoffog(String chanceoffog) {
        this.chanceoffog = chanceoffog;
    }

    public HourlyResponse withChanceoffog(String chanceoffog) {
        this.chanceoffog = chanceoffog;
        return this;
    }

    /**
     * 
     * @return
     *     The chanceofsnow
     */
    public String getChanceofsnow() {
        return chanceofsnow;
    }

    /**
     * 
     * @param chanceofsnow
     *     The chanceofsnow
     */
    public void setChanceofsnow(String chanceofsnow) {
        this.chanceofsnow = chanceofsnow;
    }

    public HourlyResponse withChanceofsnow(String chanceofsnow) {
        this.chanceofsnow = chanceofsnow;
        return this;
    }

    /**
     * 
     * @return
     *     The chanceofthunder
     */
    public String getChanceofthunder() {
        return chanceofthunder;
    }

    /**
     * 
     * @param chanceofthunder
     *     The chanceofthunder
     */
    public void setChanceofthunder(String chanceofthunder) {
        this.chanceofthunder = chanceofthunder;
    }

    public HourlyResponse withChanceofthunder(String chanceofthunder) {
        this.chanceofthunder = chanceofthunder;
        return this;
    }

}
