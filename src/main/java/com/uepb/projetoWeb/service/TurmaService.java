package com.uepb.projetoWeb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uepb.projetoWeb.models.Turma;
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
	
}
