package com.guixin.tapko.util;

import android.text.TextUtils;

import com.guixin.tapko.db.City;
import com.guixin.tapko.db.County;
import com.guixin.tapko.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
}
