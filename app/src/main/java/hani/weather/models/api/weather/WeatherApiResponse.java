
package hani.weather.models.api.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class WeatherApiResponse  extends RealmObject {

    @SerializedName("data")
    @Expose
    private DataResponse data;

    /**
     * 
     * @return
     *     The data
     */
    public DataResponse getData() {
        return data;
    }

    /**
     * 
     * @param data
     *     The data
     */
    public void setData(DataResponse data) {
        this.data = data;
    }

    public WeatherApiResponse withData(DataResponse data) {
        this.data = data;
        return this;
    }

}
