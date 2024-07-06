package com.raviteja2110.WeatherAPI.Service;

import com.raviteja2110.WeatherAPI.Util.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class WeatherService {

   private final RestTemplate restTemplate;
   private final String apiKey;

   @Autowired
   public WeatherService(RestTemplate restTemplate, @Value("${weather.api.key}") String apiKey) {
      this.restTemplate = restTemplate;
      this.apiKey = apiKey;
   }

   public WeatherResponse getWeather(String city) {
      String url = UriComponentsBuilder.fromUriString("https://api.openweathermap.org/data/2.5/weather")
              .queryParam("q", city)
              .queryParam("appid", apiKey)
              .build()
              .toUriString();

       return restTemplate.getForObject(url, WeatherResponse.class);
   }
}
