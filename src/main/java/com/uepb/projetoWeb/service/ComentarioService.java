package com.uepb.projetoWeb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uepb.projetoWeb.domain.dto.ComentarioDTO;
import com.uepb.projetoWeb.domain.dto.ConteudoDTO;
import com.uepb.projetoWeb.models.Comentario;
import com.uepb.projetoWeb.models.Conteudo;
import com.uepb.projetoWeb.models.ConteudoAtual;
import com.uepb.projetoWeb.repository.ComentarioRepository;
import com.uepb.projetoWeb.repository.ConteudoRepository;

@Service
@Component
@Transactional
public class ComentarioService {

	@Autowired
	private ComentarioRepository comentarioRepository;

	
	public Comentario create(Comentario comentario) {
		return comentarioRepository.save(comentario);
	}
	
	public List<ComentarioDTO> findAll(){
		return comentarioRepository.findAll().stream().map(ComentarioDTO::new).collect(Collectors.toList());
	}
	
	public Comentario findById(int id) {
		return comentarioRepository.findByCodigo(id);
	}
	
	public List<Comentario> findByIdConteudo(int id) {
		return comentarioRepository.findByIdConteudo(id);
	}
	
	public void delete(int id) {
		Comentario c = findById(id);
		if (c != null) {
			comentarioRepository.deleteByCodigo(id);}
	}
	
}
	
/*	public List<ConteudoDTO> findByTurma(int idTurma) {
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

}*/
