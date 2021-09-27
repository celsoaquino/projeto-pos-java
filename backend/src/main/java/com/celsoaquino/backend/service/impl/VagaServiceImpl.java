package com.celsoaquino.backend.service.impl;

import com.celsoaquino.backend.model.Vaga;
import com.celsoaquino.backend.repository.VagaRepository;
import com.celsoaquino.backend.service.VagaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VagaServiceImpl implements VagaService {

    private final VagaRepository vagaRepository;

    @Override
    public List<Vaga> getVagas() {
        return vagaRepository.findAll();
    }

    @Override
    public Vaga getVagaById(Long id) {
        Vaga vaga = vagaRepository.getVagaById(id);
        vaga.setFull(true);
        return vaga;
    }

    @Override
    public void createVaga(Integer qtd) {
        List<Vaga> vagas = new ArrayList<>();
        for (int i = 0; i < qtd; i++) {
            Vaga vaga = new Vaga();
            vaga.setFull(false);
            vagas.add(vaga);
        }
        if (!vagas.isEmpty()) {
            vagaRepository.saveAll(vagas);
            vagas.clear();
        }
    }

    @Override
    public void deleteVaga(Long id) {
        Vaga vaga = vagaRepository.getVagaById(id);
        vagaRepository.delete(vaga);
    }
}
