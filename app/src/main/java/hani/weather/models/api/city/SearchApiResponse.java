
package hani.weather.models.api.city;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import hani.weather.models.City;
import io.realm.RealmList;
import io.realm.RealmObject;

public class SearchApiResponse  extends RealmObject {

    @SerializedName("result")
    @Expose
    private RealmList<ResultResponse> cities = new RealmList<ResultResponse>();

    /**
     * 
     * @return
     *     The result
     */
    public RealmList<ResultResponse> getResult() {
        return cities;
    }

    /**
     * 
     * @param result
     *     The result
     */
    public void setResult(RealmList<ResultResponse> result) {
        this.cities = result;
    }

    public SearchApiResponse withResult(RealmList<ResultResponse> result) {
        this.cities = result;
        return this;
    }

}
