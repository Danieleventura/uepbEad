package com.uepb.projetoWeb.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uepb.projetoWeb.models.AlunoTurmas;
import com.uepb.projetoWeb.models.Turma;
import com.uepb.projetoWeb.models.TurmaAtual;
import com.uepb.projetoWeb.models.Usuario;
import com.uepb.projetoWeb.service.AlunoTurmasService;
import com.uepb.projetoWeb.service.TurmaAtualService;
import com.uepb.projetoWeb.service.TurmaService;
import com.uepb.projetoWeb.service.UsuarioService;

@Controller
@Transactional
public class TurmaController {
	
	@Autowired
	private TurmaService turmaService;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private TurmaAtualService turmaAtualService;
	@Autowired
	private AlunoTurmasService alunoTurmasService;
	
	@RequestMapping(value = "/cadastro/turma", method = RequestMethod.GET)
	public String cadastro() {
		return "turma/formTurma";
	}
	
	@RequestMapping(value = "/cadastro/turma", method = RequestMethod.POST)
	public String cadastro(Turma turma) {
		Usuario professor = usuarioService.findByUser(); // pegando o usuario logado
		turma.setIdProfessor(professor.getId());
		turma.setCodigo(getRandomString());
		Turma a = turmaService.create(turma);
		return "redirect:/turmas";
	}
	
	@RequestMapping(value = "/entrar/turma", method = RequestMethod.GET)
	public String entrarTurma() {
		return "turmaAluno/formTurma";
	}
	
	@RequestMapping(value = "/entrar/turma", method = RequestMethod.POST)
	public String entrarTurma(String codigoTurma) {
		Usuario aluno = usuarioService.findByUser(); // pegando o usuario logado
		AlunoTurmas a = new AlunoTurmas();
		a.setCodigoTurma(codigoTurma);
		a.setIdAluno(aluno.getId());
		alunoTurmasService.create(a);
		return "redirect:/turmas/aluno";
	}
	
	@RequestMapping(value = "/turmas", method = RequestMethod.GET)
	public ModelAndView turmas() {
		
		ModelAndView mv = new ModelAndView("turma/turma");
		Usuario professor = usuarioService.findByUser();
		Iterable<Turma> turmas = turmaService.findByIdProfessor(professor.getId());
		mv.addObject("turmas", turmas);
		
		return mv;
	}
	
	@RequestMapping(value = "/turmas/aluno", method = RequestMethod.GET)
	public ModelAndView turmasAluno() {
		
		ModelAndView mv = new ModelAndView("turmaAluno/turma");
		Usuario aluno = usuarioService.findByUser();
		Iterable<Turma> turmas = turmaService.findCodigoTurma(aluno.getId());
		mv.addObject("turmas", turmas);
		
		return mv;
	}
	
	@RequestMapping(value = "/turma/{id}")
	public ModelAndView detalhesTurmas(@PathVariable("id") int id) {
		Turma turma = turmaService.findById(id);
		TurmaAtual turmaAtual = new TurmaAtual();
		turmaAtual.setId(turma.getId());
		TurmaAtual user = turmaAtualService.create(turmaAtual);
		ModelAndView mv = new ModelAndView("turma/detalheTurma");
		mv.addObject("turma", turma);
		
		return mv;
	}
	
	@RequestMapping(value = "aluno/turma/{id}")
	public ModelAndView detalhesTurmasAluno(@PathVariable("id") int id) {
		Turma turma = turmaService.findById(id);
		TurmaAtual turmaAtual = new TurmaAtual();
		turmaAtual.setId(turma.getId());
		TurmaAtual user = turmaAtualService.create(turmaAtual);
		ModelAndView mv = new ModelAndView("turmaAluno/detalheTurma");
		mv.addObject("turma", turma);
		
		return mv;
	}
	
	@RequestMapping(value = "/aluno/turma")
	public ModelAndView detalheTurmasAluno() {
		Turma turma = turmaService.findByUser();
		TurmaAtual turmaAtual = new TurmaAtual();
		turmaAtual.setId(turma.getId());
		TurmaAtual user = turmaAtualService.create(turmaAtual);
		ModelAndView mv = new ModelAndView("turmaAluno/detalheTurma");
		mv.addObject("turma", turma);
		
		return mv;
	}
	
	@RequestMapping(value = "/turma")
	public ModelAndView detalheTurmas() {
		Turma turma = turmaService.findByUser();
		TurmaAtual turmaAtual = new TurmaAtual();
		turmaAtual.setId(turma.getId());
		TurmaAtual user = turmaAtualService.create(turmaAtual);
		ModelAndView mv = new ModelAndView("turma/detalheTurma");
		mv.addObject("turma", turma);
		
		return mv;
	}
	
	@RequestMapping(value = "/turma/apagar")
	public String deletarTurma() {
		Turma turma = turmaService.findByUser();
		turmaService.delete(turma.getId());
		
		return "redirect:/turmas";
	}
	
	@RequestMapping(value = "/turma/editar/", method = RequestMethod.POST)
	public String editarTurma(Turma turma) {
		Turma c = turmaService.findByUser();
		turma.setIdProfessor(c.getIdProfessor());
		turma.setId(c.getId());
		turma.setCodigo(c.getCodigo());
		turmaService.update(turma, c.getId());
		return "redirect:/turmas";
	}
	
	@RequestMapping(value = "/turma/editar", method = RequestMethod.GET)
	public ModelAndView editarTurma() {
		Turma turma = turmaService.findByUser();
		ModelAndView mv = new ModelAndView("turma/formEditarTurma");
		mv.addObject("turma", turma);
		
		return mv;
	}
	
	static String getRandomString(){ //metodo para gerar codigo da turma
        String theAlphaNumericS;
        StringBuilder builder;
        int i = 10;
        
        theAlphaNumericS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"; 

        //create the StringBuffer
        builder = new StringBuilder(i); 

        for (int m = 0; m < i; m++) { 

            // generate numeric
            int myindex 
                = (int)(theAlphaNumericS.length() 
                        * Math.random()); 

            // add the characters
            builder.append(theAlphaNumericS 
                        .charAt(myindex)); 
        } 

        return builder.toString(); 
    }
}
