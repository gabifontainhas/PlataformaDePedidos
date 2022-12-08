package br.com.gabifontainhas.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import br.com.gabifontainhas.model.Usuario;
import br.com.gabifontainhas.util.BancoDeDadosUtil;

public class UsuarioDAO {
	
	private BancoDeDadosUtil banco = new BancoDeDadosUtil();
	
	public void salvarUsuario(Usuario usuario) {
		
		try {
			Statement st = banco.obterConexaoDoBancoDeDados().createStatement();

			st.executeUpdate("INSERT INTO galerinha.Usuario (nome, email, senha, dthr_criacao, dthr_ultimo_acesso) "
					+ "values ('" + usuario.getNome() + "','" + usuario.getEmail() + "','" + usuario.getSenha()
					+ "', now(), null)");

			banco.fecharConexao();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void atualizarUsuario(Long id, Usuario novoUsuario) {
		
		try {
			Statement st = banco.obterConexaoDoBancoDeDados().createStatement();
			
			st.executeUpdate("UPDATE galerinha.Usuario SET "
					+ " nome = '" + novoUsuario.getNome() + "',"
					+ " email = '" + novoUsuario.getEmail() + "'," 
					+ " senha = '" + novoUsuario.getSenha() + "' "
					+ " WHERE id = " + id + ";");
			
			banco.fecharConexao();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Usuario consultarUsuario(long id) {
		try {
			Statement st = banco.obterConexaoDoBancoDeDados().createStatement();
			banco.fecharConexao();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Usuario> consultarTodosOsUsuarios()  {
		try {
			Statement st = banco.obterConexaoDoBancoDeDados().createStatement();
			banco.fecharConexao();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
