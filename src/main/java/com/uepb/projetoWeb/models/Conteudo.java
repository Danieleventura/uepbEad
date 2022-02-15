package com.uepb.projetoWeb.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "conteudo")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Conteudo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	@NotEmpty
	private String nome;
	
	@Column
	@NotEmpty
	private String descricao;
	
	@Column
	private int idTurma;
	
}
