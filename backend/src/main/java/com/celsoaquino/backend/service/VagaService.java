package com.celsoaquino.backend.service;

import com.celsoaquino.backend.model.Vaga;

import java.util.List;

public interface VagaService {
    List<Vaga> getVagas();
    Vaga getVagaById(Long id);
    void createVaga(Integer quantity);
    void deleteVaga(Long id);
}
