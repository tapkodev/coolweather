package com.guixin.tapko.db;


import org.litepal.crud.LitePalSupport;

/**
 * Created by lenovo on 2018/12/23.
 * 省份实体类
 */
// LitePal 中的每个类都必须继承LitePalSupport
public class Province extends LitePalSupport{
    private int id;
    private String provinceName;
    private int provinceCode;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }
}
