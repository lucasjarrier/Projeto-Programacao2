
package projeto;

import java.util.ArrayList;

import bluray.BluRayFilme;
import bluray.BluRaySerie;
import bluray.BluRayShow;
import item.Item;
import jogos.JogoDeTabuleiro;
import jogos.JogoEletronico;

public class Usuario {

	private String nome;
	private String email;
	private String telefone;
	private ArrayList<Item> itens;

	public Usuario(String nome, String telefone, String email) {
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

	public void adicionaFilme(String nome, double valor, int duracao, String classificacao, String genero, int ano) throws Exception {
		BluRayFilme filme = new BluRayFilme(nome, valor, duracao, classificacao, genero, ano);
		itens.add(filme);
	}
	
	public void adicionaShow(String nome, double valor, int duracao, String classificacao, String artista, int faixas) throws Exception {
		BluRayShow show = new BluRayShow(nome, valor, duracao, classificacao, artista, faixas);
		itens.add(show);
	}

	public void adicionaSerie(String nome, double valor, int duracao, String classificacao, String descricao,
			String genero, int temporada) throws Exception {
		BluRaySerie serie = new BluRaySerie(nome, valor, duracao, classificacao, descricao, genero, temporada);
		itens.add(serie);
	}
	
	public void adicionaEletronico(String nome, double valor, String plataforma) throws Exception {
		JogoEletronico jogo = new JogoEletronico(nome, valor, plataforma);
		itens.add(jogo);
	}
	
	public void adicionaTabuleiro(String nome, double valor) throws Exception {
		JogoDeTabuleiro jogo = new JogoDeTabuleiro(nome, valor);
		itens.add(jogo);
	}
	
	public Item getItem(String nomeItem) throws Exception {
		for (Item item : itens) {
			if (item.getNome().equals(nomeItem)) {
				return item;
			}
		}
		throw new IllegalArgumentException("Item nao encontrado");
	}
	
	public void adicionaPecaPerdida(String nomeItem, String nomePeca) throws Exception {
		Item item = getItem(nomeItem);
		if (item instanceof JogoDeTabuleiro) {
			JogoDeTabuleiro jogo = (JogoDeTabuleiro) item;
			jogo.adicionaPecaPerdida(nomePeca);
		}
	}
	
	public void removeItem(String nomeItem) throws Exception {
		Item item = getItem(nomeItem);
		itens.remove(item);
	}
	
	public String exibirItens() {
		String representacao = "";

		for (Item item : this.itens) {
			representacao += item.toString();
		}

		return representacao;
	}

}