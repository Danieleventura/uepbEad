package com.uepb.projetoWeb.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Login {

	private String email;
	
	private String senha;
	
	private String tipo;

	
}
