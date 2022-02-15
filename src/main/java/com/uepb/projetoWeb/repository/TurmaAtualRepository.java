package com.uepb.projetoWeb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.uepb.projetoWeb.models.TurmaAtual;


@Repository
public interface TurmaAtualRepository extends JpaRepository<TurmaAtual, Long> {

	Optional<TurmaAtual> findById(int id);
}
