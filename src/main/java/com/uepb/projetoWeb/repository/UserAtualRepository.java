package com.uepb.projetoWeb.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uepb.projetoWeb.models.UserAtual;
import com.uepb.projetoWeb.models.Usuario;


@Repository
public interface UserAtualRepository extends JpaRepository<UserAtual, Long> {

	Optional<UserAtual> findById(int id);
	//UserAtual findLastUser();
}
