package com.uepb.projetoWeb.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uepb.projetoWeb.models.Turma;
import com.uepb.projetoWeb.models.UserAtual;
import com.uepb.projetoWeb.models.Usuario;
import com.uepb.projetoWeb.repository.UsuarioRepository;
import com.uepb.projetoWeb.service.TurmaService;
import com.uepb.projetoWeb.service.UserAtualService;
import com.uepb.projetoWeb.service.UsuarioService;

@Controller
public class TurmaController {
	
	@Autowired
	private TurmaService turmaService;
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/turmas", method = RequestMethod.GET)
	public String avaliacao() {
		return "turma/turma";
	}
	
	@RequestMapping(value = "/cadastro/turma", method = RequestMethod.GET)
	public String cadastro() {
		return "turma/formTurma";
	}
	
	@RequestMapping(value = "/cadastro/turma", method = RequestMethod.POST)
	public String cadastro(@Valid Turma turma, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastro/conteudo";
		}
		Usuario professor = usuarioService.findByUser();
		turma.setProfessor(professor);
		Turma a = turmaService.create(turma);
		attributes.addFlashAttribute("mensagem", "Conteudo adicioncado com sucesso!");
		return "redirect:/turmas";
	}
}
