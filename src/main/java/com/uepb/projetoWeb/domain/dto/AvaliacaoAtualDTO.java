package com.uepb.projetoWeb.domain.dto;

import com.uepb.projetoWeb.models.AvaliacaoAtual;

import lombok.Data;

@Data
public class AvaliacaoAtualDTO {
	
	private int id;
	private int codigo;
	
	public AvaliacaoAtualDTO(AvaliacaoAtual p) {
		this.id = p.getId();
		this.codigo = p.getCodigo();
	}
}