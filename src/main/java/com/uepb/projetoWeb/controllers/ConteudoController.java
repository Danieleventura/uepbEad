package com.uepb.projetoWeb.controllers;

import java.util.List;

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
import com.uepb.projetoWeb.models.Comentario;
import com.uepb.projetoWeb.models.Conteudo;
import com.uepb.projetoWeb.models.ConteudoAtual;
import com.uepb.projetoWeb.models.Turma;
import com.uepb.projetoWeb.models.Usuario;
import com.uepb.projetoWeb.service.ComentarioService;
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
	@Autowired
	private ComentarioService comentarioService;
	
	@RequestMapping(value = "/cadastro/conteudo", method = RequestMethod.GET)
	public String conteudo() {
		return "turma/formConteudo";
	}
	
	@RequestMapping(value = "/aluno/cadastro/conteudo", method = RequestMethod.GET)
	public String conteudoAluno() {
		return "turmaAluno/formConteudo";
	}
	
	@RequestMapping(value = "/cadastro/conteudo", method = RequestMethod.POST)
	public String conteudo(Conteudo conteudo) {
		
		Turma turma = turmaService.findByUser();  // pegando turma para alocar no conteudo
		conteudo.setIdTurma(turma.getId());
		Conteudo a = conteudoService.create(conteudo);
		
		return "redirect:/conteudo";
	}
	
	@RequestMapping(value = "/aluno/cadastro/conteudo", method = RequestMethod.POST)
	public String conteudoAluno(Conteudo conteudo) {
		
		Turma turma = turmaService.findByUser();  // pegando turma para alocar no conteudo
		conteudo.setIdTurma(turma.getId());
		Conteudo a = conteudoService.create(conteudo);
		
		return "redirect:/aluno/conteudo";
	}
	
	@RequestMapping(value = "/conteudo", method = RequestMethod.GET)
	public ModelAndView conteudos() {
		
		ModelAndView mv = new ModelAndView("turma/conteudo");
		Turma turma = turmaService.findByUser();
		Iterable<ConteudoDTO> conteudos = conteudoService.findByTurma(turma.getId());
		mv.addObject("conteudos", conteudos);
		
		return mv;
	}
	
	@RequestMapping(value = "/aluno/conteudo", method = RequestMethod.GET)
	public ModelAndView conteudosAluno() {
		
		ModelAndView mv = new ModelAndView("turmaAluno/conteudo");
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
	
	@RequestMapping(value = "/aluno/conteudo/{id}", method = RequestMethod.GET )
	public ModelAndView detalhesConteudoAluno(@PathVariable("id") int id) {
		ConteudoAtual conteudoAtual = new ConteudoAtual();
		conteudoAtual.setId(id);
		ConteudoAtual user = conteudoAtualService.create(conteudoAtual);
		Conteudo conteudo = conteudoService.findById(id);
		List<Comentario> comentario = comentarioService.findByIdConteudo(conteudo.getId());
		
		ModelAndView mv = new ModelAndView("turmaAluno/detalheConteudo");
		mv.addObject("conteudo", conteudo);
		mv.addObject("comentario", comentario);
		
		return mv;
		
	}
	
	@RequestMapping(value = "/aluno/conteudo/detalhe", method = RequestMethod.GET )
	public ModelAndView detalheConteudoAluno() {
		Conteudo c = conteudoService.findByLasConteudo();
		ConteudoAtual conteudoAtual = new ConteudoAtual();
		conteudoAtual.setId(c.getId());
		ConteudoAtual user = conteudoAtualService.create(conteudoAtual);
		Conteudo conteudo = conteudoService.findById(c.getId());
		List<Comentario> comentario = comentarioService.findByIdConteudo(conteudo.getId());
				
		ModelAndView mv = new ModelAndView("turmaAluno/detalheConteudo");
		mv.addObject("conteudo", conteudo);
		mv.addObject("comentario", comentario);
		
		return mv;
		
	}
	
	@RequestMapping(value = "/conteudo/detalhe", method = RequestMethod.GET )
	public ModelAndView detalheConteudo() {
		Conteudo c = conteudoService.findByLasConteudo();
		ConteudoAtual conteudoAtual = new ConteudoAtual();
		conteudoAtual.setId(c.getId());
		ConteudoAtual user = conteudoAtualService.create(conteudoAtual);
		Conteudo conteudo = conteudoService.findById(c.getId());
		
		ModelAndView mv = new ModelAndView("turma/detalheConteudo");
		mv.addObject("conteudo", conteudo);
		
		return mv;
		
	}
	
	@RequestMapping(value = "/conteudo/apagar")
	public String deletarConteudo(int id) {
		
		conteudoService.delete(id);
		
		return "redirect:/conteudo";
	}
	
	@RequestMapping(value = "/aluno/conteudo/apagar")
	public String deletarConteudoAluno(int id) {
		
		conteudoService.delete(id);
		
		return "redirect:/aluno/conteudo";
	}
	
	@RequestMapping(value = "/conteudo/editar/", method = RequestMethod.POST)
	public String editarConteudo(Conteudo conteudo) {
		Conteudo c = conteudoService.findByLasConteudo();
		conteudo.setIdTurma(c.getIdTurma());
		conteudo.setId(c.getId());
		conteudoService.update(conteudo, c.getId());
		return "redirect:/conteudo";
	}
	
	@RequestMapping(value = "/aluno/conteudo/editar/", method = RequestMethod.POST)
	public String editarConteudoAluno(Conteudo conteudo) {
		Conteudo c = conteudoService.findByLasConteudo();
		conteudo.setIdTurma(c.getIdTurma());
		conteudo.setId(c.getId());
		conteudoService.update(conteudo, c.getId());
		return "redirect:/aluno/conteudo";
	}
	
	@RequestMapping(value = "/conteudo/editar", method = RequestMethod.GET)
	public ModelAndView editarConteudo() {
		Conteudo c = conteudoService.findByLasConteudo();
		Conteudo conteudo = conteudoService.findById(c.getId());
		
		ModelAndView mv = new ModelAndView("turma/formEditarConteudo");
		mv.addObject("conteudo", conteudo);
		
		return mv;
	}
	
	@RequestMapping(value = "/aluno/conteudo/editar", method = RequestMethod.GET)
	public ModelAndView editarConteudoAluno() {
		Conteudo c = conteudoService.findByLasConteudo();
		Conteudo conteudo = conteudoService.findById(c.getId());
		
		ModelAndView mv = new ModelAndView("turmaAluno/formEditarConteudo");
		mv.addObject("conteudo", conteudo);
		
		return mv;
	}
}
