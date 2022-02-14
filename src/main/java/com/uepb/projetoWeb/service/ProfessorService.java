package com.uepb.projetoWeb.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uepb.projetoWeb.domain.dto.ProfessorDTO;
import com.uepb.projetoWeb.domain.dto.UsuarioDTO;
import com.uepb.projetoWeb.models.Professor;
import com.uepb.projetoWeb.models.Usuario;
import com.uepb.projetoWeb.repository.ProfessorRepository;
import com.uepb.projetoWeb.repository.UsuarioRepository;

@Service
@Component
public class ProfessorService {
	
	@Autowired
	private ProfessorRepository professorRepository;
	
	//public List<ProfessorDTO> findAll(){
		//return professorRepository.findAll().stream().map(ProfessorDTO::new).collect(Collectors.toList());
	//}
	
	public Optional<Professor> findById(int id) {
		return professorRepository.findById(id);
	}
	
	public Optional<Professor> findByEmail(String email) {
		return professorRepository.findByEmail(email);
	}
	
	public Professor findByEmailSenha(String email, String senha, String tipo) {
		//metodo para validar email, mas no momento não esta validando
		Optional<Professor> optional = findByEmail(email);
		if (optional.isPresent()) {
			Professor usuarioBD = optional.get();
			if (usuarioBD.getEmail().equalsIgnoreCase(email) 
					&& usuarioBD.getSenha().equalsIgnoreCase(senha) 
					&& usuarioBD.getTipo().equalsIgnoreCase(tipo)) {
				return usuarioBD;
			}
			return usuarioBD;
		}
		return null;
	}
	

	//public List<ProfessorDTO> findByMatricula(String matricula) {
		//return professorRepository.findByMatricula(matricula).stream().map(ProfessorDTO::new).collect(Collectors.toList());
	//}
	
	public Professor create(Professor professor) {
		return professorRepository.save(professor);
	}
	
	public Professor update(Professor p, Long id) {
		
		Optional<Professor> optional = professorRepository.findById(id);
		if (optional.isPresent()) {
			Professor usuarioBD = optional.get();
			usuarioBD.setMatricula(p.getMatricula());
			usuarioBD.setNome(p.getNome());
			usuarioBD.setCurso(p.getCurso());
			usuarioBD.setEmail(p.getEmail());
			usuarioBD.setSenha(p.getSenha());
			
			professorRepository.save(usuarioBD);
			return usuarioBD;
		}
		else {
			throw new RuntimeException("Erro ao atualizar o usuario!");
		}
	}
	
	public void delete(Long id) {
		Optional<Professor> usuario = professorRepository.findById(id);
		if(usuario.isPresent()) {
			professorRepository.deleteById(id);
		}
	}

	

}