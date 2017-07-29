package projeto;

import java.util.ArrayList;

public class Usuario {

	private String nome;
	private String email;
	private String numero;
	private ArrayList<Item> itens;

	private final String LN = System.lineSeparator();

	public Usuario(String nome, String email, String numero) {

		if (nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro no cadastro de usuario: Nome nao pode ser vazio ou nulo");
		}
		if (email == null || email.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro no cadastro de usuario: Email nao pode ser vazio ou nulo");
		}
		if (numero == null || numero.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro no cadastro de usuario: Numero nao pode ser vazio ou nulo");
		}

		this.nome = nome;
		this.email = email;
		this.numero = numero;
		this.itens = new ArrayList<Item>();
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

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public ArrayList<Item> getItens() {
		return itens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	public void adicionaItem(String nome) {
		Item item = new Item(nome);
		itens.add(item);

	}

	public String exibirItens() {
		String representacao = "";

		for (Item item : this.itens) {
			representacao += item.toString() + LN;
		}

		return representacao;
	}

}
