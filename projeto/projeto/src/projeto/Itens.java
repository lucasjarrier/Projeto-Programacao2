package projeto;

public class Itens {
	
	private String nome;
	private EstadoItem estado;

	public Itens(String nome) throws Exception {
		
		if (nome == null || nome.trim().isEmpty()) {
			throw new Exception("Erro no cadastro do Item: Nome nao pode ser vazio ou nulo");
		}
		
		this.nome = nome;
		this.estado = EstadoItem.DISPONIVEL;
	}

	public EstadoItem getEstado() {
		return estado;
	}

	public String getNome() {
		return nome;
	}

	public void setEstado(EstadoItem estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Nome: " + this.nome + " Estado: " + this.estado;
	}
	
}
