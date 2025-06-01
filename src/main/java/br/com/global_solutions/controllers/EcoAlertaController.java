package br.com.global_solutions.controllers;

import br.com.global_solutions.domain.entities.AlertaClimatico;
import br.com.global_solutions.domain.entities.StatusClimatico;
import br.com.global_solutions.dto.DadosIoTRequest;
import br.com.global_solutions.services.EcoAlertaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class EcoAlertaController {

    @Autowired
    EcoAlertaService service;

    @GetMapping("/status-climatico")
    public ResponseEntity<Object> obterStatusClimatico(@RequestParam String localizacao) {
        StatusClimatico statusClimatico = service.obterStatusClimatico(localizacao);
        if (statusClimatico != null) return ResponseEntity.ok(statusClimatico);
        else return ResponseEntity.badRequest().body(null);
    }

    @GetMapping("/alerta")
    public ResponseEntity<Object> obterAlertaClimatico(@RequestParam String localizacao) {
        AlertaClimatico alertaClimatico = service.obterAlertaClimatico(localizacao);
        if (alertaClimatico != null) return ResponseEntity.ok(alertaClimatico);
        else return ResponseEntity.badRequest().body(null);
    }

    @PostMapping("/dados-climaticos")
    public ResponseEntity<Object> receberDadosIoT(@Valid @RequestBody DadosIoTRequest dados) {
        try {
            service.processarDados(dados);
            return ResponseEntity.status(201).body(dados);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Não foi possível processar os dados.");
        }
    }

}
