package com.uepb.projetoWeb.domain.dto;

import com.uepb.projetoWeb.models.UserAtual;

import lombok.Data;

@Data
public class UserAtualDTO {
	
	private int id;
	private int codigo;
	
	public UserAtualDTO(UserAtual p) {
		this.id = p.getId();
		this.codigo = p.getCodigo();
	}
}