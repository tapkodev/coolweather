package com.guixin.tapko.gson;


import java.util.List;

/**
 * Created by lenovo on 2018/12/24.
 * 空气质量指数
 */

public class AQIBean  {

    /**
     * air_now_city : {"aqi":"39","co":"0.5","main":"-","no2":"53","o3":"34","pm10":"39","pm25":"14","pub_time":"2018-12-25 16:00","qlty":"优","so2":"7"}
     * air_now_station : [{"air_sta":"普陀","aqi":"46","asid":"CNA1141","co":"0.4","lat":"31.238","lon":"121.4","main":"-","no2":"51","o3":"41","pm10":"46","pm25":"10","pub_time":"2018-12-25 16:00","qlty":"优","so2":"6"},{"air_sta":"十五厂","aqi":"29","asid":"CNA1142","co":"0.3","lat":"31.2036","lon":"121.478","main":"-","no2":"53","o3":"35","pm10":"29","pm25":"15","pub_time":"2018-12-25 16:00","qlty":"优","so2":"6"},{"air_sta":"虹口","aqi":"36","asid":"CNA1143","co":"0.4","lat":"31.3008","lon":"121.467","main":"-","no2":"55","o3":"28","pm10":"36","pm25":"11","pub_time":"2018-12-25 16:00","qlty":"优","so2":"8"},{"air_sta":"徐汇上师大","aqi":"42","asid":"CNA1144","co":"0.5","lat":"31.1654","lon":"121.412","main":"-","no2":"58","o3":"25","pm10":"42","pm25":"20","pub_time":"2018-12-25 16:00","qlty":"优","so2":"5"},{"air_sta":"杨浦四漂","aqi":"41","asid":"CNA1145","co":"0.5","lat":"31.2659","lon":"121.536","main":"-","no2":"61","o3":"36","pm10":"41","pm25":"19","pub_time":"2018-12-25 16:00","qlty":"优","so2":"8"},{"air_sta":"青浦淀山湖","aqi":"27","asid":"CNA1146","co":"0.6","lat":"31.0935","lon":"120.978","main":"-","no2":"38","o3":"37","pm10":"27","pm25":"14","pub_time":"2018-12-25 16:00","qlty":"优","so2":"4"},{"air_sta":"静安监测站","aqi":"46","asid":"CNA1147","co":"0.3","lat":"31.2261","lon":"121.425","main":"-","no2":"34","o3":"41","pm10":"46","pm25":"11","pub_time":"2018-12-25 16:00","qlty":"优","so2":"8"},{"air_sta":"浦东川沙","aqi":"34","asid":"CNA1148","co":"0.3","lat":"31.1907","lon":"121.703","main":"-","no2":"46","o3":"49","pm10":"34","pm25":"14","pub_time":"2018-12-25 16:00","qlty":"优","so2":"7"},{"air_sta":"浦东新区监测站","aqi":"44","asid":"CNA1149","co":"0.5","lat":"31.2284","lon":"121.533","main":"-","no2":"65","o3":"16","pm10":"44","pm25":"9","pub_time":"2018-12-25 16:00","qlty":"优","so2":"8"},{"air_sta":"浦东张江","aqi":"41","asid":"CNA1150","co":"0.4","lat":"31.2071","lon":"121.577","main":"-","no2":"63","o3":"24","pm10":"41","pm25":"15","pub_time":"2018-12-25 16:00","qlty":"优","so2":"7"}]
     * basic : {"admin_area":"上海","cid":"CN101020100","cnty":"中国","lat":"31.23170662","location":"上海","lon":"121.47264099","parent_city":"上海","tz":"+8.00"}
     * status : ok
     * update : {"loc":"2018-12-25 16:56","utc":"2018-12-25 08:56"}
     */

    private AirNowCityBean air_now_city;
    private BasicBean basic;
    private String status;
    private UpdateBean update;
    private List<AirNowStationBean> air_now_station;

    public AirNowCityBean getAir_now_city() {
        return air_now_city;
    }

    public void setAir_now_city(AirNowCityBean air_now_city) {
        this.air_now_city = air_now_city;
    }

    public BasicBean getBasic() {
        return basic;
    }

