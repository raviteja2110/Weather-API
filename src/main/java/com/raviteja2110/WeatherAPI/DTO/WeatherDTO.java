package com.raviteja2110.WeatherAPI.DTO;

import lombok.Data;

@Data
public class WeatherDTO {
    private String city;
    private double temperature;
    private String description;
    private int humidity;
    private double windSpeed;
    private String iconCode;

    public WeatherDTO(String city, double temperature, String description, int humidity, double windSpeed, String iconCode) {
        this.city = city;
        this.temperature = temperature;
        this.description = description;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.iconCode = iconCode;
    }

}
