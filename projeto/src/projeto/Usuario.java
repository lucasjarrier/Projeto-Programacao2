package projeto;

import java.util.ArrayList;

public class Usuario {
	
	private String nome;
	private String email;
	private String numero;
	private ArrayList<Itens> itens;

	
	public Usuario(String nome, String email, String numero) {

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
