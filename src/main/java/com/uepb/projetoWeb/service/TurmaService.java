package com.uepb.projetoWeb.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uepb.projetoWeb.domain.dto.ConteudoDTO;
import com.uepb.projetoWeb.domain.dto.TurmaDTO;
import com.uepb.projetoWeb.models.Avaliacao;
import com.uepb.projetoWeb.models.Conteudo;
import com.uepb.projetoWeb.models.Turma;
import com.uepb.projetoWeb.models.TurmaAtual;
import com.uepb.projetoWeb.models.UserAtual;
import com.uepb.projetoWeb.models.Usuario;
import com.uepb.projetoWeb.repository.AvaliacaoRepository;
import com.uepb.projetoWeb.repository.TurmaAtualRepository;
import com.uepb.projetoWeb.repository.TurmaRepository;

@Service
@Component
@Transactional
public class TurmaService {

	@Autowired
	private TurmaRepository turmaRepository;
	@Autowired
	private TurmaAtualService turmaAtualService;
	
	public Turma create(Turma turma) {
		return turmaRepository.save(turma);
	}

	public List<TurmaDTO> findAll(){
		return turmaRepository.findAll().stream().map(TurmaDTO::new).collect(Collectors.toList());
	}
	
	public List<Turma> findByIdProfessor(int id) {
		return turmaRepository.findByIdProfessor(id);
	}

	public Turma findById(int id) {
		return turmaRepository.findById(id);
	}
	
	public Turma findByUser() {
		TurmaAtual user = turmaAtualService.findLastUser();
		Turma turmaBD = new Turma();
		
		Turma u = turmaRepository.findById(user.getId());
		if (u != null) {
			turmaBD = u;
			}
		return turmaBD;
	}

	public void delete(int id) {
		Turma turma = findById(id);
		if (turma != null) {
			turmaRepository.deleteById(id);}
	}
	
	public Turma update(Turma p, int id) {
		
		Turma optional = findById(id);
		p.setId(optional.getId());
		turmaRepository.save(p);
		return p;
	}
	
}
