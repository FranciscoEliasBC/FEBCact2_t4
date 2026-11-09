package com.act1_t4.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController

public class InfoController {

    @GetMapping("/api/materias")
    public List<String> getMaterias() {
        return List.of("Sistemas Programables", "Ingeniería de Software", "Base de Datos");
    }

    @GetMapping("/api/estado")
    public String getEstado() {
        return "Servidor activo y operando correctamente en septimo semestre.";
    }
}
