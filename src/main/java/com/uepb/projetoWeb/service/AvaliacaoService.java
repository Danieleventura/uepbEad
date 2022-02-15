package com.uepb.projetoWeb.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uepb.projetoWeb.domain.dto.AvaliacaoDTO;
import com.uepb.projetoWeb.domain.dto.ConteudoDTO;
import com.uepb.projetoWeb.models.Avaliacao;
import com.uepb.projetoWeb.models.Conteudo;
import com.uepb.projetoWeb.repository.AvaliacaoRepository;

@Service
@Component
@Transactional
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
	
	public void delete(int id) {
		Avaliacao avaliacao = findById(id);
		if (avaliacao != null) {
		avaliacaoRepository.deleteById(id);}
	}
	
	public Avaliacao update(Avaliacao p, int id) {
		
		Avaliacao optional = findById(id);
		p.setId(optional.getId());
		avaliacaoRepository.save(p);
		return p;
	}
}
