package com.uepb.projetoWeb.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uepb.projetoWeb.domain.dto.AvaliacaoDTO;
import com.uepb.projetoWeb.models.Avaliacao;
import com.uepb.projetoWeb.models.Turma;


@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
	Avaliacao findById(int id);
	void deleteById(int id);

}

