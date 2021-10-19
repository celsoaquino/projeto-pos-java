package com.celsoaquino.backend.service;

import com.celsoaquino.backend.model.MovimentoVaga;

import java.time.LocalDate;
import java.util.List;

public interface MovimentoVagaService {
    MovimentoVaga getMovimentoVagaById(String id);
    MovimentoVaga createMovimentoVaga(String placa, Long vagaId);
    MovimentoVaga updateMovimentoVaga(String id);
    MovimentoVaga getMovimentoVagaByVeiculoId(String id);
    List<MovimentoVaga> findAllMovimentos();
    List<MovimentoVaga> getMovimentoVagaByEntrada(LocalDate entrada);
}
