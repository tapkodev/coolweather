package com.guixin.tapko.db;

import org.litepal.crud.LitePalSupport;

/**
 * Created by lenovo on 2018/12/23.
 * 县（区）的实体类
 */

public class County extends LitePalSupport {
    private int id;
    private int cityId;
    private String countyName;
    private String weatherId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCityIdityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public String getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(String weatherId) {
        this.weatherId = weatherId;
    }
}
