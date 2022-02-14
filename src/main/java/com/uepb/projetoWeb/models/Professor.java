package com.uepb.projetoWeb.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "professor")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Professor {
	
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

	
}
