
package hani.weather.models.api.city;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;

public class CityResponse  extends RealmObject {

    @SerializedName("search_api")
    @Expose
    private SearchApiResponse searchApi;

    /**
     * 
     * @return
     *     The searchApi
     */
    public SearchApiResponse getSearchApi() {
        return searchApi;
    }

    /**
     * 
     * @param searchApi
     *     The search_api
     */
    public void setSearchApi(SearchApiResponse searchApi) {
        this.searchApi = searchApi;
    }

    public CityResponse withSearchApi(SearchApiResponse searchApi) {
        this.searchApi = searchApi;
        return this;
    }

}
