
package projeto;

import java.util.ArrayList;

public class Usuario {

	private String nome;
	private String email;
	private String telefone;
	private ArrayList<Item> itens;

	private final String LN = System.lineSeparator();

	public Usuario(String nome, String email, String telefone) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.itens = new ArrayList<Item>();
	}

	@Override
	public String toString() {
		return this.nome + ", " + this.email + ", " + this.telefone;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTelefone(String numero) {
		this.telefone = numero;
	}

	public ArrayList<Item> getItens() {
		return itens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	public void adicionaItem(String nome) {
		/*
		 * Item item = new Item(nome); N�o pode Instanciar uma classe abstrata.
		 * itens.add(item);
		 */

	}

	public String exibirItens() {
		String representacao = "";

		for (Item item : this.itens) {
			representacao += item.toString() + LN;
		}

		return representacao;
	}

	public String pequisaDetalhesItens(String nomeItem) {
		String retorno = "";
		boolean existeItem = false;

		for (Item item : this.itens) {
			if (item.getNome().equals(nomeItem)) {
				existeItem = true;
			}
			if (existeItem) {
				retorno += item.toString();
				break;
				// FALTA LANÇAR EXCEÇÕES
			}
		}
		return retorno;
	}
}