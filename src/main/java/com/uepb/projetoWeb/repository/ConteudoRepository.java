package com.uepb.projetoWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uepb.projetoWeb.models.Conteudo;


@Repository
public interface ConteudoRepository extends JpaRepository<Conteudo, Long> {
	Conteudo findById(int id);
	void deleteById(int id);
}

