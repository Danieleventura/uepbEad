package com.uepb.projetoWeb.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uepb.projetoWeb.domain.dto.ConteudoDTO;
import com.uepb.projetoWeb.domain.dto.TurmaDTO;
import com.uepb.projetoWeb.models.Turma;
import com.uepb.projetoWeb.models.Usuario;
import com.uepb.projetoWeb.repository.AvaliacaoRepository;
import com.uepb.projetoWeb.repository.TurmaRepository;

@Service
@Component
public class TurmaService {

	@Autowired
	private TurmaRepository turmaRepository;
	
	public Turma create(Turma turma) {
		return turmaRepository.save(turma);
	}

	public List<TurmaDTO> findAll(){
		return turmaRepository.findAll().stream().map(TurmaDTO::new).collect(Collectors.toList());
	}
	
	public List<Turma> findByProfessorId(int id) {
		return turmaRepository.findByProfessorId(id);
	}

	public Turma findById(int id) {
		return turmaRepository.findById(id);
	}
	
}
