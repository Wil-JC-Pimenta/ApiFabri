package br.com.fabriclima.apiFabri.menu;

import br.com.fabriclima.apiFabri.service.WeatherService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuInterativo {

    private WeatherService weatherService;

    public MenuInterativo() {
        this.weatherService = new WeatherService();
    }

    public void iniciar() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("Digite o nome da cidade para obter a previsão do tempo ou 'sair' para encerrar:");
                String input = reader.readLine();

                if (input.equalsIgnoreCase("sair")) {
                    System.out.println("Saindo...");
                    break;
                }

                try {
                    String resultado = weatherService.searchLocation(input);
                    System.out.println(resultado);
                } catch (IOException | InterruptedException e) {
                    System.out.println("Erro ao processar a requisição: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler a entrada: " + e.getMessage());
        }
    }
}
