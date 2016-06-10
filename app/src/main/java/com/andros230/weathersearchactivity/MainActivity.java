package com.andros230.weathersearchactivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.amap.api.services.weather.LocalDayWeatherForecast;
import com.amap.api.services.weather.LocalWeatherForecast;
import com.amap.api.services.weather.LocalWeatherForecastResult;
import com.amap.api.services.weather.LocalWeatherLive;
import com.amap.api.services.weather.LocalWeatherLiveResult;
import com.amap.api.services.weather.WeatherSearch;
import com.amap.api.services.weather.WeatherSearchQuery;

import java.util.List;

public class MainActivity extends Activity implements WeatherSearch.OnWeatherSearchListener{
    private String cityname="上海市";//天气搜索的城市，可以写名称或adcode；
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WeatherSearchQuery mquery = new WeatherSearchQuery(cityname, WeatherSearchQuery.WEATHER_TYPE_LIVE);//检索参数为城市和天气类型，实时天气为1、天气预报为2
        WeatherSearch  mweathersearch =new WeatherSearch(this);
        mweathersearch.setOnWeatherSearchListener(this);
        mweathersearch.setQuery(mquery);
        mweathersearch.searchWeatherAsyn(); //异步搜索

    }


    //今天的天气
    @Override
    public void onWeatherLiveSearched(LocalWeatherLiveResult localWeatherLiveResult, int rCode) {
        if (rCode == 1000) {
            if (localWeatherLiveResult != null && localWeatherLiveResult.getLiveResult() != null) {
                LocalWeatherLive weatherlive = localWeatherLiveResult.getLiveResult();
                Log.d("---","省份:"+weatherlive.getProvince());
                Log.d("---","城市:"+weatherlive.getCity());
                Log.d("---","发布时间:"+weatherlive.getReportTime());
                Log.d("---","天气:"+weatherlive.getWeather());
                Log.d("---","温度:"+weatherlive.getTemperature());
                Log.d("---","湿度:"+weatherlive.getHumidity());
                Log.d("---","风力:"+weatherlive.getWindPower());
                Log.d("---","风向:"+weatherlive.getWindDirection());

            }
        }
    }

    //未来的天气
    @Override
    public void onWeatherForecastSearched(LocalWeatherForecastResult localWeatherForecastResult, int rCode) {

    }
}
