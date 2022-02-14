package com.uepb.projetoWeb.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uepb.projetoWeb.models.Login;
import com.uepb.projetoWeb.models.Professor;
import com.uepb.projetoWeb.models.Usuario;
import com.uepb.projetoWeb.service.ProfessorService;
import com.uepb.projetoWeb.service.UsuarioService;

@Controller
public class LoginController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private ProfessorService professorService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login() {
		return "login/login";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String login(Login login ,RedirectAttributes rm) {
		
		if (login.getTipo().equalsIgnoreCase("professor")) {
			Professor a = professorService.findByEmailSenha(login.getEmail(), login.getSenha(), login.getTipo());
			if (a == null) {
				return "redirect:/";
			}else {
				if ("professor".equalsIgnoreCase(a.getTipo())) {
					rm.addAttribute("id", a.getId());
					System.setProperty("id", Integer.toString(a.getId()));
					System.out.println(System.getProperty("id"));
					return "redirect:/professor/{id}";	
				}
		}
		}
		if (login.getTipo().equalsIgnoreCase("aluno")) {
			Usuario u= usuarioService.findByEmailSenha(login.getEmail(), login.getSenha(), login.getTipo());
			if (u == null) {
				return "redirect:/";
			}else {
				if ("aluno".equalsIgnoreCase(u.getTipo())) {
					rm.addAttribute("id", u.getId());
						
					return "redirect:cadastro/usuario";	
				}
			}
		}
			//if ("suporte".equalsIgnoreCase(a.getTipo())) {
				
				//return "redirect:/suporte";	
			//}	
		return null;
	}

		
}
