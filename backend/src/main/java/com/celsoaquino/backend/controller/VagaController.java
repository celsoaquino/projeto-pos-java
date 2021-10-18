package com.celsoaquino.backend.controller;

import com.celsoaquino.backend.model.Quantidade;
import com.celsoaquino.backend.model.Vaga;
import com.celsoaquino.backend.service.VagaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/vagas")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VagaController {

    private final VagaService vagaService;

    @GetMapping
    public ResponseEntity<List<Vaga>> listAllVagas() {
        return ResponseEntity.ok(vagaService.getVagas());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createVaga(@RequestBody Quantidade qtd) {
        vagaService.createVaga(qtd.getQuantidade());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteVaga(@PathVariable("id") Long id) {
        try {
            vagaService.deleteVaga(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
