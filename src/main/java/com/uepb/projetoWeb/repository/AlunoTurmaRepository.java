package com.uepb.projetoWeb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uepb.projetoWeb.models.AlunoTurmas;


@Repository
public interface AlunoTurmaRepository extends JpaRepository<AlunoTurmas, Long> {

	Optional<AlunoTurmas> findByCodigo(int codigo);
}
