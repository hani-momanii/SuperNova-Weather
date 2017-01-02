
package hani.weather.models.api.weather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class WeatherDescResponse extends RealmObject {

    @SerializedName("value")
    @Expose
    private String value;

    /**
     * 
     * @return
     *     The value
     */
    public String getValue() {
        return value;
    }

    /**
     * 
     * @param value
     *     The value
     */
    public void setValue(String value) {
        this.value = value;
    }

    public WeatherDescResponse withValue(String value) {
        this.value = value;
        return this;
    }

}
