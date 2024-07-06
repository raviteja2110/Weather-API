package com.raviteja2110.WeatherAPI.Controller;

import com.raviteja2110.WeatherAPI.DTO.WeatherDTO;
import com.raviteja2110.WeatherAPI.Service.WeatherService;
import com.raviteja2110.WeatherAPI.Util.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WeatherController {

    private final WeatherService weatherService;

    @Autowired
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    // This method will serve the HTML page
    @GetMapping("/")
    public String index(Model model) {
        try {
            WeatherResponse weather = weatherService.getWeather("Hyderabad");
            WeatherDTO weatherDTO = convertToDTO(weather);
            model.addAttribute("defaultWeather", weatherDTO);
        } catch (RuntimeException e) {
            model.addAttribute("error", "Failed to fetch default weather data: " + e.getMessage());
        }
        return "index";
    }

    @GetMapping("/weather")
    public ResponseEntity<?> getWeather(@RequestParam("city") String city, Model model) {
        try {
            WeatherResponse weatherResponse = weatherService.getWeather(city);
            if (weatherResponse == null) {
                return ResponseEntity.notFound().build(); // Return 404 if weather data not found
            }
            WeatherDTO weatherDTO = convertToDTO(weatherResponse);
            model.addAttribute("defaultWeather", weatherDTO);
            return ResponseEntity.ok(weatherDTO); // Return weather data if found
        } catch (RuntimeException e) {
            String errorMessage = "Failed to fetch weather data: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    private WeatherDTO convertToDTO(WeatherResponse weather) {
        return new WeatherDTO(
                weather.getName(),
                weather.getMain().getTempInCelcius(),
                weather.getWeather()[0].getDescription(),
                weather.getMain().getHumidity(),
                weather.getWind().getSpeed(),
                weather.getWeather()[0].getIcon()
        );
    }
}
