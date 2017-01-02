
package hani.weather.models.api.city;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmList;
import io.realm.RealmObject;

public class ResultResponse  extends RealmObject {

    @SerializedName("areaName")
    @Expose
    private RealmList<AreaNameResponse> areaName = new RealmList<AreaNameResponse>();

    @SerializedName("country")
    @Expose
    private RealmList<CountryResponse> country = new RealmList<CountryResponse>();

    @SerializedName("region")
    @Expose
    private RealmList<RegionResponse> region = new RealmList<RegionResponse>();

    @SerializedName("latitude")
    @Expose
    private String latitude;

    @SerializedName("longitude")
    @Expose
    private String longitude;

    @SerializedName("population")
    @Expose
    private String population;

    @SerializedName("weatherUrl")
    @Expose
    private RealmList<WeatherUrlResponse> weatherUrl = new RealmList<WeatherUrlResponse>();

    @SerializedName("timezone")
    @Expose
    private TimezoneResponse timezone;

    /**
     * 
     * @return
     *     The areaName
     */
    public List<AreaNameResponse> getAreaName() {
        return areaName;
    }

    /**
     * 
     * @param areaName
     *     The areaName
     */
    public void setAreaName(RealmList<AreaNameResponse> areaName) {
        this.areaName = areaName;
    }

    public ResultResponse withAreaName(RealmList<AreaNameResponse> areaName) {
        this.areaName = areaName;
        return this;
    }

    /**
     * 
     * @return
     *     The country
     */
    public List<CountryResponse> getCountry() {
        return country;
    }

    /**
     * 
     * @param country
     *     The country
     */
    public void setCountry(RealmList<CountryResponse> country) {
        this.country = country;
    }

    public ResultResponse withCountry(RealmList<CountryResponse> country) {
        this.country = country;
        return this;
    }

    /**
     * 
     * @return
     *     The region
     */
    public List<RegionResponse> getRegion() {
        return region;
    }

    /**
     * 
     * @param region
     *     The region
     */
    public void setRegion(RealmList<RegionResponse> region) {
        this.region = region;
    }

    public ResultResponse withRegion(RealmList<RegionResponse> region) {
        this.region = region;
        return this;
    }

    /**
     * 
     * @return
     *     The latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * 
     * @param latitude
     *     The latitude
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public ResultResponse withLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    /**
     * 
     * @return
     *     The longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     * 
     * @param longitude
     *     The longitude
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public ResultResponse withLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

    /**
     * 
     * @return
     *     The population
     */
    public String getPopulation() {
        return population;
    }

    /**
     * 
     * @param population
     *     The population
     */
    public void setPopulation(String population) {
        this.population = population;
    }

    public ResultResponse withPopulation(String population) {
        this.population = population;
        return this;
    }

    /**
     * 
     * @return
     *     The weatherUrl
     */
    public List<WeatherUrlResponse> getWeatherUrl() {
        return weatherUrl;
    }

    /**
     * 
     * @param weatherUrl
     *     The weatherUrl
     */
    public void setWeatherUrl(RealmList<WeatherUrlResponse> weatherUrl) {
        this.weatherUrl = weatherUrl;
    }

    public ResultResponse withWeatherUrl(RealmList<WeatherUrlResponse> weatherUrl) {
        this.weatherUrl = weatherUrl;
        return this;
    }

    /**
     * 
     * @return
     *     The timezone
     */
    public TimezoneResponse getTimezone() {
        return timezone;
    }

    /**
     * 
     * @param timezone
     *     The timezone
     */
    public void setTimezone(TimezoneResponse timezone) {
        this.timezone = timezone;
    }

    public ResultResponse withTimezone(TimezoneResponse timezone) {
        this.timezone = timezone;
        return this;
    }

}
