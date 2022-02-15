package com.uepb.projetoWeb.domain.dto;

import com.uepb.projetoWeb.models.Conteudo;
import com.uepb.projetoWeb.models.Turma;
import com.uepb.projetoWeb.models.Usuario;

public class ConteudoDTO {

	public int id;
	public String nome;
	public String descricao;
	public int idTurma;
	
	public ConteudoDTO(Conteudo p) {
		this.id = p.getId();
		this.nome = p.getNome();
		this.descricao = p.getDescricao();
		this.idTurma = p.getIdTurma();
	}
}

