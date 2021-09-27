package com.celsoaquino.backend.repository;

import com.celsoaquino.backend.model.MovimentoVaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentoVagaRepository extends JpaRepository<MovimentoVaga, String> {
}
