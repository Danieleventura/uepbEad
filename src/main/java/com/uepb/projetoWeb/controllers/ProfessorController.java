package com.uepb.projetoWeb.controllers;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uepb.projetoWeb.models.Usuario;
import com.uepb.projetoWeb.service.UsuarioService;

@Controller
@Transactional
public class ProfessorController {
	
	@Autowired
	private UsuarioService usuarioService;
	public Usuario professor;
	
	@RequestMapping(value = "/professor/{id}", method = RequestMethod.GET)
	public String professor(@PathVariable("id") int id) {
		Optional<Usuario> p = usuarioService.findById( id);
		if (p.isPresent()) {
				professor = p.get();}
		return "professor/professor";
	}
	
	@RequestMapping(value = "/professor", method = RequestMethod.GET)
	public String professor() {
		return "professor/professor";
	}
	
	@RequestMapping(value = "/perfil", method = RequestMethod.GET)
	public ModelAndView perfil() {
		
		ModelAndView mv = new ModelAndView("professor/perfil");
		Usuario professor = usuarioService.findByUser();
		mv.addObject("professor", professor);
		
		return mv;
	}
	
	@RequestMapping(value = "/perfil/apagar")
	public String deletarPerfil() {
		
		Usuario usuario = usuarioService.findByUser();
		usuarioService.delete(usuario.getId());
		
		return "redirect:/";
	}

	@RequestMapping(value = "/perfil/editar", method = RequestMethod.GET)
	public String editarPerfil() {
		
		return "professor/formPerfil";
	}
	
	@RequestMapping(value = "/perfil/editar", method = RequestMethod.POST)
	public  String editarPerfil(Usuario usuario2, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos!");
			return "redirect:/perfil/editar";
		}
		
		Usuario usuario = usuarioService.findByUser();
		usuarioService.update(usuario2, usuario.getId());
		
		attributes.addFlashAttribute("mensagem", "Usuario atualizado com sucesso!");
		
		return "redirect:/perfil";
	}
}
