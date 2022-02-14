package com.uepb.projetoWeb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uepb.projetoWeb.models.Professor;
import com.uepb.projetoWeb.models.Usuario;


@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {

	List<Professor> findByMatricula(String matricula);
	Optional<Professor> findByEmail(String email);
	Optional<Professor> findById(int id);
	void deleteById(Long id);
}
