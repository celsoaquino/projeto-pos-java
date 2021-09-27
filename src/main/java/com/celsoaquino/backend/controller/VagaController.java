package com.celsoaquino.backend.controller;

import com.celsoaquino.backend.model.Vaga;
import com.celsoaquino.backend.service.VagaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<List<Vaga>> listAllVagas() throws InterruptedException {
        List<Vaga> vagas = vagaService.getVagas();
        //Thread.sleep(1000);
        return ResponseEntity.ok(vagas);
    }

    @GetMapping("/{qtd}")
    public void createVaga(@PathVariable Integer qtd) {
        vagaService.createVaga(qtd);
    }

    @DeleteMapping("/{id}")
    public void deleteVaga(@PathVariable("id") Long id) {
        vagaService.deleteVaga(id);
    }
}
