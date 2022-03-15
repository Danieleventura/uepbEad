package com.uepb.projetoWeb.domain.dto;

import com.uepb.projetoWeb.models.AlunoTurmas;

import lombok.Data;

@Data
public class AlunoTurmasDTO {
	
	private int idAluno;
	private int codigo;
	private String codigoTurma;
	
	public AlunoTurmasDTO(AlunoTurmas p) {
		this.idAluno = p.getIdAluno();
		this.codigo = p.getCodigo();
		this.codigoTurma = p.getCodigoTurma();
	}
}