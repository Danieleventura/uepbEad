package com.uepb.projetoWeb.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uepb.projetoWeb.models.Usuario;
import com.uepb.projetoWeb.service.UsuarioService;

@Controller
public class CadastroController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/cadastro/usuario", method = RequestMethod.GET)
	public String cadastro() {
		return "login/suporte";
	}
	
	@RequestMapping(value = "/cadastro/cadastro", method = RequestMethod.GET)
	public String formCadastro() {
		return "login/formCadastro";
	}
	
	
	@RequestMapping(value = "/cadastro/cadastro", method = RequestMethod.POST)
	public String cadastro(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastro/conteudo";
		}
		if (usuario.getTipo().equalsIgnoreCase("professor")) {
			Usuario c = usuarioService.create(usuario);
		}
		
		if (usuario.getTipo().equalsIgnoreCase("aluno")) {
			Usuario c = usuarioService.create(usuario);
		}
		attributes.addFlashAttribute("mensagem", "Conteudo adicioncado com sucesso!");
		return "redirect:/";
	}

}
