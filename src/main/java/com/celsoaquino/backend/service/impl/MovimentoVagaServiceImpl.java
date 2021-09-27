package com.celsoaquino.backend.service.impl;

import com.celsoaquino.backend.model.MovimentoVaga;
import com.celsoaquino.backend.model.Veiculo;
import com.celsoaquino.backend.repository.MovimentoVagaRepository;
import com.celsoaquino.backend.repository.VeiculoRepository;
import com.celsoaquino.backend.service.MovimentoVagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MovimentoVagaServiceImpl implements MovimentoVagaService {

    @Autowired
    private MovimentoVagaRepository movimentoVagaRepository;
    @Autowired
    private VeiculoRepository veiculoRepository;

    @Override
    public List<MovimentoVaga> getMovimentoVagas() {
        return movimentoVagaRepository.findAll();
    }

    @Override
    public MovimentoVaga createMovimentoVaga(String placa, Long vagaId) {
        Veiculo veiculo = new Veiculo();
        veiculo.setVagaId(vagaId);
        veiculo.setPlaca(placa);
        veiculoRepository.save(veiculo);
        MovimentoVaga movimentoVaga = new MovimentoVaga();
        movimentoVaga.setVeiculoId(veiculo.getId());
        return movimentoVagaRepository.save(movimentoVaga);
    }

    @Override
    public MovimentoVaga updateMovimentoVaga(String id) {
        MovimentoVaga movimentoVagaUpdate = movimentoVagaRepository.getById(id);
        movimentoVagaUpdate.setSaida(LocalDateTime.now());

        Duration duration = Duration.between(movimentoVagaUpdate.getEntrada(), movimentoVagaUpdate.getSaida());
        movimentoVagaUpdate.setDuracao(duration.toMinutes());
        return movimentoVagaRepository.save(movimentoVagaUpdate);
    }
}
