package br.com.fabriclima.apiFabri.controller;

import br.com.fabriclima.apiFabri.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather")
    public String getWeather(@RequestParam String city) {
        try {
            return weatherService.searchLocation(city);
        } catch (Exception e) {
            return "Erro ao obter a previsão do tempo: " + e.getMessage();
        }
    }
}
