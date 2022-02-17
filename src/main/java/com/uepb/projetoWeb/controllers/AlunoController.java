package com.uepb.projetoWeb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AlunoController {
	
	//@Autowired
	//private AvaliacaoService avaliacaoService;
	
	@RequestMapping(value = "/alunos", method = RequestMethod.GET)
	public String avaliacao() {
		return "aluno/alunos";
	}

}
