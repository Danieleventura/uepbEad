package com.uepb.projetoWeb.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "turmaAtual")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TurmaAtual {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo;
	@Column
	private int id;
	
}
