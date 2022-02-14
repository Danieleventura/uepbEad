package com.uepb.projetoWeb.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uepb.projetoWeb.models.Usuario;
import com.uepb.projetoWeb.service.AvaliacaoService;
import com.uepb.projetoWeb.service.UsuarioService;

@Controller
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
	
}
