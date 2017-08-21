
package usuario;

import java.util.ArrayList;
import java.util.Collections;

import bluray.BluRayFilme;
import bluray.BluRaySerie;
import bluray.BluRayShow;
import emprestimo.Emprestimo;
import emprestimo.EmprestimoNomeItemComparator;
import item.EstadoItem;
import item.Item;
import jogos.JogoDeTabuleiro;
import jogos.JogoEletronico;

public class Usuario {

	private String nome;
	private String email;
	private String telefone;
	private ArrayList<Item> itens;
	private ArrayList<Emprestimo> emprestimos;
	private double reputacao;

	public Usuario(String nome, String telefone, String email) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.itens = new ArrayList<Item>();
		this.emprestimos = new ArrayList<Emprestimo>();
		this.reputacao = 0.0;
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

	public double getReputacao() {
		return reputacao;
	}

	public void setReputacao(double reputacao) {
		this.reputacao = reputacao;
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

	public void adicionaFilme(String nome, double valor, int duracao, String classificacao, String genero, int ano) {
		BluRayFilme filme = new BluRayFilme(nome, valor, duracao, classificacao, genero, ano);
		itens.add(filme);
	}

	public void adicionaShow(String nome, double valor, int duracao, String classificacao, String artista, int faixas) {
		BluRayShow show = new BluRayShow(nome, valor, duracao, classificacao, artista, faixas);
		itens.add(show);
	}

	public void adicionaSerie(String nome, double valor, int duracao, String classificacao, String descricao,
			String genero, int temporada) {
		BluRaySerie serie = new BluRaySerie(nome, valor, duracao, classificacao, descricao, genero, temporada);
		itens.add(serie);
	}

	public void adicionaEletronico(String nome, double valor, String plataforma)  {
		JogoEletronico jogo = new JogoEletronico(nome, valor, plataforma);
		itens.add(jogo);
	}

	public void adicionaTabuleiro(String nome, double valor) {
		JogoDeTabuleiro jogo = new JogoDeTabuleiro(nome, valor);
		itens.add(jogo);
	}

	public void adicionaBluRay(String nomeBlurayTemporada, int duracao) {
		Item item = getItem(nomeBlurayTemporada);
		if (item instanceof BluRaySerie) {
			BluRaySerie serie = (BluRaySerie) item;
			serie.adicionaEpisodio(duracao);

		}

	}

	public Item getItem(String nomeItem) {
		for (Item item : this.itens) {
			if (item.getNome().equals(nomeItem)) {
				return item;
			}
		}
		throw new IllegalArgumentException("Item nao encontrado");
	}

	public void adicionaPecaPerdida(String nomeItem, String nomePeca) {
		Item item = getItem(nomeItem);
		if (item instanceof JogoDeTabuleiro) {
			JogoDeTabuleiro jogo = (JogoDeTabuleiro) item;
			jogo.adicionaPecaPerdida(nomePeca);
		}
	}

	public void removeItem(String nomeItem) {
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
	
	public void registraEmprestimo(Emprestimo emprestimo) {
		this.emprestimos.add(emprestimo);
	}
	
	public String listarEmprestimosEmprestando() {
		ArrayList<Emprestimo> emprestimosEmprestando = new ArrayList<Emprestimo>();

		for (Emprestimo emprestimo : this.emprestimos) {
			if (emprestimo.getDonoItem().getNome().equals(this.nome)
					&& emprestimo.getDonoItem().getTelefone().equals(this.telefone)) {
				emprestimosEmprestando.add(emprestimo);
			}
		}
		
		if (emprestimosEmprestando.size() == 0) {
			return "Nenhum item emprestado";
		}

		Collections.sort(emprestimosEmprestando, new EmprestimoNomeItemComparator());

		String emprestimos = "Emprestimos: ";

		for (Emprestimo emprestimo : emprestimosEmprestando) {
			emprestimos += emprestimo.toString() + "|";
		}

		return emprestimos;

	}
	
	public String listarEmprestimosPegandoEmprestado() {
		ArrayList<Emprestimo> emprestimosPegandoEmprestado = new ArrayList<Emprestimo>();

		for (Emprestimo emprestimo : this.emprestimos) {
			if (emprestimo.getUsuarioReceptor().getNome().equals(this.nome)
					&& emprestimo.getUsuarioReceptor().getTelefone().equals(this.telefone)) {
				emprestimosPegandoEmprestado.add(emprestimo);
			}
		}
		
		if (emprestimosPegandoEmprestado.size() == 0) {
			return "Nenhum item pego emprestado";
		}

		Collections.sort(emprestimosPegandoEmprestado, new EmprestimoNomeItemComparator());

		String emprestimos = "Emprestimos pegos: ";

		for (Emprestimo emprestimo : emprestimosPegandoEmprestado) {
			emprestimos += emprestimo.toString() + "|";
		}

		return emprestimos;
	}
	
	public String listaEmprestimosItem(String nomeItem) {
		String emprestimos = "";

		for (Emprestimo emprestimo : this.emprestimos) {
			if (emprestimo.getDonoItem().getNome().equals(this.nome)
					&& emprestimo.getDonoItem().getTelefone().equals(this.telefone)) {
				if (emprestimo.getItemEmprestado().getNome().equals(nomeItem)) {
					emprestimos += emprestimo.toString() + "|";
				}
			}
		}

		return emprestimos;
	}
	
	public ArrayList<Item> listarItensNaoEmprestados() {
		ArrayList<Item> itensNaoEmprestados = new ArrayList<Item>();

		for (Item item : this.itens) {
			if (item.getEstado().equals(EstadoItem.DISPONIVEL)) {
				itensNaoEmprestados.add(item);
			}
		}

		return itensNaoEmprestados;
	}
	
	public String listarItensEmprestados() {
		String listagem = "";

		for (Item item : this.itens) {
			if (item.getEstado().equals(EstadoItem.INDISPONIVEL)) {
				listagem += "Dono do item: " + this.nome + ", " + "Nome do item emprestado:" + item.getNome() + "|";
			}
		}

		return listagem;
	}
	
	

	/**
	 * Aumenta reputacao do usuario.
	 * @param reputacao
	 */
	public void aumentarReputacao (double reputacao) {
		this.reputacao += reputacao;
	}
	
	/**
	 * Diminui reputacao do usuario em caso de atraso.
	 * @param reputacao
	 */
	public void diminuirReputacao(double reputacao) {
		this.reputacao -= reputacao;
	}

}
	
	
