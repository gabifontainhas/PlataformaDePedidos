package br.com.gabifontainhas;

import java.util.Scanner;

import br.com.gabifontainhas.view.UsuarioView;

public class Aplicacao {
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		UsuarioView usuarioView = new UsuarioView();
		int opcao = 0;
		System.out.print("Digite: \n"
				+ "1 para cadastrar novo usuário \n"
				+ "2 para atualizar usuário existente \n"
				+ "3 para consultar um usuário por id \n" 
				+ "4 para consultar todos os usuários \n"
				);
		opcao = Integer.valueOf(scanner.next());
		switch (opcao) {
		case 1:
			usuarioView.cadastrarUsuario();
			break;
		case 2:
			usuarioView.alterarUsuario();
			break;
		case 3:			
			usuarioView.consultarUsuarioPorId();					
			break;	
		case 4:			
			usuarioView.consultarTodosOsUsuario();					
			break;	
		case 9:
			System.out.println("Saindo...");
			break;
		default:
			System.out.println("Opção inválida.");
			break;
		}
	}
}
