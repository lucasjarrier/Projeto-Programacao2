package bluray;

import java.util.ArrayList;
import java.util.List;

public class BluRaySerie extends BluRay {
	
	private String descricao;
	private String genero;
	private int temporada;
	private List<Episodio> episodios;
	
	public BluRaySerie(String nome, double valor, int duracao, String classificacao, String descricao,
			String genero, int temporada) throws Exception {
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
		return "SERIE: " + this.nome + ", R$ " + this.valor + ", " + this.estado.getSituacao() + ", " +
			this.getDuracao() + " min, " +  this.genero + ", " +  this.getClassificacao() + ", Temporada " + this.temporada;
	}
	
	public void adicionaEpisodio(int duracao) {
		Episodio episodio = new Episodio(duracao);
		this.episodios.add(episodio);
	}
	

	
}