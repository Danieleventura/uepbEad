package com.uepb.projetoWeb.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uepb.projetoWeb.models.Turma;
import com.uepb.projetoWeb.models.TurmaAtual;
import com.uepb.projetoWeb.models.Usuario;
import com.uepb.projetoWeb.service.TurmaAtualService;
import com.uepb.projetoWeb.service.TurmaService;
import com.uepb.projetoWeb.service.UsuarioService;

@Controller
public class AlunoController {
	
	@Autowired
	private UsuarioService usuarioService;
	public Usuario aluno;
	@Autowired
	private TurmaService turmaService;
	@Autowired
	private TurmaAtualService turmaAtualService;
	
	@RequestMapping(value = "/alunos", method = RequestMethod.GET) //metodo para listar alunos de uma turma
	public ModelAndView turmasAluno() {
		
		ModelAndView mv = new ModelAndView("turma/alunos");
		Turma turma = turmaService.findByUser();
		List<Usuario> aluno = usuarioService.findCodigoTurma(turma.getCodigo());
		mv.addObject("aluno", aluno);
		
		return mv;
	}
	
	@RequestMapping(value = "/aluno/{id}", method = RequestMethod.GET)
	public String aluno(@PathVariable("id") int id) {
		Optional<Usuario> p = usuarioService.findById( id);
		if (p.isPresent()) {
			aluno = p.get();}
		return "aluno/aluno";
	}
	
	@RequestMapping(value = "/aluno", method = RequestMethod.GET)
	public String aluno() {
		return "aluno/aluno";
	}
	
	@RequestMapping(value = "/perfil/aluno", method = RequestMethod.GET)
	public ModelAndView perfil() {
		
		ModelAndView mv = new ModelAndView("aluno/perfilAluno");
		Usuario aluno = usuarioService.findByUser();
		mv.addObject("aluno", aluno);
		
		return mv;
	}
	
	@RequestMapping(value = "/perfil/aluno/apagar")
	public String deletarPerfil() {
		
		Usuario usuario = usuarioService.findByUser();
		usuarioService.delete(usuario.getId());
		
		return "redirect:/";
	}

	@RequestMapping(value = "/perfil/aluno/editar", method = RequestMethod.GET)
	public ModelAndView editarPerfil() {
		ModelAndView mv = new ModelAndView("aluno/formPerfil");
		Usuario aluno = usuarioService.findByUser();
		mv.addObject("aluno", aluno);
		return mv;
	}
	
	@RequestMapping(value = "/perfil/aluno/editar", method = RequestMethod.POST)
	public  String editarPerfil(Usuario usuario2, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/perfil/aluno/editar";
		}
		
		Usuario usuario = usuarioService.findByUser();
		usuarioService.update(usuario2, usuario.getId());
		
		attributes.addFlashAttribute("mensagem", "Usuario atualizado com sucesso!");
		
		return "redirect:/perfil/aluno";
	}
}
