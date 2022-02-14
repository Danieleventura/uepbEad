package com.uepb.projetoWeb.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uepb.projetoWeb.models.Professor;
import com.uepb.projetoWeb.models.Usuario;
import com.uepb.projetoWeb.service.ProfessorService;
import com.uepb.projetoWeb.service.UsuarioService;

@Controller
public class CadastroController {

	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/cadastro/usuario", method = RequestMethod.GET)
	public String cadastro() {
		return "login/formCadastro";
	}
	
	@RequestMapping(value = "/cadastro/usuario", method = RequestMethod.POST)
	public String cadastro(@Valid Usuario usuario, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastro/conteudo";
		}
		if (usuario.getTipo().equalsIgnoreCase("professor")) {
			Professor a= new Professor();
			a.setCurso(usuario.getCurso());
			a.setEmail(usuario.getEmail());
			a.setId(usuario.getId());
			a.setMatricula(usuario.getMatricula());
			a.setNome(usuario.getNome());
			a.setSenha(usuario.getSenha());
			a.setTipo(usuario.getTipo());
			Professor c = professorService.create(a);
		}
		
		if (usuario.getTipo().equalsIgnoreCase("aluno")) {
			Usuario c = usuarioService.create(usuario);
		}
		attributes.addFlashAttribute("mensagem", "Conteudo adicioncado com sucesso!");
		return "redirect:/";
	}

}
