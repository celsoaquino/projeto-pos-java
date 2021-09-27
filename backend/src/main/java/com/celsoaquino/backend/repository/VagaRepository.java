package com.celsoaquino.backend.repository;

import com.celsoaquino.backend.model.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, String> {
    Vaga getVagaById(Long id);
}
