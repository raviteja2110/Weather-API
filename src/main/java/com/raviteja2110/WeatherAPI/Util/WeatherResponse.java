package com.raviteja2110.WeatherAPI.Util;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
public class WeatherResponse {

    @JsonProperty("coord")
    private Coord coord;

    @JsonProperty("weather")
    private Weather[] weather;

    @JsonProperty("base")
    private String base;

    @JsonProperty("main")
    private Main main;

    @JsonProperty("visibility")
    private int visibility;

    @JsonProperty("wind")
    private Wind wind;

    @JsonProperty("clouds")
    private Clouds clouds;

    @JsonProperty("dt")
    private long dt;

    @JsonProperty("sys")
    private Sys sys;

    @JsonProperty("timezone")
    private int timezone;

    @JsonProperty("id")
    private long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("cod")
    private int cod;

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    @Data
    public static class Coord {
        @JsonProperty("lat")
        private double lat;

        @JsonProperty("lon")
        private double lon;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    @Data
    public static class Weather {
        @JsonProperty("id")
        private int id;

        @JsonProperty("main")
        private String main;

        @JsonProperty("description")
        private String description;

        @JsonProperty("icon")
        private String icon;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    @Data
    public static class Main {
        @JsonProperty("temp")
        private double temp;

        @JsonProperty("feels_like")
        private double feelsLike;

        @JsonProperty("temp_min")
        private double tempMin;

        @JsonProperty("temp_max")
        private double tempMax;

        @JsonProperty("pressure")
        private int pressure;

        @JsonProperty("humidity")
        private int humidity;

        public double getTempInCelcius() {
            return temp - 273.15;
        }
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    @Data
    public static class Wind {
        @JsonProperty("speed")
        private double speed;

        @JsonProperty("deg")
        private int deg;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    @Data
    public static class Clouds {
        @JsonProperty("all")
        private int all;
    }

    @JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
    @Data
    public static class Sys {
        @JsonProperty("type")
        private int type;

        @JsonProperty("id")
        private int id;

        @JsonProperty("country")
        private String country;

        @JsonProperty("sunrise")
        private long sunrise;

        @JsonProperty("sunset")
        private long sunset;
    }
}
