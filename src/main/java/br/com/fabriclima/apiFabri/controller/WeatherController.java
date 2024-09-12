package br.com.fabriclima.apiFabri.controller;

import br.com.fabriclima.apiFabri.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Adapte conforme o endereço do frontend
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather")
    public String getWeather(@RequestParam String city) {
        try {
            return weatherService.searchLocation(city);
        } catch (IOException | InterruptedException e) {
            return "{ \"error\": \"" + e.getMessage() + "\" }";
        }
    }
}
