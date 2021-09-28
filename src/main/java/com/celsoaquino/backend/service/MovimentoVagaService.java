package com.celsoaquino.backend.service;

import com.celsoaquino.backend.model.MovimentoVaga;

import java.util.List;

public interface MovimentoVagaService {
    List<MovimentoVaga> getMovimentoVagas();
    MovimentoVaga getMovimentoVagaById(String id);
    MovimentoVaga createMovimentoVaga(String placa, Long vagaId);
    MovimentoVaga updateMovimentoVaga(String id);
    MovimentoVaga getMovimentoVagaByVeiculoId(String id);
}
