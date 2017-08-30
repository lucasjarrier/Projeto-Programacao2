
package usuario;

import java.util.ArrayList;
import cartoes.CardBomAmigo;
import cartoes.CardCaloteiro;
import cartoes.CardFreeRyder;
import cartoes.CardNoob;
import cartoes.CardReputacao;
import item.BluRayFilme;
import item.BluRaySerie;
import item.BluRayShow;
import item.EstadoItem;
import item.Item;
import item.JogoDeTabuleiro;
import item.JogoEletronico;

public class Usuario {

	private String nome;
	private String email;
	private String telefone;
	private ArrayList<Item> itens;
	private double reputacao;
	private CardReputacao cartaoReputacao;

	public Usuario(String nome, String telefone, String email) {
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.itens = new ArrayList<Item>();

		this.reputacao = 0.0;
		this.cartaoReputacao = new CardFreeRyder();
	}

	public CardReputacao getCartaoReputacao() {
		return cartaoReputacao;
	}

	/**
	 * Muda o tipo de cartao de acordo com a reputacao do usuario.
	 * 
	 */

	public void setCartaoReputacao() {
		if (reputacao < 0) {
			this.cartaoReputacao = new CardCaloteiro();
		}
		if (reputacao >= 0 && reputacao <= 100) {
			if (itens.size() > 0) {
				this.cartaoReputacao = new CardNoob();
			} else {
				this.cartaoReputacao = new CardFreeRyder();
			}
		}
		if (reputacao > 100) {
			this.cartaoReputacao = new CardBomAmigo();
		}
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

	/**
	 * Adiciona um bluray de filme ao usuario.
	 * 
	 * @param nome
	 *            Eh o nome do filme.
	 * @param valor
	 *            Eh o valor do item.
	 * @param duracao
	 *            Eh a duracao do filme.
	 * @param classificacao
	 *            Eh a classificacao do filme.
	 * @param genero
	 *            Eh o genero do filme
	 * @param ano
	 *            Eh o ano de lancamento do filme.
	 */

	public void adicionaFilme(String nome, double valor, int duracao, String classificacao, String genero, int ano) {
		BluRayFilme filme = new BluRayFilme(nome, valor, duracao, classificacao, genero, ano);
		itens.add(filme);
		aumentarReputacao(valor * 0.05);
	}

	/**
	 * Adiciona um bluray de show ao usuario.
	 * 
	 * @param nome
	 *            Eh o nome do show.
	 * @param valor
	 *            Eh o valor do item.
	 * @param duracao
	 *            Eh a duracao do show.
	 * @param classificacao
	 *            Eh a classificacao do show.
	 * @param artista
	 *            Eh o artista.
	 * @param faixas
	 *            Eh a quantidade de faixas do bluray.
	 */

	public void adicionaShow(String nome, double valor, int duracao, String classificacao, String artista, int faixas) {
		BluRayShow show = new BluRayShow(nome, valor, duracao, classificacao, artista, faixas);
		itens.add(show);
		aumentarReputacao(valor * 0.05);
	}

	/**
	 * Adiciona um bluray de serie ao usuario.
	 * 
	 * @param nome
	 *            Eh o nome da serie.
	 * @param valor
	 *            Eh o valor do item.
	 * @param duracao
	 *            Eh a duracao do bluray.
	 * @param classificacao
	 *            Eh a classificacao etaria do bluray.
	 * @param descricao
	 *            Eh a descricao do item.
	 * @param genero
	 *            Eh o genero da serie.
	 * @param temporada
	 *            Eh a temporada da serie.
	 */

	public void adicionaSerie(String nome, double valor, int duracao, String classificacao, String descricao,
			String genero, int temporada) {
		BluRaySerie serie = new BluRaySerie(nome, valor, duracao, classificacao, descricao, genero, temporada);
		itens.add(serie);
		aumentarReputacao(valor * 0.05);
	}

	/**
	 * Adiciona um jogo eletronico ao usuario.
	 * 
	 * @param nome
	 *            Eh o nome do jogo.
	 * @param valor
	 *            Eh o valor do jogo.
	 * @param plataforma
	 *            Eh a plataforma do jogo.
	 */

	public void adicionaEletronico(String nome, double valor, String plataforma) {
		JogoEletronico jogo = new JogoEletronico(nome, valor, plataforma);
		itens.add(jogo);
		aumentarReputacao(valor * 0.05);
	}

	/**
	 * Adiciona um jogo de tabuleiro ao usuario.
	 * 
	 * @param nome
	 *            Eh o nome do jogo.
	 * @param valor
	 *            Eh o valor do jogo.
	 */

	public void adicionaTabuleiro(String nome, double valor) {
		JogoDeTabuleiro jogo = new JogoDeTabuleiro(nome, valor);
		itens.add(jogo);
		aumentarReputacao(valor * 0.05);
	}

	/**
	 * Adiciona um episodio a serie.
	 * 
	 * @param nomeBlurayTemporada
	 *            Eh o nome do bluray da serie.
	 * @param duracao
	 *            Eh a duracao do episodio.
	 */

	public void adicionaBluRay(String nomeBlurayTemporada, int duracao) {
		Item item = getItem(nomeBlurayTemporada);
		if (item instanceof BluRaySerie) {
			BluRaySerie serie = (BluRaySerie) item;
			serie.adicionaEpisodio(duracao);
		}

	}

	/**
	 * Retorna um item.
	 * 
	 * @param nomeItem
	 *            Eh o nome do item.
	 * @return Retorna o item.
	 */

	public Item getItem(String nomeItem) {
		for (Item item : this.itens) {
			if (item.getNome().equals(nomeItem)) {
				return item;
			}
		}
		throw new NullPointerException("Item nao encontrado");
	}

	/**
	 * Adiciona uma peca perdida ao jogo de tabuleiro.
	 * 
	 * @param nomeItem
	 *            Eh o nome do jogo.
	 * @param nomePeca
	 *            Eh o nome da peca.
	 */

	public void adicionaPecaPerdida(String nomeItem, String nomePeca) {
		Item item = getItem(nomeItem);
		if (item instanceof JogoDeTabuleiro) {
			JogoDeTabuleiro jogo = (JogoDeTabuleiro) item;
			jogo.adicionaPecaPerdida(nomePeca);
		}
	}

	/**
	 * Retorna a informacao sobre o usuario.
	 * 
	 * @param atributo
	 *            Eh o atributo o qual se quer a informacao.
	 * @return Retorna a informacao.
	 */

	public String getInfoUsuario(String atributo) {
		String info = "";
		if (atributo.toLowerCase().equals("nome")) {
			info += getNome();
		} else if (atributo.toLowerCase().equals("telefone")) {
			info += getTelefone();
		} else if (atributo.toLowerCase().equals("email")) {
			info += getEmail();
		} else if (atributo.toLowerCase().equals("reputacao")) {
			info += getReputacao();
		} else if (atributo.toLowerCase().equals("cartao")) {
			info += getCartaoReputacao().toString();
		}
		return info;
	}

	/**
	 * Retorna informacoes do item.
	 * 
	 * @param nomeItem
	 *            Eh o nome do item.
	 * @param atributo
	 *            Eh o nome do atributo o qual se quer a informacao.
	 * @return Retorna a informacao.
	 */

	public String getInfoItem(String nomeItem, String atributo) {
		String info = "";
		if (atributo.toLowerCase().equals("preco")) {
			info += getItem(nomeItem).getValor();
		} else if (atributo.toLowerCase().equals("nome")) {
			info += getItem(nomeItem).getNome();
		}
		return info;
	}

	/**
	 * Atualiza informacoes do item do usuario.
	 * 
	 * @param nomeItem
	 *            Eh o nome do item.
	 * @param atributo
	 *            Eh o nome do atributo o qual se quer a informacao.
	 * @param valor
	 *            Eh o valor a ser mudado.
	 */

	public void atualizarItem(String nomeItem, String atributo, String valor) {
		Item item = getItem(nomeItem);
		if (atributo.toLowerCase().equals("preco")) {
			item.setValor(Double.parseDouble(valor));
		}
		if (atributo.toLowerCase().equals("nome")) {
			item.setNome(valor);
		}
	}

	/**
	 * 
	 * Remove um item do usuario.
	 * 
	 * @param nomeItem
	 *            Eh o nome do item.
	 */

	public void removeItem(String nomeItem) {
		Item item = getItem(nomeItem);
		itens.remove(item);
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

	public ArrayList<Item> getItensComEmprestimos() {
		ArrayList<Item> itensComEmprestimos = new ArrayList<Item>();
		for (Item item : this.itens) {
			if (item.getNumeroDeEmprestimos() > 0) {
				itensComEmprestimos.add(item);
			}
		}
		return itensComEmprestimos;
	}

	/**
	 * Aumenta reputacao do usuario.
	 * 
	 * @param reputacao
	 */
	public void aumentarReputacao(double reputacao) {
		this.reputacao += reputacao;
		setCartaoReputacao();
	}

	/**
	 * Diminui reputacao do usuario em caso de atraso.
	 * 
	 * @param reputacao
	 */
	public void diminuirReputacao(double reputacao) {
		this.reputacao -= reputacao;
		setCartaoReputacao();
	}

}