package com.celsoaquino.backend.service.impl;

import com.celsoaquino.backend.model.MovimentoVaga;
import com.celsoaquino.backend.model.Vaga;
import com.celsoaquino.backend.model.Veiculo;
import com.celsoaquino.backend.repository.MovimentoVagaRepository;
import com.celsoaquino.backend.repository.VagaRepository;
import com.celsoaquino.backend.repository.VeiculoRepository;
import com.celsoaquino.backend.service.MovimentoVagaService;
import com.celsoaquino.backend.service.VeiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MovimentoVagaServiceImpl implements MovimentoVagaService {


    private final MovimentoVagaRepository movimentoVagaRepository;
    private final VeiculoService veiculoService;
    private final VeiculoRepository veiculoRepository;
    private final VagaRepository vagaRepository;


    @Override
    public Page<MovimentoVaga> getMovimentoVagas(Pageable pageable) {
        return movimentoVagaRepository.findAll(pageable);
    }


    @Override
    public MovimentoVaga createMovimentoVaga(String placa, Long vagaId) {

        Veiculo veiculo = new Veiculo();
        veiculo.setVagaId(vagaId);
        veiculo.setPlaca(placa);
        veiculoService.createVeiculo(veiculo);

        Vaga vaga = vagaRepository.getVagaById(veiculo.getVagaId());
        vaga.setVeiculoId(veiculo.getId());
        vaga.setFull(true);
        vagaRepository.save(vaga);

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
        veiculoRepository.deleteById(veiculo.getId());
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
    public List<MovimentoVaga> findAllMovimentos() {
        List<MovimentoVaga> list = movimentoVagaRepository.findAll();
        Collections.sort(list, Comparator.comparing(MovimentoVaga::getEntrada).reversed());
        return list;
    }


    @Override
    public MovimentoVaga getMovimentoVagaById(String id) {
        return movimentoVagaRepository.findById(id).get();
    }
}
