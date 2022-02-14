package com.uepb.projetoWeb.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uepb.projetoWeb.domain.dto.AvaliacaoDTO;
import com.uepb.projetoWeb.domain.dto.ConteudoDTO;
import com.uepb.projetoWeb.models.Avaliacao;
import com.uepb.projetoWeb.repository.AvaliacaoRepository;

@Service
@Component
public class AvaliacaoService {

	@Autowired
	private AvaliacaoRepository avaliacaoRepository;
	
	public Avaliacao create(Avaliacao avaliacao) {
		return avaliacaoRepository.save(avaliacao);
	}
	
	public List<AvaliacaoDTO> findAll(){
		return  avaliacaoRepository.findAll().stream().map(AvaliacaoDTO::new).collect(Collectors.toList());
	}
	
	public Avaliacao findById(int id) {
		return avaliacaoRepository.findById(id);
	}
}
