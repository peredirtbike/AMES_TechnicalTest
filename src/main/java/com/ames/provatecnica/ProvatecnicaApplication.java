package com.ames.provatecnica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@ComponentScan(basePackages = "com.ames.provatecnica") // Agrega el paquete raíz de tu proyecto aquí
@OpenAPIDefinition
public class ProvatecnicaApplication {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(ProvatecnicaApplication.class, args);
    }

}