package com.uepb.projetoWeb.domain.dto;

import com.uepb.projetoWeb.models.Avaliacao;
import com.uepb.projetoWeb.models.Turma;

public class AvaliacaoDTO {

	public int id;
	public String nome;
	public String dataInicio;
	public String dataFinal;
	public String descricao;
	public String nota;
	public Turma turma;
	
	public AvaliacaoDTO(Avaliacao p) {
		this.id = p.getId();
		this.nome = p.getNome();
		this.dataInicio = p.getDataInicio();
		this.dataFinal = p.getDataFinal();
		this.descricao = p.getDescricao();
		this.nota = p.getNota();
		this.turma = p.getTurma();
	}
}
