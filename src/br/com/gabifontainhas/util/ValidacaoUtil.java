package br.com.gabifontainhas.util;

public class ValidacaoUtil {

	public void validarEmail(String email) {
		if (!email.contains("@") || !email.contains("."))			
			throw new RuntimeException("E-mail do usuário inválido");
	}

	public void validarApenasTexto(String nome) {
		if (!nome.matches("^(?=.*?[A-Za-z])[A-Za-z+]+$"))
			throw new RuntimeException("Nome do usuário inválido");		
	}
}
