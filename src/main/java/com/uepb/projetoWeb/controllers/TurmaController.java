package com.uepb.projetoWeb.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uepb.projetoWeb.models.Professor;
import com.uepb.projetoWeb.models.Turma;
import com.uepb.projetoWeb.repository.ProfessorRepository;
import com.uepb.projetoWeb.service.AvaliacaoService;
import com.uepb.projetoWeb.service.TurmaService;

@Controller
public class TurmaController {
	
	@Autowired
	private TurmaService turmaService;
	
	@Autowired
	private ProfessorRepository professorRepository;
	
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
		//Professor usuarioBD = null;
		//Optional<Professor> optional = professorRepository.findById(Integer.parseInt(System.getProperty("id")));
		//if (optional.isPresent()) {
			//usuarioBD = optional.get();
			//turma.setProfessor(usuarioBD);}
		//System.out.println(System.getProperty("id"));

		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastro/conteudo";
		}
		Turma a = turmaService.create(turma);
		attributes.addFlashAttribute("mensagem", "Conteudo adicioncado com sucesso!");
		return "redirect:/turmas";
	}
}
