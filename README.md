# SuperNova-Weather
This Project contains source code of Weather Android Application, designed similar to [Yahoo Weather App](https://play.google.com/store/apps/details?id=com.yahoo.mobile.client.android.weather), Based on [World Weather Online](https://developer.worldweatheronline.com/api/).

**You need to Change the API key in the *[Constants]( https://github.com/hani-momanii/SuperNova-Weather/blob/2c1eef77fb09984fc76ce18292a1cb2f61022988/app/src/main/java/hani/weather/utils/Constants.java )* class **, get your API key from [World Weather Online](https://developer.worldweatheronline.com/api/).


<p align="center">
<img src ="https://media.giphy.com/media/n3Xo74IbcnrJ6/giphy.gif" />
</p>


# Introduction:
 - This application allow users to view the weather forecast for one
   week.
 - The weather forecast by default available for the four cities
   mentioned in the assignment.
 - This application allow the user to search for city using city name or
   zip code, so the user can add cities as many as he want , also he can
   remove any unwanted city easily .
 - This application store the weather forecast for 7 days from the last
   time the user open the application while the internet available , The
   application need internet access for the first open at least.
 - This application is user friendly, easy to use and simple.

#Application design :
The application use three activities, the SplashActivity with handle the application initialising to add the default cities if the user open the application for the first time then redirect the user to the MainActivity which has a view pager that provide a fragment for every city to display its weather forecast.

Inside the **[WeatherFragment]( https://github.com/hani-momanii/SuperNova-Weather/blob/2c1eef77fb09984fc76ce18292a1cb2f61022988/app/src/main/java/hani/weather/fragments/WeatherFragment.java )** all the main operations happen, it send the request to ApiHelper class and receive the response from it using WeatherForeCastCallBacks then update the views.

The user can add or remove cities from **[CitiesActivity]( https://github.com/hani-momanii/SuperNova-Weather/blob/c84fa6fcf0e4c9df2c421d8dbf1af2365ad727f7/app/src/main/java/hani/weather/activities/CitiesActivity.java )**.

**[ApiHelper]( https://github.com/hani-momanii/SuperNova-Weather/blob/2c1eef77fb09984fc76ce18292a1cb2f61022988/app/src/main/java/hani/weather/apimanger/ApiHelper.java )** mange the API requests, send request data for the ApiInterface and receive the response then store the result if needed then send the data via callbacks.

**[DatabaseController]( https://github.com/hani-momanii/SuperNova-Weather/blob/c84fa6fcf0e4c9df2c421d8dbf1af2365ad727f7/app/src/main/java/hani/weather/utils/DatabaseController.java )** used to mange the data store operations in simple way to use.

**[Utility class]( https://github.com/hani-momanii/SuperNova-Weather/blob/c84fa6fcf0e4c9df2c421d8dbf1af2365ad727f7/app/src/main/java/hani/weather/utils/Utility.java )** provide the common operations, which used in many classes.

**[Constants]( https://github.com/hani-momanii/SuperNova-Weather/blob/2c1eef77fb09984fc76ce18292a1cb2f61022988/app/src/main/java/hani/weather/utils/Constants.java )** provide the needed constants to config the app functionality, for example **if you want to change the days of forecast just change the NUMBER_OF_DAYS_TO_GET value for the needed days number+1 , the 1 is for the current day**.

#Application UX/UI design:

The application design similar to [Yahoo Weather App](https://play.google.com/store/apps/details?id=com.yahoo.mobile.client.android.weather), easy to use and simple, few clicks or actions needed from the user.

All the icons used on the app is from [Material Icon Generator](https://github.com/konifar/android-material-design-icon-generator-plugin).

#Used 3rd party Libraries:
 - [Retrofit]( http://square.github.io/retrofit/) for API calls.
 - [Realm]( https://realm.io/products/java/ ) for storing the cities and weather forecast.
 - [Glide]( https://github.com/bumptech/glide ) for image loading.


## Contact
[![alt text][1.1]][1]
[![alt text][2.1]][2]
[![alt text][6.1]][6]


[1.1]: http://i.imgur.com/tXSoThF.png (twitter icon with padding)
[2.1]: http://i.imgur.com/P3YfQoD.png (facebook icon with padding)
[6.1]: http://i.imgur.com/0o48UoR.png (github icon with padding)


[1]: https://twitter.com/hani_momanii
[2]: https://www.facebook.com/hani.momanii
[6]: https://github.com/hani-momanii


## License

* [Apache Version 2.0](http://www.apache.org/licenses/LICENSE-2.0.html)

```
Copyright 2017 Hani Al-Momani

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
