package br.com.fabriclima.apiFabri.service;

import org.springframework.stereotype.Service;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

@Service
public class WeatherService {

    private static final String BASE_URL = "https://api.weatherbit.io/v2.0/current";
    private static final String API_KEY = "fdee117d4b904a5f9c31a769b7ce5fe6"; // Substitua por sua chave de API

    public String searchLocation(String query) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String encodedQuery = URLEncoder.encode(query, StandardCharsets.UTF_8.toString());
        String endpoint = BASE_URL + "?city=" + encodedQuery + "&key=" + API_KEY + "&units=M";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endpoint))
                .GET()
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            JSONObject jsonResponse = new JSONObject(response.body());

            if (jsonResponse.has("data")) {
                return getWeather(jsonResponse);
            } else {
                return "❌ Nenhuma localização encontrada para a busca: " + query;
            }
        } else {
            return "Erro ao buscar localização. Código de status: " + response.statusCode();
        }
    }

    private String getWeather(JSONObject jsonResponse) {
        JSONObject weatherData = jsonResponse.getJSONArray("data").getJSONObject(0);

        // Detalhes do clima
        String locationTitle = weatherData.optString("city_name", "Localização desconhecida");
        JSONObject weather = weatherData.optJSONObject("weather");
        String weatherState = weather != null ? weather.optString("description", "Sem descrição") : "Sem descrição";
        double currentTemp = weatherData.optDouble("temp", Double.NaN);
        double windSpeed = weatherData.optDouble("wind_spd", Double.NaN);
        double humidity = weatherData.optDouble("rh", Double.NaN);

        String weatherInfo = "\n☀️ O clima em " + locationTitle + " é " + weatherState.toLowerCase() +
                " com uma temperatura de " + String.format("%.1f", currentTemp) + "°C.\n" +
                "🌬️ Velocidade do vento: " + String.format("%.1f", windSpeed) + " km/h.\n" +
                "💧 Umidade: " + humidity + "%.\n";

        // Fornecer conselhos sobre vestuário com base no clima
        weatherInfo += provideClothingAdvice(currentTemp);

        return weatherInfo;
    }

    private String provideClothingAdvice(double temperature) {
        String advice = "👗 Para hoje, dependendo da temperatura, sugerimos:\n";
        if (temperature > 25) {
            advice += "Se está quente, use roupas leves como camisetas e shorts.\n";
        } else if (temperature > 15) {
            advice += "Se está ameno, use algo confortável como uma camiseta de manga longa ou uma blusa.\n";
        } else {
            advice += "Se está frio, não esqueça um casaco e algo confortável para manter-se aquecido.\n";
        }
        advice += "Lembre-se de sempre conferir a previsão de chuva e levar um guarda-chuva se necessário! ☂️";
        return advice;
    }
}
