package hani.weather.fragments;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Random;

import hani.weather.R;
import hani.weather.activities.CitiesActivity;
import hani.weather.activities.MainActivity;
import hani.weather.adapters.ForecastAdapter;
import hani.weather.apimanger.ApiHelper;
import hani.weather.callbacks.WeatherForecastCallback;
import hani.weather.customviews.ResizeAnimation;
import hani.weather.models.City;
import hani.weather.models.Weather;
import hani.weather.models.api.weather.CurrentConditionResponse;
import hani.weather.utils.Constants;
import hani.weather.utils.DatabaseController;
import hani.weather.utils.Utility;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WeatherFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WeatherFragment extends Fragment implements WeatherForecastCallback, SwipeRefreshLayout.OnRefreshListener {
    private OnFragmentInteractionListener onFragmentInteraction;
    private City city;
    private RelativeLayout currentWeatherParentLayout, parentLayout;
    private NestedScrollView itemsScrollView;
    private Weather weather;
    private LinearLayout detailsLayout;
    private CurrentConditionResponse currentCondition;
    private TextView weeklyForecast, currentTemp, currentDes, detailsDescriptionTextView, currentConditionTempValue, currentConditionFeelsLikeValue, currentConditionWindSpeedValue, currentConditionCloudValue, currentConditionVisibilityValue, currentConditionHumidityValue;
    private ImageView currentDetailsIcon, backgroundImageView, toolbarCountries;
    private Toolbar toolbar;
    private TextView toolBarTitle, toolbarTime;
    private RecyclerView forecastRecyclerView;
    private ForecastAdapter forecastAdapter;
    private LinearSnapHelper snapHelper;
    private float SCROLL_VIEW_INITIAL_OFFSET = 600.0f;
    private boolean isOffline = false;
    private WeatherForecastCallback weatherCallback;
    private
    SwipeRefreshLayout swipeRefreshLayout;
    private int[] backgrounds = {R.drawable.bg1, R.drawable.bg3, R.drawable.bg4, R.drawable.bg5, R.drawable.bg6};

    public static WeatherFragment newInstance(City _city) {
        WeatherFragment fragment = new WeatherFragment();
        Bundle args = new Bundle();
        args.putParcelable(Constants.CITY_TAG, _city);
        fragment.setArguments(args);
        return fragment;
    }

    public WeatherFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            city = getArguments().getParcelable(Constants.CITY_TAG);
        }
        if (Utility.checkInternetConnection(getContext())) {
            ApiHelper.getInstance(getActivity().getApplication()).getWeatherForecast(city, this);
        } else {
            isOffline = true;
            List<Weather> temp = DatabaseController.with(getActivity().getApplication()).getWeather(city);
            weather = temp.get(temp.size() - 1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather, container, false);
        setViewsIds(view);
        return view;
    }

    private int randomBackground() {
        final Random rand = new Random();
        int diceRoll = rand.nextInt(4) + 0;
        return backgrounds[diceRoll];
    }

    private void setViewsIds(View view) {
        weatherCallback = this;
        detailsLayout = (LinearLayout) view.findViewById(R.id.details_layout);
        parentLayout = (RelativeLayout) view.findViewById(R.id.parent_layout);
        currentWeatherParentLayout = (RelativeLayout) view.findViewById(R.id.current_weather_parent_layout);
        itemsScrollView = (NestedScrollView) view.findViewById(R.id.items_scroll_view);

        backgroundImageView = (ImageView) view.findViewById(R.id.background_image_view);
        Glide.with(getActivity()).load(randomBackground()).centerCrop().into(backgroundImageView);
        currentDetailsIcon = (ImageView) view.findViewById(R.id.current_details_icon);
        currentTemp = (TextView) view.findViewById(R.id.current_temperature_text_view);
        currentDes = (TextView) view.findViewById(R.id.current_description_text_view);
        detailsDescriptionTextView = (TextView) view.findViewById(R.id.details_description_textView);
        weeklyForecast = (TextView) view.findViewById(R.id.weekly_forecast);
        currentConditionTempValue = (TextView) view.findViewById(R.id.current_condition_temp_c_value);
        currentConditionFeelsLikeValue = (TextView) view.findViewById(R.id.current_condition_feels_like_value);
        currentConditionWindSpeedValue = (TextView) view.findViewById(R.id.current_condition_wind_speed_value);
        currentConditionCloudValue = (TextView) view.findViewById(R.id.current_condition_cloud_value);
        currentConditionVisibilityValue = (TextView) view.findViewById(R.id.current_condition_visibility_value);
        currentConditionHumidityValue = (TextView) view.findViewById(R.id.current_condition_humidity_value);
        swipeRefreshLayout = (SwipeRefreshLayout) view.findViewById(R.id.swipe_refresh_layout);

        forecastRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);

        ViewTreeObserver vto = parentLayout.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                parentLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);

                ResizeAnimation resizeAnimation = new ResizeAnimation(
                        currentWeatherParentLayout,
                        parentLayout.getHeight() - currentWeatherParentLayout.getHeight() - itemsScrollView.getPaddingTop(),
                        currentWeatherParentLayout.getHeight()
                );
                resizeAnimation.setDuration(1500);
                currentWeatherParentLayout.startAnimation(resizeAnimation);

                // currentWeatherParentLayout.setMinimumHeight(parentLayout.getHeight() - itemsScrollView.getPaddingTop());
            }
        });

        if (isOffline) {
            currentWeatherParentLayout.setVisibility(View.GONE);
            detailsLayout.setVisibility(View.GONE);
        } else {
            setParlexEffict(view);
        }
        swipeRefreshLayout.setOnRefreshListener(this);
        configureToolbar(view);
        setViewsValues();
    }

    private void setViewsValues() {
        if (currentCondition != null) {

            int icon = Utility.getImageIdFromDescription(currentCondition.getWeatherDesc().get(0).getValue());

            currentTemp.setText(currentCondition.getTempC() + (char) 0x00B0);
            currentDes.setText(currentCondition.getWeatherDesc().get(0).getValue());
            currentDes.setCompoundDrawablesWithIntrinsicBounds(icon, 0, 0, 0);
            detailsDescriptionTextView.setText(currentCondition.getWeatherDesc().get(0).getValue());
            currentConditionTempValue.setText(currentCondition.getTempC() + (char) 0x00B0);
            currentConditionFeelsLikeValue.setText(currentCondition.getFeelsLikeC() + (char) 0x00B0);
            currentConditionWindSpeedValue.setText(currentCondition.getWindspeedKmph() + " kmph");
            currentConditionCloudValue.setText(currentCondition.getCloudcover());
            currentConditionVisibilityValue.setText(currentCondition.getVisibility());
            currentConditionHumidityValue.setText(currentCondition.getHumidity());
            currentDetailsIcon.setImageResource(icon);
        }
        if (weather != null) {
            forecastAdapter = new ForecastAdapter(getContext(), weather);
            forecastRecyclerView.setAdapter(forecastAdapter);
            setSnapHelper();
            if (!isOffline) {
                weeklyForecast.setText(R.string.forecast_swipe);
                LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
                forecastRecyclerView.setLayoutManager(layoutManager);
            } else {
                weeklyForecast.setText(R.string.forecast);
                forecastRecyclerView.setNestedScrollingEnabled(false);
                forecastRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            }
        }


    }


    private void setParlexEffict(final View view) {

        itemsScrollView.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                new Thread(new Runnable() {
                    public void run() {
                        float scrollY = (itemsScrollView.getScrollY() / (float) 10.0);
                        float blurredImageAlpha = scrollY / SCROLL_VIEW_INITIAL_OFFSET;

                        if (blurredImageAlpha > 0.8) {

                            blurredImageAlpha = (float) 0.8;
                        }
                        try {
                            final float finalBlurredImageAlpha = blurredImageAlpha;
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    ((View) view.findViewById(R.id.background_image_white)).setAlpha(finalBlurredImageAlpha);
                                }
                            });
                        } catch (NullPointerException exception) {

                        }
                    }
                }).start();


            }
        });


    }

    private void setSnapHelper() {

        if (snapHelper == null) {
            snapHelper = new LinearSnapHelper() {
                @Override
                public int findTargetSnapPosition(RecyclerView.LayoutManager layoutManager, int velocityX, int velocityY) {
                    View centerView = findSnapView(layoutManager);
                    if (centerView == null) {
                        return RecyclerView.NO_POSITION;
                    }

                    int position = layoutManager.getPosition(centerView);
                    int targetPosition = -1;
                    if (layoutManager.canScrollHorizontally()) {
                        if (velocityX < 0) {
                            targetPosition = position - 1;
                        } else {
                            targetPosition = position + 1;
                        }
                    }

                    if (layoutManager.canScrollVertically()) {
                        if (velocityY < 0) {
                            targetPosition = position - 1;
                        } else {
                            targetPosition = position + 1;
                        }
                    }

                    final int firstItem = 0;
                    final int lastItem = layoutManager.getItemCount() - 1;
                    targetPosition = Math.min(lastItem, Math.max(targetPosition, firstItem));
                    return targetPosition;
                }
            };
            snapHelper.attachToRecyclerView(forecastRecyclerView);
        }
    }

    @Override
    public void onWeatherForecastLoadedSusses(CurrentConditionResponse currentCondition, Weather weather) {
        this.weather = weather;
        this.currentCondition = currentCondition;
        setViewsValues();
        isOffline = false;
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void onWeatherForecastLoadedFailed(String errorCode) {
        try {
            swipeRefreshLayout.setRefreshing(false);
            List<Weather> temp = DatabaseController.with(getActivity().getApplication()).getWeather(city);
            weather = temp.get(temp.size() - 1);
            isOffline = true;
            setViewsValues();
        } catch (Exception ex) {
            Toast.makeText(getContext(), errorCode, Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            onFragmentInteraction = (OnFragmentInteractionListener) context;
        } catch (ClassCastException e) {
            Utility.log(" must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onFragmentInteraction = null;
    }

    private void configureToolbar(View view) {
        toolbar = (Toolbar) view.findViewById(R.id.custom_toolbar);
        if (toolbar != null) {
            toolbarTime = (TextView) toolbar.findViewById(R.id.toolbar_time);
            toolBarTitle = (TextView) toolbar.findViewById(R.id.toolbar_city);
            toolBarTitle.setText(city.getCityName());
            toolbarTime.setText(Utility.getLocalTime("" + city.getTimeZone()));
            toolbarCountries = (ImageView) toolbar.findViewById(R.id.country_image_view);
            toolbarCountries.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onFragmentInteraction.onFragmentInteraction();
                }
            });


        }
    }

    @Override
    public void onRefresh() {
        if (Utility.checkInternetConnection(getContext())) {
            swipeRefreshLayout.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            swipeRefreshLayout.setRefreshing(true);
                                            ApiHelper.getInstance(getActivity().getApplication()).getWeatherForecast(city, weatherCallback);
                                        }
                                    }
            );
        } else {
            swipeRefreshLayout.setRefreshing(false);
        }
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction();
    }
}
