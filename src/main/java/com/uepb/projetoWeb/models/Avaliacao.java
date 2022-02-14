package com.uepb.projetoWeb.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "avaliacao")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Avaliacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	@NotEmpty
	private String nome;
	
	@Column
	@NotEmpty
	private String dataInicio;
	
	@Column
	@NotEmpty
	private String dataFinal;
	
	@Column
	@NotEmpty
	private String descricao;
	
	@Column
	@NotEmpty
	private String nota;

	@ManyToOne
	private Turma turma;
}
