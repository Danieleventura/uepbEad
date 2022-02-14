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
	private Usuario professor;
	private List<Usuario> aluno;
	private List<Conteudo> conteudo;
	private List<Avaliacao> avaliacao;
	
	public TurmaDTO(Turma p) {
		this.id = p.getId();
		this.nome = p.getNome();
		this.horario = p.getHorario();
		this.professor = p.getProfessor();
		this.aluno = p.getAlunos();
		this.avaliacao = p.getAvaliacoes();
		this.conteudo = p.getConteudos();
	}
}