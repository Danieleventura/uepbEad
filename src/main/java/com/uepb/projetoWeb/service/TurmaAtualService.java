package com.uepb.projetoWeb.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uepb.projetoWeb.domain.dto.TurmaAtualDTO;
import com.uepb.projetoWeb.domain.dto.UserAtualDTO;
import com.uepb.projetoWeb.domain.dto.UsuarioDTO;
import com.uepb.projetoWeb.models.TurmaAtual;
import com.uepb.projetoWeb.models.UserAtual;
import com.uepb.projetoWeb.models.Usuario;
import com.uepb.projetoWeb.repository.TurmaAtualRepository;
import com.uepb.projetoWeb.repository.UserAtualRepository;
import com.uepb.projetoWeb.repository.UsuarioRepository;

@Service
@Component
@Transactional
public class TurmaAtualService {
	
	@Autowired
	private TurmaAtualRepository turmaAtualRepository;
	
	public Optional<TurmaAtual> findById(int id) {
		return  turmaAtualRepository.findById(id);
	}
	
	public List<TurmaAtualDTO> findAll(){
		return turmaAtualRepository.findAll().stream().map(TurmaAtualDTO::new).collect(Collectors.toList());
	}
	
	public TurmaAtual findLastUser() {
		List<TurmaAtualDTO> usuarios = findAll();
		TurmaAtual user = new TurmaAtual();
		user.setId(usuarios.get(usuarios.size()-1).getId());
		
		return user;
	}
	
	public TurmaAtual create(TurmaAtual turmaAtual) {
		return  turmaAtualRepository.save(turmaAtual);
	}
	
	public void delete(int id) {
		Optional<TurmaAtual> usuario = findById(id);
		if(usuario.isPresent()) {
			turmaAtualRepository.deleteById((long) id);
		}
	}

}