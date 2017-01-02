package hani.weather.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import hani.weather.BuildConfig;
import hani.weather.R;

/**
 * Created by hani.momanii on 9/4/16.
 */
public class Utility {

    public static void log(String message) {
        if (BuildConfig.DEBUG) {
            Log.e(Constants.TAG, message);
        }
    }

    public static String getDayNameFromDate(String dateString) {
        SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        String day = null;
        try {
            date = inFormat.parse(dateString);
            SimpleDateFormat outFormat = new SimpleDateFormat("EEEE");
            day = outFormat.format(date);
        } catch (ParseException e) {
            day = "Next Few Days";
        } finally {
            return day;
        }
    }

    public static boolean checkInternetConnection(Context context) {
        ConnectivityManager
                cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        return activeNetwork != null
                && activeNetwork.isConnectedOrConnecting();
    }

    public static String getLocalTime(String timeZone) {

        String sign = "";
        if (timeZone.contains("-")) {
            sign = "-";
            timeZone = timeZone.substring(timeZone.indexOf("-") + 1);
        } else {
            sign = "+";
        }

        timeZone = timeZone.replace(".", ",");
        String pattern = "00.00";
        DecimalFormatSymbols dfs = new DecimalFormatSymbols();
        dfs.setGroupingSeparator('.');
        DecimalFormat formatter = new DecimalFormat(pattern, dfs);

        try {
            timeZone = formatter.format(formatter.parse(timeZone));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        timeZone = timeZone.replace(".", ":");
        timeZone = "GMT" + sign + timeZone;
        TimeZone tz = TimeZone.getTimeZone(timeZone);
        Calendar c = Calendar.getInstance(tz);
        String time2 = String.format("%02d", c.get(Calendar.HOUR_OF_DAY)) + ":" +
                String.format("%02d", c.get(Calendar.MINUTE));
        return convertTimeFormat(time2);
    }


    public static String convertTimeFormat(String time){
        try {
            final SimpleDateFormat sdf = new SimpleDateFormat("H:mm");
            final Date dateObj = sdf.parse(time);
            return new SimpleDateFormat("K:mm a").format(dateObj);
        } catch (final ParseException e) {
            e.printStackTrace();
            return time;
        }
    }


    public static int getImageIdFromDescription(String str) {
        str = str.replaceAll("\\W", "");

        switch (str.trim().toLowerCase()) {
            case "sunny":
                return R.drawable.ic_weather_sunny;

            case "clear":
                return R.drawable.ic_weather_night;

            case "partlycloudy":
                return R.drawable.ic_weather_partlycloudy;

            case "cloudy":
                return R.drawable.ic_weather_cloudy;

            case "overcast":
            case "mist":
                return R.drawable.ic_weather_windy;

            case "patchyfreezingdrizzlenearby":
            case "patchysleetnearby":
            case "patchysnownearby":
            case "moderatesnow":
            case "patchymoderatesnow":
            case "patchyrainnearby":
                return R.drawable.ic_weather_pouring;

            case "thunderyoutbreaksinnearby":
            case "moderateorheavysnowinareawiththunder":
            case "patchylightsnowinareawiththunder":
            case "moderateorheavyraininareawiththunder":
            case "patchylightraininareawiththunder":
                return R.drawable.ic_weather_lightning;

            case "blizzard":
            case "blowingsnow":
                return R.drawable.ic_weather_windy_variant;

            case "freezingfog":
            case "fog":
                return R.drawable.weather_35_36;

            case "heavyfreezingdrizzle":
            case "lightsleet":
            case "lightdrizzle":
            case "patchylightdrizzle":
                return R.drawable.weather_31_32_33_34;

            case "moderateorheavysleet":
            case "freezingdrizzle":
            case "moderateorheavysleetshowers":
            case "moderateorHeavyfreezingrain":
            case "lightsnowshowers":
            case "lightsleetshowers":
            case "moderateorheavyshowersoficepellets":
            case "lightshowersoficepellets":
            case "icepellets":
                return R.drawable.ic_weather_hail;

            case "moderateorheavysnowshowers":
            case "heavysnow":
            case "patchyheavysnow":
            case "patchylightsnow":
            case "lightsnow":
                return R.drawable.ic_weather_snowy;

            case "torrentialrainshower":
            case "moderateorheavyrainshower":
            case "heavyrain":
            case "heavyrainattimes":
            case "moderaterain":
            case "moderaterainattimes":
            case "lightrain":
            case "patchylightrain":
                return R.drawable.ic_weather_rainy;

            default:
                return R.drawable.ic_weather_partlycloudy;

        }

    }

}
