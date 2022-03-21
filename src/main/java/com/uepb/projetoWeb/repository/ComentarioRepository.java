package com.uepb.projetoWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uepb.projetoWeb.models.Comentario;
import com.uepb.projetoWeb.models.Conteudo;


@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
	void deleteByCodigo(int id);
	Comentario findByCodigo(int id);
	List<Comentario> findByIdConteudo(int id);
}

