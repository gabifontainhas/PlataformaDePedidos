package br.com.gabifontainhas.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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

			st.executeUpdate("UPDATE galerinha.Usuario SET " + " nome = '" + novoUsuario.getNome() + "'," + " email = '"
					+ novoUsuario.getEmail() + "'," + " senha = '" + novoUsuario.getSenha() + "' " + " WHERE id = " + id
					+ ";");

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
		Usuario usuario = new Usuario();
		try {
			Statement st = banco.obterConexaoDoBancoDeDados().createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM galerinha.Usuario WHERE id = " + id + ";");

			while (rs.next()) {
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
			}
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
		return usuario;
	}

	public List<Usuario> consultarTodosOsUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		try {
			Statement st = banco.obterConexaoDoBancoDeDados().createStatement();

			ResultSet rs = st.executeQuery("SELECT * FROM galerinha.Usuario;");

			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
				usuarios.add(usuario);
			}
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
		return usuarios;
	}
}
