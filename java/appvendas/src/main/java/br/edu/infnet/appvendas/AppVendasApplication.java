package br.edu.infnet.appvendas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AppVendasApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppVendasApplication.class, args);
    }

}

