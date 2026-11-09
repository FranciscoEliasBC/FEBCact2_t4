package com.act1_t4.demo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class AdicController {
    @GetMapping("/api/adicional")
    public String getIdentificador() {
        return "Numero: 9513415268";
    }
}
