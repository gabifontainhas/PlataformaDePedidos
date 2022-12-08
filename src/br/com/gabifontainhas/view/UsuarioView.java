package br.com.gabifontainhas.view;

import java.util.Scanner;

import br.com.gabifontainhas.controller.UsuarioController;
import br.com.gabifontainhas.model.Usuario;

public class UsuarioView {
	public void cadastrarUsuario () {
		Usuario usuario = new Usuario();
		UsuarioController usuarioController = new UsuarioController();
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Informe seu nome: ");
			usuario.setNome(String.valueOf(scanner.next()));
			System.out.print("Informe seu e-mail: ");
			usuario.setEmail(String.valueOf(scanner.next()));
			System.out.print("Informe sua senha: ");
			usuario.setSenha(String.valueOf(scanner.next()));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		usuarioController.salvarUsuario(usuario);
		System.out.println("Usuário registrado com sucesso");
	}
	
	public void alterarUsuario () {
		Usuario usuario = new Usuario();
		UsuarioController usuarioController = new UsuarioController();
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Informe o id do usuário que será modificado: ");
			Long id = Long.valueOf(scanner.next());
			System.out.print("Informe o novo nome: ");
			usuario.setNome(String.valueOf(scanner.next()));
			System.out.print("Informe o novo e-mail: ");
			usuario.setEmail(String.valueOf(scanner.next()));
			System.out.print("Informe a nova senha: ");
			usuario.setSenha(String.valueOf(scanner.next()));
			usuarioController.atualizarUsuario(id, usuario);
			System.out.println("Usuário atualizado com sucesso");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
}
