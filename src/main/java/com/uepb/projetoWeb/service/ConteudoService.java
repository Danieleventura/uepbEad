package com.uepb.projetoWeb.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.uepb.projetoWeb.domain.dto.ConteudoDTO;
import com.uepb.projetoWeb.domain.dto.UsuarioDTO;
import com.uepb.projetoWeb.models.Conteudo;
import com.uepb.projetoWeb.repository.AvaliacaoRepository;
import com.uepb.projetoWeb.repository.ConteudoRepository;

@Service
@Component
public class ConteudoService {

	@Autowired
	private ConteudoRepository conteudoRepository;
	
	public Conteudo create(Conteudo conteudo) {
		return conteudoRepository.save(conteudo);
	}
	
	public List<ConteudoDTO> findAll(){
		return conteudoRepository.findAll().stream().map(ConteudoDTO::new).collect(Collectors.toList());
	}
	
	public Conteudo findById(int id) {
		return conteudoRepository.findById(id);
	}
}
