package com.uepb.projetoWeb.domain.dto;

import com.uepb.projetoWeb.models.Comentario;

import lombok.Data;

@Data
public class ComentarioDTO {
	
	private int codigo;
	private String nomeUsuario;
	private int idConteudo;
	private String comentario;
	
	public ComentarioDTO(Comentario p) {
		this.nomeUsuario = p.getNomeUsuario();
		this.codigo = p.getCodigo();
		this.idConteudo = p.getIdConteudo();
		this.comentario = p.getComentario();
	}
}