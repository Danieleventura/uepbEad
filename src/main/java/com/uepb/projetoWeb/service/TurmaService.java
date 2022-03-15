package com.uepb.projetoWeb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uepb.projetoWeb.domain.dto.AlunoTurmasDTO;
import com.uepb.projetoWeb.domain.dto.TurmaDTO;
import com.uepb.projetoWeb.models.AlunoTurmas;
import com.uepb.projetoWeb.models.Turma;
import com.uepb.projetoWeb.models.TurmaAtual;
import com.uepb.projetoWeb.repository.TurmaRepository;

@Service
@Component
@Transactional
public class TurmaService {

	@Autowired
	private TurmaRepository turmaRepository;
	@Autowired
	private TurmaAtualService turmaAtualService;
	@Autowired
	private AlunoTurmasService alunoTurmasService;
	
	public Turma create(Turma turma) {
		return turmaRepository.save(turma);
	}

	public List<TurmaDTO> findAll(){
		return turmaRepository.findAll().stream().map(TurmaDTO::new).collect(Collectors.toList());
	}
	
	public List<Turma> findByIdProfessor(int id) {
		return turmaRepository.findByIdProfessor(id);
	}
	
	public List<Turma> findByIdAluno(int id) {
		return turmaRepository.findByIdProfessor(id);
	}
	
	public Turma findByCodigo(String codigo) {
		return turmaRepository.findByCodigo(codigo);
	}

	public Turma findById(int id) {
		return turmaRepository.findById(id);
	}
	
	public List<Turma> findCodigoTurma(int id) {
		List<AlunoTurmasDTO> alunoTurmas = alunoTurmasService.findAll();
		List<String> codigoTurma = new ArrayList<String>();
		Turma t = new Turma();
		List<Turma> turmas = new ArrayList<Turma>();
		for(int i =0; i<alunoTurmas.size(); i++) {
			if (id == alunoTurmas.get(i).getIdAluno()) {
				t = findByCodigo(alunoTurmas.get(i).getCodigoTurma());
				if (t != null) {
					turmas.add(t);
				}
			}
		}
		return turmas;
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
