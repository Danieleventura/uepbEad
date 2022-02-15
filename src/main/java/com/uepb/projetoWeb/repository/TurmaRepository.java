package com.uepb.projetoWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uepb.projetoWeb.models.Turma;
import com.uepb.projetoWeb.models.Usuario;


@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {

	Turma findById(int id);

	void deleteById(int id);

	List<Turma> findByIdProfessor(int id);
}

