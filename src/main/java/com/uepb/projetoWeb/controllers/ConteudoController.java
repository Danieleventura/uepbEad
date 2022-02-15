package com.uepb.projetoWeb.controllers;

import javax.transaction.Transactional;
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
import com.uepb.projetoWeb.models.Conteudo;
import com.uepb.projetoWeb.models.ConteudoAtual;
import com.uepb.projetoWeb.models.Turma;
import com.uepb.projetoWeb.service.ConteudoAtualService;
import com.uepb.projetoWeb.service.ConteudoService;
import com.uepb.projetoWeb.service.TurmaService;

@Controller
@Transactional
public class ConteudoController {
	
	@Autowired
	private ConteudoService conteudoService;
	@Autowired
	private TurmaService turmaService;
	@Autowired
	private ConteudoAtualService conteudoAtualService;
	
	@RequestMapping(value = "/cadastro/conteudo", method = RequestMethod.GET)
	public String conteudo() {
		return "turma/formConteudo";
	}
	
	@RequestMapping(value = "/cadastro/conteudo", method = RequestMethod.POST)
	public String conteudo(@Valid Conteudo conteudo, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastro/conteudo";
		}
		Turma turma = turmaService.findByUser();  // pegando turma para alocar no conteudo
		conteudo.setIdTurma(turma.getId());
		Conteudo a = conteudoService.create(conteudo);
		attributes.addFlashAttribute("mensagem", "Conteudo adicioncado com sucesso!");
		
		return "redirect:/conteudo";
	}
	
	@RequestMapping(value = "/conteudo", method = RequestMethod.GET)
	public ModelAndView conteudos() {
		
		ModelAndView mv = new ModelAndView("turma/conteudo");
		Turma turma = turmaService.findByUser();
		Iterable<ConteudoDTO> conteudos = conteudoService.findByTurma(turma.getId());
		mv.addObject("conteudos", conteudos);
		
		return mv;
	}
	
	@RequestMapping(value = "/conteudo/{id}", method = RequestMethod.GET )
	public ModelAndView detalhesConteudo(@PathVariable("id") int id) {
		ConteudoAtual conteudoAtual = new ConteudoAtual();
		conteudoAtual.setId(id);
		ConteudoAtual user = conteudoAtualService.create(conteudoAtual);
		Conteudo conteudo = conteudoService.findById(id);
		
		ModelAndView mv = new ModelAndView("turma/detalheConteudo");
		mv.addObject("conteudo", conteudo);
		
		return mv;
		
	}
	
	@RequestMapping(value = "/conteudo/apagar")
	public String deletarConteudo(int id) {
		
		conteudoService.delete(id);
		
		return "redirect:/conteudo";
	}
	
	@RequestMapping(value = "/conteudo/editar/", method = RequestMethod.POST)
	public String editarConteudo(Conteudo conteudo) {
		Conteudo c = conteudoService.findByLasConteudo();
		conteudo.setIdTurma(c.getIdTurma());
		conteudo.setId(c.getId());
		conteudoService.update(conteudo, c.getId());
		return "redirect:/conteudo";
	}
	
	@RequestMapping(value = "/conteudo/editar", method = RequestMethod.GET)
	public String editarConteudo() {
		
		return "turma/formEditarConteudo";
	}
}
