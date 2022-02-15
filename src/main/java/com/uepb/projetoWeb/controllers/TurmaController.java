package com.uepb.projetoWeb.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uepb.projetoWeb.domain.dto.ConteudoDTO;
import com.uepb.projetoWeb.domain.dto.TurmaDTO;
import com.uepb.projetoWeb.models.Conteudo;
import com.uepb.projetoWeb.models.Turma;
import com.uepb.projetoWeb.models.TurmaAtual;
import com.uepb.projetoWeb.models.UserAtual;
import com.uepb.projetoWeb.models.Usuario;
import com.uepb.projetoWeb.repository.UsuarioRepository;
import com.uepb.projetoWeb.service.TurmaAtualService;
import com.uepb.projetoWeb.service.TurmaService;
import com.uepb.projetoWeb.service.UserAtualService;
import com.uepb.projetoWeb.service.UsuarioService;

@Controller
public class TurmaController {
	
	@Autowired
	private TurmaService turmaService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private TurmaAtualService turmaAtualService;
	
	@RequestMapping(value = "/cadastro/turma", method = RequestMethod.GET)
	public String cadastro() {
		return "turma/formTurma";
	}
	
	@RequestMapping(value = "/cadastro/turma", method = RequestMethod.POST)
	public String cadastro(@Valid Turma turma, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastro/turma";
		}
		Usuario professor = usuarioService.findByUser(); // pegando o usuario logado
		turma.setProfessor(professor);
		Turma a = turmaService.create(turma);
		attributes.addFlashAttribute("mensagem", "Turma adicioncado com sucesso!");
		return "redirect:/turmas";
	}
	
	@RequestMapping(value = "/turmas", method = RequestMethod.GET)
	public ModelAndView turmas() {
		
		ModelAndView mv = new ModelAndView("turma/turma");
		Usuario professor = usuarioService.findByUser();
		Iterable<Turma> turmas = turmaService.findByProfessorId(professor.getId());
		mv.addObject("turmas", turmas);
		
		return mv;
	}
	
	@RequestMapping(value = "/turma/{id}")
	public ModelAndView detalhesTurmas(@PathVariable("id") int id) {
		Turma turma = turmaService.findById(id);
		TurmaAtual turmaAtual = new TurmaAtual();
		turmaAtual.setId(turma.getId());
		TurmaAtual user = turmaAtualService.create(turmaAtual);
		ModelAndView mv = new ModelAndView("turma/detalheTurma");
		mv.addObject("turma", turma);
		
		return mv;
		
	}
}
