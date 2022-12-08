package br.com.gabifontainhas.controller;

import java.util.List;

import br.com.gabifontainhas.dao.UsuarioDAO;
import br.com.gabifontainhas.model.Usuario;
import br.com.gabifontainhas.util.ValidacaoUtil;
	
public class UsuarioController {
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	public void salvarUsuario(Usuario usuario) {
		ValidacaoUtil validacao = new ValidacaoUtil();
		
		validacao.validarEmail(usuario.getEmail());
		validacao.validarApenasTexto(usuario.getNome());
		
		usuarioDAO.salvarUsuario(usuario);
	}
	
	public void atualizarUsuario(Long id, Usuario novoUsuario) {
		ValidacaoUtil validacao = new ValidacaoUtil();
		
		validacao.validarEmail(novoUsuario.getEmail());
		validacao.validarApenasTexto(novoUsuario.getNome());
		
		usuarioDAO.atualizarUsuario(id, novoUsuario);
	}
	
	public Usuario consultarUsuario(long id) {
		return usuarioDAO.consultarUsuario(id);
	}
	
	public List<Usuario> consultarTodosOsUsuarios() {
		return usuarioDAO.consultarTodosOsUsuarios();
	}
}
