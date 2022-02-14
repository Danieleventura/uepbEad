package com.uepb.projetoWeb.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuario")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	@NotEmpty
	private String matricula;
	
	@Column
	@NotEmpty
	private String nome;
	
	@Column
	@NotEmpty
	private String curso;
	
	@Column
	@NotEmpty
	private String email;
	
	@Column
	@NotEmpty
	private String senha;
	
	@Column
	@NotEmpty
	private String tipo;
	
	@ManyToOne(cascade={ CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE })
	private Turma turma;
	
}
