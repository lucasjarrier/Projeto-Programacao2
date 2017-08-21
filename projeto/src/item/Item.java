package item;

public abstract class Item {
	
	protected String nome;
	protected EstadoItem estado;
	protected double valor;
	
	public Item(String nome, double valor) {
		if (nome == null || nome.trim().isEmpty()) {
			throw new IllegalArgumentException("Erro no cadastro do Item: Nome nao pode ser vazio ou nulo");
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
	
	

}