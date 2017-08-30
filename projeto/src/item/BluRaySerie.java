package item;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa��o de uma classe BlueRaySerie que � representada por um nome,
 * valor, duracao, e a classifica��o indicativa, descri��o, genero e temporada.
 * 
 * @author Higor
 *
 */

public class BluRaySerie extends BluRay {

	private String descricao;
	private String genero;
	private int temporada;
	private List<Episodio> episodios;

	/**
	 * Constr�i um BluRaySerie a partir de um nome, valor, duracao, classificacao
	 * indicativa genero do filme, descri��o, genero e temporada.
	 * 
	 * @param nome
	 *            nome do bluray
	 * @param valor
	 *            valor do bluray
	 * @param duracao
	 *            duracao da serie
	 * @param classificacao
	 *            classifica��o indicativa da s�rie
	 * @param descricao
	 *            descri��o da s�rie
	 * @param genero
	 *            g�nero da s�rie
	 * @param temporada
	 *            temporada em que se encontra
	 */

	public BluRaySerie(String nome, double valor, int duracao, String classificacao, String descricao, String genero,
			int temporada) {
		super(nome, valor, duracao, classificacao);
		this.descricao = descricao;
		this.genero = genero;
		this.temporada = temporada;
		this.episodios = new ArrayList<>();
	}

	public String getDescricao() {
		return descricao;
	}

	public String getGenero() {
		return genero;
	}

	public int getTemporada() {
		return temporada;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + temporada;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		BluRaySerie other = (BluRaySerie) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (temporada != other.temporada)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SERIE: " + this.nome + ", R$ " + this.valor + ", " + this.estado.getSituacao() + ", "
				+ this.getDuracao() + " min, " + this.genero + ", " + this.getClassificacao() + ", Temporada "
				+ this.temporada;
	}

	/**
	 * Adiciona um episodio a cole��o de epis�dios.
	 * 
	 * @param duracao
	 *            dura��o do epis�dio a ser adicionado
	 */

	public void adicionaEpisodio(int duracao) {
		Episodio episodio = new Episodio(duracao);
		this.episodios.add(episodio);
	}

}