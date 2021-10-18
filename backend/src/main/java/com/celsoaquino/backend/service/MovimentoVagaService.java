package com.celsoaquino.backend.service;

import com.celsoaquino.backend.model.MovimentoVaga;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MovimentoVagaService {
    Page<MovimentoVaga> getMovimentoVagas(Pageable pageable);
    MovimentoVaga getMovimentoVagaById(String id);
    MovimentoVaga createMovimentoVaga(String placa, Long vagaId);
    MovimentoVaga updateMovimentoVaga(String id);
    MovimentoVaga getMovimentoVagaByVeiculoId(String id);
    List<MovimentoVaga> findAllMovimentos();
}
