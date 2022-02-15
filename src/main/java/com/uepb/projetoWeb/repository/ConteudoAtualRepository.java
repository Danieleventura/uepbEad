package com.uepb.projetoWeb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uepb.projetoWeb.models.ConteudoAtual;
import com.uepb.projetoWeb.models.UserAtual;


@Repository
public interface ConteudoAtualRepository extends JpaRepository<ConteudoAtual, Long> {

	Optional<ConteudoAtual> findById(int id);
	//UserAtual findLastUser();
}
