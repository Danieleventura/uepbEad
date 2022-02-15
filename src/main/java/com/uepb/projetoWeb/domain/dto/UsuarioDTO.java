package com.uepb.projetoWeb.domain.dto;

import com.uepb.projetoWeb.models.Usuario;

import lombok.Data;

@Data
public class UsuarioDTO {
	
	private int id;
	private String nome;
	private String matricula;
	private String curso;
	private String email;
	private String senha;
	private String tipo;

	public UsuarioDTO(Usuario p) {
		this.id = p.getId();
		this.matricula = p.getMatricula();
		this.nome = p.getNome();
		this.curso = p.getCurso();
		this.email = p.getEmail();
		this.senha = p.getSenha();
		this.tipo = p.getTipo();
	}
}