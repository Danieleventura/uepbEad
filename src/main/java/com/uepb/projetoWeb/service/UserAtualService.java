package com.uepb.projetoWeb.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uepb.projetoWeb.domain.dto.UserAtualDTO;
import com.uepb.projetoWeb.models.UserAtual;
import com.uepb.projetoWeb.repository.UserAtualRepository;

@Service
@Component
public class UserAtualService {
	
	@Autowired
	private UserAtualRepository userAtualRepository;
	
	public Optional<UserAtual> findById(int id) {
		return  userAtualRepository.findById(id);
	}
	
	public List<UserAtualDTO> findAll(){
		return userAtualRepository.findAll().stream().map(UserAtualDTO::new).collect(Collectors.toList());
	}
	
	public UserAtual findLastUser() {
		List<UserAtualDTO> usuarios = findAll();
		UserAtual user = new UserAtual();
		user.setId(usuarios.get(usuarios.size()-1).getId());
		
		return user;
	}
	
	public UserAtual create(UserAtual userAtual) {
		return  userAtualRepository.save(userAtual);
	}
	
	public void delete(int id) {
		Optional<UserAtual> usuario = findById(id);
		if(usuario.isPresent()) {
			userAtualRepository.deleteById((long) id);
		}
	}

}