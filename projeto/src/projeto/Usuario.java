package projeto;

import java.util.ArrayList;

public class Usuario {
	
	private String nome;
	private String email;
	private String numero;
	private ArrayList<Itens> itens;

	
	public Usuario(String nome, String email, String numero) throws Exception {
		
		if (nome == null || nome.trim().isEmpty()) {
			throw new Exception("Erro no cadastro de usuario: Nome nao pode ser vazio ou nulo");
		}
		if (email == null || email.trim().isEmpty()) {
			throw new Exception("Erro no cadastro de usuario: Nome nao pode ser vazio ou nulo");
		}
		if (numero == null || numero.trim().isEmpty()) {
			throw new Exception("Erro no cadastro de usuario: Nome nao pode ser vazio ou nulo");
		}

		this.nome = nome;
		this.email = email;
		this.numero = numero;
		this.itens = new ArrayList<Itens>();
	}

	@Override
	public String toString() {
		return this.nome + ", " + this.email + ", " + this.numero;
	}	

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}


	public String getNumero() {
		return numero;
	}


	public ArrayList<Itens> getItens() {
		return itens;
	}
		
}
