package br.com.gabifontainhas.view;

import java.util.List;
import java.util.Scanner;

import br.com.gabifontainhas.controller.UsuarioController;
import br.com.gabifontainhas.model.Usuario;

public class UsuarioView {
	public void cadastrarUsuario() {
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

	public void alterarUsuario() {
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

	public void consultarUsuarioPorId() {
		UsuarioController usuarioController = new UsuarioController();
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Digite o ID do usuário: ");
			Long id = Long.valueOf(scanner.next());
			Usuario usuario = usuarioController.consultarUsuario(id);
			System.out.println("O nome do usuário é:" + usuario.getNome());
			System.out.println("O e-mail do usuário é:" + usuario.getEmail());
			System.out.println("A senha do usuário é:" + usuario.getSenha());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void consultarTodosOsUsuario() {
		UsuarioController usuarioController = new UsuarioController();
		List<Usuario> usuarios = usuarioController.consultarTodosOsUsuarios();
		for (Usuario usuario : usuarios) {
			System.out.println("----");
			System.out.println("O nome do usuário é:" + usuario.getNome());
			System.out.println("O e-mail do usuário é:" + usuario.getEmail());
			System.out.println("A senha do usuário é:" + usuario.getSenha());
		}
	}

}
