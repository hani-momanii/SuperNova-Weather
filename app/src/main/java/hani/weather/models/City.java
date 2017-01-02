package hani.weather.models;

import android.os.Parcel;
import android.os.Parcelable;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by hani.momanii on 9/2/16.
 */
public class City extends RealmObject implements Parcelable {

    @PrimaryKey
    private String id;

    private String cityName;

    private String countryName;

    private double timeZone;

    private String region;

    public City(){};

    public City(String id,String cityName, String countryName,String region , double timeZone) {
        this.cityName = cityName;
        this.countryName = countryName;
        this.region=region;
        this.id=id;
        this.timeZone = timeZone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setTimeZone(double timeZone) {
        this.timeZone = timeZone;
    }

    public String getCityName() {
        return cityName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountryName() {
        return countryName;
    }

    public double getTimeZone() {
        return timeZone;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.cityName);
        dest.writeString(this.countryName);
        dest.writeDouble(this.timeZone);
        dest.writeString(this.region);
    }

    protected City(Parcel in) {
        this.id = in.readString();
        this.cityName = in.readString();
        this.countryName = in.readString();
        this.timeZone = in.readDouble();
        this.region = in.readString();
    }

    public static final Parcelable.Creator<City> CREATOR = new Parcelable.Creator<City>() {
        @Override
        public City createFromParcel(Parcel source) {
            return new City(source);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };
}