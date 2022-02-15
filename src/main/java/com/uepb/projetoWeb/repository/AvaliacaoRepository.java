package com.uepb.projetoWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uepb.projetoWeb.models.Avaliacao;


@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
	Avaliacao findById(int id);
	void deleteById(int id);

}

