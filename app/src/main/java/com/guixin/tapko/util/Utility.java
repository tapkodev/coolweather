package com.guixin.tapko.util;

import android.text.TextUtils;

import com.google.gson.Gson;
import com.guixin.tapko.db.City;
import com.guixin.tapko.db.County;
import com.guixin.tapko.db.Province;
import com.guixin.tapko.gson.AQIBean;
import com.guixin.tapko.gson.Weather;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * Created by lenovo on 2018/12/23.
 */

public class Utility {
    /**
     * 解析和处理服务器返回的省级数据
     */
    public static boolean handlerProvvinceResponse(String response){
        if (!TextUtils.isEmpty(response)){
            try{
                JSONArray allProvince = new JSONArray(response);
                for (int i = 0; i< allProvince.length();i++){
                    JSONObject provinceObj = allProvince.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObj.getString("name"));
                    province.setProvinceCode(provinceObj.getInt("id"));
                    province.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean handlerCityResponse(String response,int provinceId){
        if (!TextUtils.isEmpty(response)){
            try{
                JSONArray allCities = new JSONArray(response);
                for (int i = 0; i< allCities.length();i++){
                    JSONObject cityObj = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObj.getString("name"));
                    city.setCityCode(cityObj.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
    /**
     * 解析和处理服务器返回的县区级数据
     */
    public static boolean handlerCountyResponse(String response,int cityId){
        if (!TextUtils.isEmpty(response)){
            try{
                JSONArray allCounties = new JSONArray(response);
                for (int i = 0; i< allCounties.length();i++){
                    JSONObject countyObj = allCounties.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObj.getString("name"));
                    county.setWeatherId(countyObj.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 将返回的JSON数据解析成Weather实体类
     */
    public static Weather handleWeatherResponse(String response){
        try {

            // 将整个json实例化保存在jsonObject中
            JSONArray jsonArray = new JSONArray(response);
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent,Weather.class);
        } catch (Exception e) {
            e.printStackTrace();


        }
        return null;
    }

    /**
     * 将返回的JSON数据解析成AQIBean实体类
     */
    public static AQIBean handleAQIBeanResponse(String response){
        try {

            // 将整个json实例化保存在jsonObject中
            JSONArray jsonArray = new JSONArray(response);
            String aqiBeanContent = jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(aqiBeanContent,AQIBean.class);
        } catch (Exception e) {
            e.printStackTrace();


        }
        return null;
    }
}
