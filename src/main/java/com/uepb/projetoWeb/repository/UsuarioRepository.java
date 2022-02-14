package com.uepb.projetoWeb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uepb.projetoWeb.models.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	List<Usuario> findByMatricula(String matricula);
	Optional<Usuario> findByEmail(String email);
	Optional<Usuario> findById(Long id);
	void deleteById(Long id);
}
