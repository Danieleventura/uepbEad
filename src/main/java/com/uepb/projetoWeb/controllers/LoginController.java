package com.uepb.projetoWeb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uepb.projetoWeb.models.Login;
import com.uepb.projetoWeb.models.UserAtual;
import com.uepb.projetoWeb.models.Usuario;
import com.uepb.projetoWeb.service.UserAtualService;
import com.uepb.projetoWeb.service.UsuarioService;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private UserAtualService userAtualService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login() {
		return "login/login";
	}
	
	@RequestMapping(value = "/login/suporte", method = RequestMethod.GET)
	public String suporte() {
		return "login/suporte";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String login(Login login ) {
		
		Usuario u= usuarioService.findByEmailSenha(login.getEmail(), login.getSenha(), login.getTipo());
		UserAtual userAtual = new UserAtual(); // salvar no bd o id do usuario logado
		
		if (u == null) {
			return "redirect:/";
		}else {
			if ("professor".equalsIgnoreCase(u.getTipo())) {
				userAtual.setId(u.getId());
				UserAtual user = userAtualService.create(userAtual);
				return "professor/professor";
				
			}if ("aluno".equalsIgnoreCase(u.getTipo())) {
				userAtual.setId(u.getId());
				UserAtual user= userAtualService.create(userAtual);
				return "aluno/aluno";	
			}
		}
		return null;
	}

		
}
