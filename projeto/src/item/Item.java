package item;

import java.io.Serializable;

/**
 * Representação de um item, que usuário possui, a partir de um nome, valor e
 * estado (disponível ou indisponível).
 * 
 * @author Higor
 *
 */

public abstract class Item implements Serializable {

	protected String nome;
	protected EstadoItem estado;
	protected double valor;
	protected int numeroDeEmprestimos;

	/**
	 * Constrói um item a partir de um nome e um valor.
	 * 
	 * @param nome
	 *            nome do item
	 * @param valor
	 *            valor do item
	 */

	public Item(String nome, double valor) {
		this.valor = valor;
		this.nome = nome;
		this.estado = EstadoItem.DISPONIVEL;
		this.numeroDeEmprestimos = 0;
	}

	public double getValor() {
		return valor;
	}

	public String getNome() {
		return nome;
	}

	public EstadoItem getEstado() {
		return estado;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEstado(EstadoItem estado) {
		this.estado = estado;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getNumeroDeEmprestimos() {
		return numeroDeEmprestimos;
	}

	public void setNumeroDeEmprestimos(int numeroDeEmprestimos) {
		this.numeroDeEmprestimos = numeroDeEmprestimos;
	}

	/**
	 * Adiciona um ao número de emprestimos que foram realizados sobre esse item.
	 * 
	 */
	

	public void somaNumeroDeEmprestimos() {
		this.numeroDeEmprestimos++;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Item other = (Item) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}