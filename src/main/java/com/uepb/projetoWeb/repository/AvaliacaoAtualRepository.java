package com.uepb.projetoWeb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uepb.projetoWeb.models.AvaliacaoAtual;


@Repository
public interface AvaliacaoAtualRepository extends JpaRepository<AvaliacaoAtual, Long> {

	Optional<AvaliacaoAtual> findById(int id);
	//UserAtual findLastUser();
}
