package com.celsoaquino.backend.service.impl;

import com.celsoaquino.backend.model.Veiculo;
import com.celsoaquino.backend.repository.VeiculoRepository;
import com.celsoaquino.backend.service.VeiculoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class VeiculoServiceImpl implements VeiculoService {
    private final VeiculoRepository veiculoRepository;
    @Override
    public void createVeiculo(Veiculo veiculo) {
        veiculoRepository.save(veiculo);
    }
}
