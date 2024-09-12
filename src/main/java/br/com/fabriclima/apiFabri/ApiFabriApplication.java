package br.com.fabriclima.apiFabri;

import br.com.fabriclima.apiFabri.menu.MenuInterativo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class    ApiFabriApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiFabriApplication.class, args);
        // Inicializa o menu interativo
        MenuInterativo menu = new MenuInterativo();
        menu.iniciar();
    }
}
