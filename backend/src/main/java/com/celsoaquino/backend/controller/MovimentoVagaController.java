package com.celsoaquino.backend.controller;

import com.celsoaquino.backend.model.MovimentoVaga;
import com.celsoaquino.backend.model.Veiculo;
import com.celsoaquino.backend.service.MovimentoVagaService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/movimento")
public class MovimentoVagaController {

    private final MovimentoVagaService movimentoVagaService;

    @GetMapping("/findAll")
    public ResponseEntity<List<MovimentoVaga>> getAllMovimentos() {
        return ResponseEntity.ok(movimentoVagaService.findAllMovimentos());
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
    public ResponseEntity entrada(@RequestBody Veiculo veiculo) {
        String placa = veiculo.getPlaca();
        Long vagaId = veiculo.getVagaId();
        try {
            return ResponseEntity.ok(movimentoVagaService.createMovimentoVaga(placa, vagaId));
        } catch (DataIntegrityViolationException e) {
            return ResponseEntity.badRequest().body("Placa já existe.");
        } catch (TransactionSystemException e) {
            return ResponseEntity.badRequest().body("Digite uma placa válida.");
        }
    }

    @PutMapping("/saida/{id}")
    public ResponseEntity<?> saida(@PathVariable("id") String id) {
        return ResponseEntity.ok(movimentoVagaService.updateMovimentoVaga(id));
    }

    @GetMapping("/data")
    public ResponseEntity<List<MovimentoVaga>> getMovimentoData(@RequestParam("from")
                                                                    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate data) {
        return ResponseEntity.ok(movimentoVagaService.getMovimentoVagaByEntrada(data));
    }
}
