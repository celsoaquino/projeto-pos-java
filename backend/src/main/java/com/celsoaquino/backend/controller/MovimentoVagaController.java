package com.celsoaquino.backend.controller;

import com.celsoaquino.backend.model.MovimentoVaga;
import com.celsoaquino.backend.model.Vaga;
import com.celsoaquino.backend.model.Veiculo;
import com.celsoaquino.backend.service.MovimentoVagaService;
import com.celsoaquino.backend.service.VagaService;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/movimento")
public class MovimentoVagaController {

    private final MovimentoVagaService movimentoVagaService;
    private final VagaService vagaService;

    @GetMapping()
    public ResponseEntity<List<MovimentoVaga>> getMovimentoVagas() {
        return ResponseEntity.ok(movimentoVagaService.getMovimentoVagas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovimentoVaga> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(movimentoVagaService.getMovimentoVagaById(id));
    }

    @GetMapping("/veiculo-id/{id}")
    public ResponseEntity<MovimentoVaga> findMovimentoByVagaId(@PathVariable String id) {
        return ResponseEntity.ok(movimentoVagaService.getMovimentoVagaByVeiculoId(id));
    }

    @PostMapping("/entrada")
    public ResponseEntity<MovimentoVaga> entrada(@RequestBody Veiculo veiculo) throws Exception {
        String placa = veiculo.getPlaca();
        Long vagaId = veiculo.getVagaId();
        vagaService.setIsFull(veiculo.getVagaId());
       // TODO verificar se a vaga está ocupada
        return ResponseEntity.ok(movimentoVagaService.createMovimentoVaga(placa, vagaId));
    }

    @PutMapping("/saida/{id}")
    public ResponseEntity<?> saida(@PathVariable("id") String id) {
        return ResponseEntity.ok(movimentoVagaService.updateMovimentoVaga(id));
    }

}
