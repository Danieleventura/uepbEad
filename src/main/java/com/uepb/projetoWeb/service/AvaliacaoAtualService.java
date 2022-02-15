package com.uepb.projetoWeb.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uepb.projetoWeb.domain.dto.AvaliacaoAtualDTO;
import com.uepb.projetoWeb.domain.dto.ConteudoAtualDTO;
import com.uepb.projetoWeb.domain.dto.UserAtualDTO;
import com.uepb.projetoWeb.models.AvaliacaoAtual;
import com.uepb.projetoWeb.models.ConteudoAtual;
import com.uepb.projetoWeb.models.UserAtual;
import com.uepb.projetoWeb.repository.AvaliacaoAtualRepository;
import com.uepb.projetoWeb.repository.ConteudoAtualRepository;
import com.uepb.projetoWeb.repository.UserAtualRepository;

@Service
@Component
public class AvaliacaoAtualService {
	
	@Autowired
	private AvaliacaoAtualRepository avaliacaoAtualRepository;
	
	public Optional<AvaliacaoAtual> findById(int id) {
		return  avaliacaoAtualRepository.findById(id);
	}
	
	public List<AvaliacaoAtualDTO> findAll(){
		return avaliacaoAtualRepository.findAll().stream().map(AvaliacaoAtualDTO::new).collect(Collectors.toList());
	}
	
	public AvaliacaoAtual findLastUser() { // encontrar a avaliacao que esta sendo acessada
		List<AvaliacaoAtualDTO> usuarios = findAll();
		AvaliacaoAtual user = new AvaliacaoAtual();
		user.setId(usuarios.get(usuarios.size()-1).getId());
		
		return user;
	}
	
	public AvaliacaoAtual create(AvaliacaoAtual userAtual) {
		return  avaliacaoAtualRepository.save(userAtual);
	}
	
	public void delete(int id) {
		Optional<AvaliacaoAtual> usuario = findById(id);
		if(usuario.isPresent()) {
			avaliacaoAtualRepository.deleteById((long) id);
		}
	}

}