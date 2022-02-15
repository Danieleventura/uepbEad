package com.uepb.projetoWeb.domain.dto;

import com.uepb.projetoWeb.models.ConteudoAtual;

import lombok.Data;

@Data
public class ConteudoAtualDTO {
	
	private int id;
	private int codigo;
	
	public ConteudoAtualDTO(ConteudoAtual p) {
		this.id = p.getId();
		this.codigo = p.getCodigo();
	}
}