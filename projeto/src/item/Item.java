package item;

public abstract class Item {

	protected String nome;
	protected EstadoItem estado;
	protected double valor;

	public Item(String nome, double valor) throws Exception {
		if (nome == null || nome.trim().isEmpty()) {
			throw new Exception("Erro no cadastro do Item: Nome nao pode ser vazio ou nulo");
		}
		this.valor = valor;
		this.nome = nome;
		this.estado = EstadoItem.DISPONIVEL;
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

	public boolean getEstadoEmprestimo() {
		// FALTA IMPLEMENTAR
		return false;
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