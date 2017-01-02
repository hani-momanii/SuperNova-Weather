
package hani.weather.models.api.weather;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;

public class WeatherResponse extends RealmObject {

    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("maxtempC")
    @Expose
    private String maxtempC;
    @SerializedName("mintempC")
    @Expose
    private String mintempC;
    @SerializedName("hourly")
    @Expose
    private RealmList<HourlyResponse> hourly = new RealmList<HourlyResponse>();

    /**
     * 
     * @return
     *     The date
     */
    public String getDate() {
        return date;
    }

    /**
     * 
     * @param date
     *     The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    public WeatherResponse withDate(String date) {
        this.date = date;
        return this;
    }


    /**
     * 
     * @return
     *     The maxtempC
     */
    public String getMaxtempC() {
        return maxtempC;
    }

    /**
     * 
     * @param maxtempC
     *     The maxtempC
     */
    public void setMaxtempC(String maxtempC) {
        this.maxtempC = maxtempC;
    }

    public WeatherResponse withMaxtempC(String maxtempC) {
        this.maxtempC = maxtempC;
        return this;
    }

    /**
     * 
     * @return
     *     The mintempC
     */
    public String getMintempC() {
        return mintempC;
    }

    /**
     * 
     * @param mintempC
     *     The mintempC
     */
    public void setMintempC(String mintempC) {
        this.mintempC = mintempC;
    }

    public WeatherResponse withMintempC(String mintempC) {
        this.mintempC = mintempC;
        return this;
    }

    /**
     * 
     * @return
     *     The hourly
     */
    public List<HourlyResponse> getHourly() {
        return hourly;
    }

    /**
     * 
     * @param hourly
     *     The hourly
     */
    public void setHourly(RealmList<HourlyResponse> hourly) {
        this.hourly = hourly;
    }

    public WeatherResponse withHourly(RealmList<HourlyResponse> hourly) {
        this.hourly = hourly;
        return this;
    }

}
