package com.uepb.projetoWeb.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.uepb.projetoWeb.domain.dto.UsuarioDTO;
import com.uepb.projetoWeb.models.UserAtual;
import com.uepb.projetoWeb.models.Usuario;
import com.uepb.projetoWeb.repository.UsuarioRepository;

@Service
@Component
@Transactional
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UserAtualService userAtualService;
	
	public List<UsuarioDTO> findAll(){
		return usuarioRepository.findAll().stream().map(UsuarioDTO::new).collect(Collectors.toList());
	}
	
	public Optional<Usuario> findById(int id) {
		return usuarioRepository.findById(id);
	}
	
	public Optional<Usuario> findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
	}
	
	public Usuario findByEmailSenha(String email, String senha, String tipo) {
		//metodo para validar email, mas no momento não esta validando
		Optional<Usuario> optional = findByEmail(email);
		if (optional.isPresent()) {
			Usuario usuarioBD = optional.get();
			if (usuarioBD.getEmail().equalsIgnoreCase(email) 
					&& usuarioBD.getSenha().equalsIgnoreCase(senha) 
					&& usuarioBD.getTipo().equalsIgnoreCase(tipo)) {
				return usuarioBD;
			}
			return usuarioBD;
		}
		return null;
	}
	
	public Usuario findByUser() {
		UserAtual user = userAtualService.findLastUser();
		Usuario usuarioBD = new Usuario();
		
		Optional<Usuario> u = usuarioRepository.findById(user.getId());
		if (u.isPresent()) {
			usuarioBD = u.get();
			}
		return usuarioBD;
	}
	

	public List<UsuarioDTO> findByMatricula(String matricula) {
		return usuarioRepository.findByMatricula(matricula).stream().map(UsuarioDTO::new).collect(Collectors.toList());
	}
	
	public Usuario create(Usuario professor) {
		return usuarioRepository.save(professor);
	}
	
	public Usuario update(Usuario p, int id) {
		
		Optional<Usuario> optional = findById(id);
		if (optional.isPresent()) {
			Usuario usuarioBD = optional.get();
			usuarioBD.setMatricula(p.getMatricula());
			usuarioBD.setNome(p.getNome());
			usuarioBD.setCurso(p.getCurso());
			usuarioBD.setEmail(p.getEmail());
			usuarioBD.setSenha(p.getSenha());
			
			usuarioRepository.save(usuarioBD);
			return usuarioBD;
		}
		else {
			throw new RuntimeException("Erro ao atualizar o usuario!");
		}
	}
	
	public void delete(int id) {
		Optional<Usuario> usuario = findById(id);
		if(usuario.isPresent()) {
			usuarioRepository.deleteById(id);
		}
	}

}