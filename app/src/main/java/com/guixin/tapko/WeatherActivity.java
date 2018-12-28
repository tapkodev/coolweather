package com.guixin.tapko;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompatSideChannelService;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.guixin.tapko.gson.AQIBean;
import com.guixin.tapko.gson.Weather;
import com.guixin.tapko.util.Httputil;
import com.guixin.tapko.util.Utility;

import java.io.IOException;
import java.util.List;

import interfaces.heweather.com.interfacesmodule.bean.air.now.AirNow;
import interfaces.heweather.com.interfacesmodule.view.HeWeather;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

import static com.guixin.tapko.R.id.swipe_refresh;


public class WeatherActivity extends AppCompatActivity {

    private ScrollView weatherLayout;
    private TextView titleCity;
    private TextView titleUpdateTime;
    private TextView degreeText;
    private TextView weatherInfoText;
    private LinearLayout forecastLayout;
    private TextView aqiText;
    private TextView pm25Text;
    private TextView comfortText;
    private TextView carWashText;
    private TextView sportText;
    private ImageView bingPicImag;
    private SwipeRefreshLayout swipeRefreshLayout;

    private String mWeatherId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        setContentView(R.layout.activity_weather);

        initViews();
        isCacheData();
    }

    /**
     * 初始化界面控件
     */
    private void initViews(){
        weatherLayout = (ScrollView) findViewById(R.id.weather_layout);
        titleCity = (TextView) findViewById(R.id.title_city);
        titleUpdateTime = (TextView) findViewById(R.id.title_update_time);
        degreeText = (TextView) findViewById(R.id.degree_text);
        weatherInfoText = (TextView) findViewById(R.id.weather_info_text);
        forecastLayout = (LinearLayout) findViewById(R.id.forecast_layout);
        aqiText = (TextView) findViewById(R.id.aqi_text);
        pm25Text = (TextView) findViewById(R.id.pm25_text);
        comfortText = (TextView) findViewById(R.id.comfort_text);
        carWashText = (TextView) findViewById(R.id.car_wash_text);
        sportText = (TextView) findViewById(R.id.sport_text);
        bingPicImag = (ImageView) findViewById(R.id.bing_pic_img);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(swipe_refresh);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
       swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getWeatherDateList(mWeatherId);
                getAQINow(mWeatherId);
            }
        });
        titleCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(WeatherActivity.this).edit();
               // editor.clear();
               // editor.commit();
               // Intent intent = new Intent(WeatherActivity.this,MainActivity.class);
               // startActivity(intent);
               // finish();
            }
        });
    }

    /**
     * 判断是否有本地缓存来执行数据的展示
     */
    private void isCacheData(){
       SharedPreferences perfs = PreferenceManager.getDefaultSharedPreferences(this);
        String weatherStr = perfs.getString("weather",null);
        String bingPic = perfs.getString("bing_pic",null);
        String aqiStr = perfs.getString("aqi_bean",null);
        if (bingPic != null){
            Glide.with(WeatherActivity.this).load(bingPic).into(bingPicImag);
        }
        else {
            loadBingPic();
        }

        if (aqiStr != null){
            //有缓存时直接解析天气数据
            AQIBean aqiBean = Utility.handleAQIBeanResponse(aqiStr);
            mWeatherId = aqiBean.getBasic().getCid();
            showAQIInfo(aqiBean);
        }else{
            mWeatherId = getIntent().getStringExtra("weather_id");
            getAQINow(mWeatherId);
        }
        if (weatherStr != null){
            //有缓存时直接解析天气数据
            Weather weather = Utility.handleWeatherResponse(weatherStr);
            mWeatherId = weather.getBasic().getCid();
            showWeatherInfo(weather);

      }else {
            mWeatherId = getIntent().getStringExtra("weather_id");
            weatherLayout.setVisibility(View.INVISIBLE);
            getWeatherDateList(mWeatherId);
       }
    }

    public void getWeatherDateList(String weatherId){

        HeWeather.getWeather(this, weatherId, new HeWeather.OnResultWeatherDataListBeansListener() {
            @Override
            public void onError(final Throwable throwable) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Log.i("Log", "onSuccess: " + throwable.getMessage());

                            Toast.makeText(WeatherActivity.this,"网络错误，获取天气信息失败",Toast.LENGTH_SHORT).show();
                        }
                    });
            }

            @Override
            public void onSuccess( final List<interfaces.heweather.com.interfacesmodule.bean.weather.Weather> list) {
                Log.i("Log", "onSuccess: " +new Gson().toJson(list));
                final Weather weather = Utility.handleWeatherResponse(new Gson().toJson(list));
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (weather != null && "ok".equals(weather.getStatus())){
                            SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(WeatherActivity.this).edit();
                            editor.putString("weather",new Gson().toJson(list));
                            editor.apply();
                            mWeatherId = weather.getBasic().getCid();
                            showWeatherInfo(weather);
                        }else{
                            Toast.makeText(WeatherActivity.this,"获取天气信息失败",Toast.LENGTH_SHORT).show();
                        }
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        });
        loadBingPic();
    }

    /**
     * 处理并展示Weather实体类中的数据
     */
    private void showWeatherInfo(Weather weather){

        String cityName=weather.getBasic().getLocation();
        String updateTime=weather.getUpdate().getLoc().split(" ")[0];
        String degree=weather.getNow().getTmp()+"℃";
        String weatherInfo=weather.getNow().getCond_txt();

        forecastLayout.removeAllViews();

        for (Weather.DailyForecastBean forecast :weather.getDaily_forecast()){
            //Log.d("============>", forecast.getDate()+"");
            View view = LayoutInflater.from(WeatherActivity.this).inflate(R.layout.forecast_item,forecastLayout,false);
            TextView dateText = (TextView)view.findViewById(R.id.date_text);
            TextView infoText = (TextView) view.findViewById(R.id.info_text);
            TextView maxText = (TextView) view.findViewById(R.id.max_text);
            TextView minText = (TextView) view.findViewById(R.id.min_text);

            dateText.setText(forecast.getDate());
            infoText.setText(forecast.getCond_txt_d());
            maxText.setText(forecast.getTmp_max());
            minText.setText(forecast.getTmp_min());
            forecastLayout.addView(view);
        }

        titleCity.setText(cityName);
        titleUpdateTime.setText(updateTime);
        degreeText.setText(degree);
        weatherInfoText.setText(weatherInfo);
        comfortText.setText("舒适度:"+weather.getLifestyle().get(0).getTxt());
        carWashText.setText("洗车指数:"+weather.getLifestyle().get(6).getTxt());
        sportText.setText("运动建议:"+weather.getLifestyle().get(3).getTxt());
        weatherLayout.setVisibility(View.VISIBLE);

    }

    public void getAQINow(final String weatherId){
        HeWeather.getAirNow(this, weatherId, new HeWeather.OnResultAirNowBeansListener() {
            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onSuccess(final List<AirNow> list) {
                Log.i("Log", "onSuccess: " +new Gson().toJson(list));
                final AQIBean aqiBean = Utility.handleAQIBeanResponse(new Gson().toJson(list));
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                      if (aqiBean != null && "ok".equals(aqiBean.getStatus())){
                          SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(WeatherActivity.this).edit();
                          editor.putString("aqi_bean",new Gson().toJson(list));
                          editor.apply();
                          mWeatherId = aqiBean.getBasic().getCid();
                          showAQIInfo(aqiBean);
                      }else{
                          Toast.makeText(WeatherActivity.this,"获取天气质量信息失败",Toast.LENGTH_SHORT).show();
                      }
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        });

    }

    private void showAQIInfo(AQIBean aqiBean){
       aqiText.setText(aqiBean.getAir_now_city().getAqi());
        pm25Text.setText(aqiBean.getAir_now_city().getPm25());
    }

    private void  loadBingPic(){
        String requestBingPic = "http://guolin.tech/api/bing_pic";
        Httputil.sendOkhttpRequest(requestBingPic, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                    final String bingPic = response.body().string();
                SharedPreferences.Editor editor =PreferenceManager.getDefaultSharedPreferences(WeatherActivity.this).edit();
                editor.putString("bing_pic",bingPic);
                editor.apply();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(WeatherActivity.this).load(bingPic).into(bingPicImag);
                    }
                });
            }
        });
    }
}
