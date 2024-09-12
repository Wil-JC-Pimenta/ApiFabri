package br.com.fabriclima.apiFabri.menu;

import br.com.fabriclima.apiFabri.service.WeatherService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuInterativo {

    // Serviço que vai buscar as informações do clima
    private WeatherService weatherService;

    // Construtor que inicializa o serviço de clima
    public MenuInterativo() {
        this.weatherService = new WeatherService();
    }

    // Método que inicia o menu interativo
    public void iniciar() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            // Exibe a mensagem inicial de boas-vindas
            System.out.println("Olá, esse é a ApiFabri, aqui compartilhamos informações sobre o clima na cidade de Coronel Fabriciano-MG,");
            System.out.println("além de buscas de resultados do clima de outras cidades do Brasil e do Mundo.");

            // Tenta obter e exibir os dados climáticos de Coronel Fabriciano
            try {
                String resultadoCoronelFabriciano = weatherService.getWeatherForCity();
                System.out.println(resultadoCoronelFabriciano);
            } catch (IOException | InterruptedException e) {
                // Exibe um erro caso não consiga obter os dados climáticos
                System.out.println("Erro ao obter dados climáticos de Coronel Fabriciano: " + e.getMessage());
            }

            // Loop do menu interativo
            while (true) {
                System.out.println("\nDigite o nome da cidade para obter a previsão do tempo ou 'sair' para encerrar:");
                String input = reader.readLine();  // Lê a entrada do usuário

                // Se o usuário digitar "sair", encerra o programa
                if (input.equalsIgnoreCase("sair")) {
                    System.out.println("Saindo...");
                    break;
                }

                // Tenta buscar a previsão do tempo para a cidade digitada pelo usuário
                try {
                    String resultado = weatherService.searchLocation(input);
                    System.out.println(resultado);
                } catch (IOException | InterruptedException e) {
                    // Exibe uma mensagem de erro caso não consiga processar a requisição
                    System.out.println("Erro ao processar a requisição: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            // Exibe um erro caso ocorra algum problema ao ler a entrada do usuário
            System.out.println("Erro ao ler a entrada: " + e.getMessage());
        }
    }
}

