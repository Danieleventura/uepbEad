package com.uepb.projetoWeb.domain.dto;

import java.util.List;

import com.uepb.projetoWeb.models.Avaliacao;
import com.uepb.projetoWeb.models.Conteudo;
import com.uepb.projetoWeb.models.Turma;
import com.uepb.projetoWeb.models.Usuario;

import lombok.Data;

@Data
public class TurmaDTO {
	
	private int id;
	private String nome;
	private String horario;
	private int idProfessor;
	
	public TurmaDTO(Turma p) {
		this.id = p.getId();
		this.nome = p.getNome();
		this.horario = p.getHorario();
		this.idProfessor = p.getIdProfessor();
	}
}