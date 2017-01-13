package hani.weather.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import hani.weather.BuildConfig;
import hani.weather.R;
import hani.weather.models.City;
import hani.weather.utils.Constants;
import hani.weather.utils.DatabaseController;
import hani.weather.utils.Utility;

public class SplashActivity extends AppCompatActivity {

    private TextView error_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        error_text = (TextView) findViewById(R.id.error_text);
        checkFirstRun();
    }


    public void checkFirstRun() {
        SharedPreferences prefs = getSharedPreferences(getPackageName(), MODE_PRIVATE);
        if (prefs.getBoolean(Constants.IS_FIRST_RUN, true)) {
            if (Utility.checkInternetConnection(getApplicationContext())) {

                Utility.log("First run");
                try {
                    List<City> cities = new ArrayList<>();
                    City ammanCity = new City("AmmanAmman Governorate", "Amman", "Jordan", "Amman Governorate", 3.0);
                    City londonCity = new City("LondonCity of London, Greater London", "London", "United Kingdom", "City of London, Greater London", 1.0);
                    City newYorkCity = new City("New YorkNew York", "New York", "United States of America", "New York", -5.0);
                    City barcelonaCity = new City("BarcelonaCatalonia", "Barcelona", "Spain", "Catalonia", -4.0);
                    cities.add(barcelonaCity);
                    cities.add(newYorkCity);
                    cities.add(londonCity);
                    cities.add(ammanCity);

                    DatabaseController.with(getApplication()).addCityList(cities);
                    prefs.edit().putBoolean(Constants.IS_FIRST_RUN, false).commit();
                    startActivity();
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "Something went wrong ! ", Toast.LENGTH_LONG).show();
                }
            } else {
                error_text.setVisibility(View.VISIBLE);
            }
        } else {
            startActivity();
        }
    }


    public void startActivity() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        }, 2000);

    }
}
