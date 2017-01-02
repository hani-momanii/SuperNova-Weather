
package hani.weather.models.api.city;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class TimezoneResponse  extends RealmObject {

    @SerializedName("offset")
    @Expose
    private String offset;

    /**
     * 
     * @return
     *     The offset
     */
    public String getOffset() {
        return offset;
    }

    /**
     * 
     * @param offset
     *     The offset
     */
    public void setOffset(String offset) {
        this.offset = offset;
    }

    public TimezoneResponse withOffset(String offset) {
        this.offset = offset;
        return this;
    }

}
