package com.uepb.projetoWeb.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uepb.projetoWeb.domain.dto.ConteudoAtualDTO;
import com.uepb.projetoWeb.domain.dto.UserAtualDTO;
import com.uepb.projetoWeb.models.ConteudoAtual;
import com.uepb.projetoWeb.models.UserAtual;
import com.uepb.projetoWeb.repository.ConteudoAtualRepository;
import com.uepb.projetoWeb.repository.UserAtualRepository;

@Service
@Component
public class ConteudoAtualService {
	
	@Autowired
	private ConteudoAtualRepository conteudoAtualRepository;
	
	public Optional<ConteudoAtual> findById(int id) {
		return  conteudoAtualRepository.findById(id);
	}
	
	public List<ConteudoAtualDTO> findAll(){
		return conteudoAtualRepository.findAll().stream().map(ConteudoAtualDTO::new).collect(Collectors.toList());
	}
	
	public ConteudoAtual findLastUser() {
		List<ConteudoAtualDTO> usuarios = findAll();
		ConteudoAtual user = new ConteudoAtual();
		user.setId(usuarios.get(usuarios.size()-1).getId());
		
		return user;
	}
	
	public ConteudoAtual create(ConteudoAtual userAtual) {
		return  conteudoAtualRepository.save(userAtual);
	}
	
	public void delete(int id) {
		Optional<ConteudoAtual> usuario = findById(id);
		if(usuario.isPresent()) {
			conteudoAtualRepository.deleteById((long) id);
		}
	}

}