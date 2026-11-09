package com.act1_t4.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class ProyectoController {
    @GetMapping("/api/identificador")
    public String getIdentificador() {
        return "Proyecto Spring Boot - Francisco Elias Bautista Centeno (FEBC)";
    }
}
