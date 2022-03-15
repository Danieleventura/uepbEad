package com.uepb.projetoWeb.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uepb.projetoWeb.domain.dto.AlunoTurmasDTO;
import com.uepb.projetoWeb.domain.dto.TurmaAtualDTO;
import com.uepb.projetoWeb.models.AlunoTurmas;
import com.uepb.projetoWeb.models.Turma;
import com.uepb.projetoWeb.models.TurmaAtual;
import com.uepb.projetoWeb.models.Usuario;
import com.uepb.projetoWeb.repository.AlunoTurmaRepository;
import com.uepb.projetoWeb.repository.TurmaAtualRepository;

@Service
@Component
@Transactional
public class AlunoTurmasService {
	
	@Autowired
	private AlunoTurmaRepository alunoTurmaRepository;
	@Autowired
	private UsuarioService usuarioService;
	
	public Optional<AlunoTurmas> findByCodigo(int codigo) {
		return  alunoTurmaRepository.findByCodigo(codigo);
	}
	
	public List<AlunoTurmasDTO> findAll(){
		return alunoTurmaRepository.findAll().stream().map(AlunoTurmasDTO::new).collect(Collectors.toList());
	}
	
	public Optional<Usuario> findByIdAluno(int id) {
		return usuarioService.findById(id);
	}
	
	/*public List<Turma> findCodigoTurma() {
		List<AlunoTurmasDTO> alunoTurmas = findAll();
		AlunoTurmas user = new AlunoTurmas();
		user.setId(alunoTurmas.get(alunoTurmas.size()-1).getId());
		
		//return user;
	}*/
	
	public AlunoTurmas create(AlunoTurmas turmaAtual) {
		return  alunoTurmaRepository.save(turmaAtual);
	}
	
	public void delete(int id) {
		Optional<AlunoTurmas> usuario = findByCodigo(id);
		if(usuario.isPresent()) {
			alunoTurmaRepository.deleteById((long) id);
		}
	}

}