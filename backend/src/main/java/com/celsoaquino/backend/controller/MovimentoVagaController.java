package com.celsoaquino.backend.controller;

import com.celsoaquino.backend.model.MovimentoVaga;
import com.celsoaquino.backend.model.Veiculo;
import com.celsoaquino.backend.service.MovimentoVagaService;
import com.celsoaquino.backend.service.VagaService;
import com.celsoaquino.backend.service.VeiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class MovimentoVagaController {

    private final MovimentoVagaService movimentoVagaService;
    private final VagaService vagaService;

    @GetMapping("/movimento-vaga")
    public ResponseEntity<List<MovimentoVaga>> getmovimentoVagas() {
        return ResponseEntity.ok(movimentoVagaService.getMovimentoVagas());
    }

    @PostMapping("/entrada")
    public ResponseEntity<MovimentoVaga> entrada(@RequestBody Veiculo veiculo) {
        String placa = veiculo.getPlaca();
        Long vagaId = veiculo.getVagaId();
        vagaService.getVagaById(veiculo.getVagaId());
        return ResponseEntity.ok(movimentoVagaService.createMovimentoVaga(placa, vagaId));
    }

    @PutMapping("/saida/{id}")
    public ResponseEntity<?> saida(@PathVariable("id") String id) {
        movimentoVagaService.updateMovimentoVaga(id);
        return new ResponseEntity<>("Registro de saída atualizado com id: " + id, HttpStatus.OK);
    }

}
