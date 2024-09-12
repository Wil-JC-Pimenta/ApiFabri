package br.com.fabriclima.apiFabri.controller;

import br.com.fabriclima.apiFabri.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Permitir que o front-end faça chamadas para esta API
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/weather")
    public String getWeather(@RequestParam(required = false) String city) {
        try {
            // Se nenhum parâmetro 'city' for fornecido, use Coronel Fabriciano como padrão
            if (city == null || city.isEmpty()) {
                return weatherService.getWeatherForCity(); // Retorna o clima de Coronel Fabriciano
            }
            // Se a cidade for fornecida, busca o clima dessa cidade
            return weatherService.searchLocation(city);
        } catch (IOException | InterruptedException e) {
            // Retorna uma mensagem de erro em formato JSON
            return "{ \"error\": \"" + e.getMessage() + "\" }";
        }
    }
}
