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

import com.uepb.projetoWeb.domain.dto.AvaliacaoDTO;
import com.uepb.projetoWeb.domain.dto.ConteudoDTO;
import com.uepb.projetoWeb.models.Avaliacao;
import com.uepb.projetoWeb.service.AvaliacaoService;

@Controller
public class AvaliacaoController {
	
	@Autowired
	private AvaliacaoService avaliacaoService;
	
	@RequestMapping(value = "/cadastro/avaliacao", method = RequestMethod.GET)
	public String formAvaliacao() {
		return "turma/formAvaliacao";
	}
	
	@RequestMapping(value = "/cadastro/avaliacao", method = RequestMethod.POST)
	public String avalicao(@Valid Avaliacao avaliacao, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/cadastro/conteudo";
		}
		Avaliacao a = avaliacaoService.create(avaliacao);
		attributes.addFlashAttribute("mensagem", "Verifique os campos!");
		return "redirect:/avaliacao";
	}
	
	@RequestMapping(value = "/avaliacao", method = RequestMethod.GET)
	public ModelAndView avaliacao() {
		
		ModelAndView mv = new ModelAndView("turma/avaliacao");
		Iterable<AvaliacaoDTO> avaliacoes = avaliacaoService.findAll();
		mv.addObject("avaliacoes", avaliacoes);
		
		return mv;
	}
	
	@RequestMapping(value = "/avaliacao/{id}")
	public ModelAndView detalhesAvaliacao(@PathVariable("id") int id) {
		
		ModelAndView mv = new ModelAndView("turma/detalheAvaliacao");
		Avaliacao avaliacao = avaliacaoService.findById(id);
		mv.addObject("avaliacao", avaliacao);
		
		return mv;
	}
}
