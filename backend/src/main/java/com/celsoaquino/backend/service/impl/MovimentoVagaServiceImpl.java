package com.celsoaquino.backend.service.impl;

import com.celsoaquino.backend.model.MovimentoVaga;
import com.celsoaquino.backend.model.Vaga;
import com.celsoaquino.backend.model.Veiculo;
import com.celsoaquino.backend.repository.MovimentoVagaRepository;
import com.celsoaquino.backend.repository.VagaRepository;
import com.celsoaquino.backend.repository.VeiculoRepository;
import com.celsoaquino.backend.service.MovimentoVagaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovimentoVagaServiceImpl implements MovimentoVagaService {


    private final MovimentoVagaRepository movimentoVagaRepository;
    private final VeiculoRepository veiculoRepository;
    private final VagaRepository vagaRepository;

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
        Vaga vaga = vagaRepository.getVagaById(veiculo.getVagaId());
        vaga.setVeiculoId(veiculo.getId());

        MovimentoVaga movimentoVaga = new MovimentoVaga();
        movimentoVaga.setVagaId(vagaId);
        movimentoVaga.setVeiculoId(veiculo.getId());
        movimentoVaga.setVeiculoPlaca(placa);
        return movimentoVagaRepository.save(movimentoVaga);
    }

    @Override
    public MovimentoVaga updateMovimentoVaga(String id) {
        MovimentoVaga movimentoVagaUpdate = movimentoVagaRepository.getMovimentoVagaByVeiculoId(id);
        movimentoVagaUpdate.setSaida(LocalDateTime.now());

        Duration duration = Duration.between(movimentoVagaUpdate.getEntrada(), movimentoVagaUpdate.getSaida());
        movimentoVagaUpdate.setDuracao(String.format("%d:%02d:%02d", duration.toHours(), duration.toMinutesPart(), duration.toSecondsPart()));

        Veiculo veiculo = veiculoRepository.getById(movimentoVagaUpdate.getVeiculoId());
        Vaga vaga = vagaRepository.getVagaById(veiculo.getVagaId());
        vaga.setVeiculoId(null);
        vaga.setFull(false);
        return movimentoVagaRepository.save(movimentoVagaUpdate);
    }

    @Override
    public MovimentoVaga getMovimentoVagaByVeiculoId(String id) {
        return movimentoVagaRepository.getMovimentoVagaByVeiculoId(id);
    }

    @Override
    public MovimentoVaga getMovimentoVagaById(String id) {
        return movimentoVagaRepository.findById(id).get();
    }
}
