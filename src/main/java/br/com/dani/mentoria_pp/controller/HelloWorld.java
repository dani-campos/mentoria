package br.com.dani.mentoria_pp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/v1")
public class HelloWorld {

    @GetMapping("hello")
    public ResponseEntity hello() {
        return ResponseEntity.ok().body(Map.of("message", "Teste"));
    }
}
