package projeto;

import java.util.ArrayList;

public class Sistema {
	
	private final String LN = System.lineSeparator();
	private ArrayList<Usuario> usuarios;

	public Sistema() {
		this.usuarios = new ArrayList<Usuario>();
	}
	
	public void cadastraUsuario(String nome,String email,String numero) throws Exception {
		if (nome == null || nome.trim().isEmpty()) {
			throw new Exception("Erro no cadastro de usuario: Nome nao pode ser vazio ou nulo");
		}
		if (email == null || email.trim().isEmpty()) {
			throw new Exception("Erro no cadastro de usuario: Nome nao pode ser vazio ou nulo");
		}
		if (numero == null || numero.trim().isEmpty()) {
			throw new Exception("Erro no cadastro de usuario: Nome nao pode ser vazio ou nulo");
		}
		Usuario novoUsuario = new Usuario(nome,email,numero);
		this.usuarios.add(novoUsuario);		
	}	
	
	public String exibeUsuario(int posicao) throws Exception{
		
		if (posicao <= 0) {
			throw new Exception("Erro ao atualizar usuario: Posição invalida");
		}
		if (posicao > usuarios.size()) {
			throw new Exception("Erro ao atualizar usuario: Usuario não cadastrado");
		}

		return usuarios.get(posicao).toString();
	}
	
	public void atualizaUsuario(int posicao,String nome, String email, String numero) throws Exception {
		if (posicao <= 0) {
			throw new Exception("Erro ao atualizar usuario: Posição invalida");
		}
		if (posicao > usuarios.size()) {
			throw new Exception("Erro ao atualizar usuario: Usuario não cadastrado");
		}	
		Usuario atualizaUsuario = new Usuario(nome,email,numero);
		this.usuarios.remove(posicao);
		this.usuarios.add(atualizaUsuario);	
	}
	public void deletaUsuario(int posicao) throws Exception {
		
		if (posicao <= 0) {
			throw new Exception("Erro ao atualizar usuario: Posição invalida");
		}
		if (posicao > usuarios.size()) {
			throw new Exception("Erro ao atualizar usuario: Usuario não cadastrado");
		}
		this.usuarios.remove(posicao);
	}

	public void cadastraItens(String nome) {
		// Falta Implementar!!!
		
	}
}


	
	
	
	
