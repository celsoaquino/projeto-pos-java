package com.celsoaquino.backend.controller;

import com.celsoaquino.backend.model.MovimentoVaga;
import com.celsoaquino.backend.model.Veiculo;
import com.celsoaquino.backend.service.MovimentoVagaService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/movimento")
public class MovimentoVagaController {

    private final MovimentoVagaService movimentoVagaService;

    @GetMapping()
    public ResponseEntity<Page<MovimentoVaga>> getMovimentoVagas(Pageable pageable) {
        return ResponseEntity.ok(movimentoVagaService.getMovimentoVagas(pageable));
    }

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


    /*@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }*/
}
