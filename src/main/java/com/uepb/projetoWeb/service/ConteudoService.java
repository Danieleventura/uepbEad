package com.uepb.projetoWeb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.uepb.projetoWeb.domain.dto.AvaliacaoDTO;
import com.uepb.projetoWeb.domain.dto.ConteudoDTO;
import com.uepb.projetoWeb.domain.dto.UsuarioDTO;
import com.uepb.projetoWeb.models.Conteudo;
import com.uepb.projetoWeb.models.ConteudoAtual;
import com.uepb.projetoWeb.models.Turma;
import com.uepb.projetoWeb.models.TurmaAtual;
import com.uepb.projetoWeb.models.Usuario;
import com.uepb.projetoWeb.repository.AvaliacaoRepository;
import com.uepb.projetoWeb.repository.ConteudoAtualRepository;
import com.uepb.projetoWeb.repository.ConteudoRepository;

@Service
@Component
@Transactional
public class ConteudoService {

	@Autowired
	private ConteudoRepository conteudoRepository;
	
	@Autowired
	private ConteudoAtualService conteudoAtualService;
	
	public Conteudo create(Conteudo conteudo) {
		return conteudoRepository.save(conteudo);
	}
	
	public List<ConteudoDTO> findAll(){
		return conteudoRepository.findAll().stream().map(ConteudoDTO::new).collect(Collectors.toList());
	}
	
	public Conteudo findById(int id) {
		return conteudoRepository.findById(id);
	}
	
	public void delete(int id) {
		Conteudo conteudo = findById(id);
		if (conteudo != null) {
		conteudoRepository.deleteById(id);}
	}
	
	public Conteudo update(Conteudo p, int id) {
		
		Conteudo optional = findById(id);
		p.setId(optional.getId());
		conteudoRepository.save(p);
		return p;
	}
	
	public List<ConteudoDTO> findByTurma(int idTurma) {
		List<ConteudoDTO> conteudo = new ArrayList<ConteudoDTO>();
		List<ConteudoDTO> aux = new ArrayList<ConteudoDTO>();
		aux = conteudoRepository.findAll().stream().map(ConteudoDTO::new).collect(Collectors.toList());
		for (int i=0; i< aux.size(); i++) {
			if (aux.get(i).idTurma == idTurma) {
				conteudo.add(aux.get(i));
			}
		}
		return conteudo;
	}
	
	public Conteudo findByLasConteudo() {
		ConteudoAtual user = conteudoAtualService.findLastUser();
		Conteudo conteudoBD = new Conteudo();
		
		Conteudo u = conteudoRepository.findById(user.getId());
		if (u != null) {
			conteudoBD = u;
			}
		return conteudoBD;
	}

}
