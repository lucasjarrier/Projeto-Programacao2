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

}