    public void setBasic(BasicBean basic) {
        this.basic = basic;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public UpdateBean getUpdate() {
        return update;
    }

    public void setUpdate(UpdateBean update) {
        this.update = update;
    }

    public List<AirNowStationBean> getAir_now_station() {
        return air_now_station;
    }

    public void setAir_now_station(List<AirNowStationBean> air_now_station) {
        this.air_now_station = air_now_station;
    }

    public static class AirNowCityBean {
        /**
         * aqi : 39
         * co : 0.5
         * main : -
         * no2 : 53
         * o3 : 34
         * pm10 : 39
         * pm25 : 14
         * pub_time : 2018-12-25 16:00
         * qlty : 优
         * so2 : 7
         */

        private String aqi;
        private String co;
        private String main;
        private String no2;
        private String o3;
        private String pm10;
        private String pm25;
        private String pub_time;
        private String qlty;
        private String so2;

        public String getAqi() {
            return aqi;
        }

        public void setAqi(String aqi) {
            this.aqi = aqi;
        }

        public String getCo() {
            return co;
        }

        public void setCo(String co) {
            this.co = co;
        }

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getNo2() {
            return no2;
        }

        public void setNo2(String no2) {
            this.no2 = no2;
        }

        public String getO3() {
            return o3;
        }

        public void setO3(String o3) {
            this.o3 = o3;
        }

        public String getPm10() {
            return pm10;
        }

        public void setPm10(String pm10) {
            this.pm10 = pm10;
        }

        public String getPm25() {
            return pm25;
        }

        public void setPm25(String pm25) {
            this.pm25 = pm25;
        }

        public String getPub_time() {
            return pub_time;
        }

        public void setPub_time(String pub_time) {
            this.pub_time = pub_time;
        }

        public String getQlty() {
            return qlty;
        }

        public void setQlty(String qlty) {
            this.qlty = qlty;
        }

        public String getSo2() {
            return so2;
        }

        public void setSo2(String so2) {
            this.so2 = so2;
        }
    }

    public static class BasicBean {
        /**
         * admin_area : 上海
         * cid : CN101020100
         * cnty : 中国
         * lat : 31.23170662
         * location : 上海
         * lon : 121.47264099
         * parent_city : 上海
         * tz : +8.00
         */

        private String admin_area;
        private String cid;
        private String cnty;
        private String lat;
        private String location;
        private String lon;
        private String parent_city;
        private String tz;

        public String getAdmin_area() {
            return admin_area;
        }

        public void setAdmin_area(String admin_area) {
            this.admin_area = admin_area;
        }

        public String getCid() {
            return cid;
        }

        public void setCid(String cid) {
            this.cid = cid;
        }

        public String getCnty() {
            return cnty;
        }

        public void setCnty(String cnty) {
            this.cnty = cnty;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getLon() {
            return lon;
        }

        public void setLon(String lon) {
            this.lon = lon;
        }

        public String getParent_city() {
            return parent_city;
        }

        public void setParent_city(String parent_city) {
            this.parent_city = parent_city;
        }

        public String getTz() {
            return tz;
        }

        public void setTz(String tz) {
            this.tz = tz;
        }
    }

    public static class UpdateBean {
        /**
         * loc : 2018-12-25 16:56
         * utc : 2018-12-25 08:56
         */

        private String loc;
        private String utc;

        public String getLoc() {
            return loc;
        }

        public void setLoc(String loc) {
            this.loc = loc;
        }

        public String getUtc() {
            return utc;
        }

        public void setUtc(String utc) {
            this.utc = utc;
        }
    }

    public static class AirNowStationBean {
        /**
         * air_sta : 普陀
         * aqi : 46
         * asid : CNA1141
         * co : 0.4
         * lat : 31.238
         * lon : 121.4
         * main : -
         * no2 : 51
         * o3 : 41
         * pm10 : 46
         * pm25 : 10
         * pub_time : 2018-12-25 16:00
         * qlty : 优
         * so2 : 6
         */

        private String air_sta;
        private String aqi;
        private String asid;
        private String co;
        private String lat;
        private String lon;
        private String main;
        private String no2;
        private String o3;
        private String pm10;
        private String pm25;
        private String pub_time;
        private String qlty;
        private String so2;

        public String getAir_sta() {
            return air_sta;
        }

        public void setAir_sta(String air_sta) {
            this.air_sta = air_sta;
        }

        public String getAqi() {
            return aqi;
        }

        public void setAqi(String aqi) {
            this.aqi = aqi;
        }

        public String getAsid() {
            return asid;
        }

        public void setAsid(String asid) {
            this.asid = asid;
        }

        public String getCo() {
            return co;
        }

        public void setCo(String co) {
            this.co = co;
        }

        public String getLat() {
            return lat;
        }

        public void setLat(String lat) {
            this.lat = lat;
        }

        public String getLon() {
            return lon;
        }

        public void setLon(String lon) {
            this.lon = lon;
        }

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getNo2() {
            return no2;
        }

        public void setNo2(String no2) {
            this.no2 = no2;
        }

        public String getO3() {
            return o3;
        }

        public void setO3(String o3) {
            this.o3 = o3;
        }

        public String getPm10() {
            return pm10;
        }

        public void setPm10(String pm10) {
            this.pm10 = pm10;
        }

        public String getPm25() {
            return pm25;
        }

        public void setPm25(String pm25) {
            this.pm25 = pm25;
        }

        public String getPub_time() {
            return pub_time;
        }

        public void setPub_time(String pub_time) {
            this.pub_time = pub_time;
        }

        public String getQlty() {
            return qlty;
        }

        public void setQlty(String qlty) {
            this.qlty = qlty;
        }

        public String getSo2() {
            return so2;
        }

        public void setSo2(String so2) {
            this.so2 = so2;
        }
    }
}
