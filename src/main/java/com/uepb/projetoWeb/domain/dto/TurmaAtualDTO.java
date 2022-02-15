package com.uepb.projetoWeb.domain.dto;

import com.uepb.projetoWeb.models.TurmaAtual;

import lombok.Data;

@Data
public class TurmaAtualDTO {
	
	private int id;
	private int codigo;
	
	public TurmaAtualDTO(TurmaAtual p) {
		this.id = p.getId();
		this.codigo = p.getCodigo();
	}
}