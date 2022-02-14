package com.uepb.projetoWeb.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uepb.projetoWeb.domain.dto.UsuarioDTO;
import com.uepb.projetoWeb.models.Usuario;
import com.uepb.projetoWeb.service.UsuarioService;


@RestController
@RequestMapping("/api/v1/professor")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> get() {
		return ResponseEntity.ok(usuarioService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> get(@PathVariable("id") int id) {
		Optional<Usuario> professor = usuarioService.findById(id);
		return professor.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
		
	}
	
	@GetMapping("/matricula/{matricula}")
	public ResponseEntity<List<UsuarioDTO>> getProfessoresByMatricula(@PathVariable("matricula") String matricula) {
		List<UsuarioDTO> listaProfessores = usuarioService.findByMatricula(matricula);
		return listaProfessores.isEmpty() ? 
				ResponseEntity.noContent().build() :
				ResponseEntity.ok(listaProfessores);
	}
	
	//@PutMapping("/{id}")
	//public String updateProfessor(@PathVariable("id") int id, @RequestBody Usuario professor) {
	//	Usuario c = usuarioService.update(professor, id);
	//	return "Professor atualizado com sucesso: " + c.getId();
	//}
	
	@PostMapping()
	public String createProfessor(@RequestBody Usuario professor) {
		Usuario c = usuarioService.create(professor);
		return "Professor salvo com sucesso: " + c.getId();
	}
	
	//@DeleteMapping("/{id}")
	//public String deleteProfessor(@PathVariable("id") Long id) {
	//	usuarioService.delete(id);
	//	return "Professor removido com sucesso!";
	//}
	
}