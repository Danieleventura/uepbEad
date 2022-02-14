package com.uepb.projetoWeb.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "userAtual")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserAtual {

	@Id
	private int id;
	
}
