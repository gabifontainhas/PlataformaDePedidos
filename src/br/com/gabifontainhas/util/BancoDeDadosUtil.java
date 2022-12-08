package br.com.gabifontainhas.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BancoDeDadosUtil {

	private Connection conexao;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection obterConexaoDoBancoDeDados() throws SQLException, FileNotFoundException, IOException {

		Properties propriedadesDB = new Properties();
		propriedadesDB.load(new FileInputStream("resources/aplication.properties"));

		String url = propriedadesDB.getProperty("datasource.url");
		String username = propriedadesDB.getProperty("datasource.username");
		String password = propriedadesDB.getProperty("datasource.password");

		conexao = DriverManager.getConnection(url, username, password);

		return conexao;
	}

	public void fecharConexao() throws SQLException {
		this.conexao.close();
	}
}
