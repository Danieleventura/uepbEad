package com.uepb.projetoWeb.domain.dto;

import java.util.List;

import com.uepb.projetoWeb.models.Professor;
import com.uepb.projetoWeb.models.Usuario;

import lombok.Data;

@Data
public class ProfessorDTO {
	
	private int id;
	private String nome;
	private String matricula;
	private String curso;
	private String email;
	private String senha;
	private String tipo;

	public ProfessorDTO(Professor p) {
		this.id = p.getId();
		this.matricula = p.getMatricula();
		this.nome = p.getNome();
		this.curso = p.getCurso();
		this.email = p.getEmail();
		this.senha = p.getSenha();
		this.tipo = p.getTipo();
	}
}