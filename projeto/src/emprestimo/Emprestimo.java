package emprestimo;

import Usuario.Usuario;
import item.Item;

public class Emprestimo {
	
	private Usuario dono;
	private Usuario emprestimo;
	private Item item;
	private int diasDoEmprestimo;
	private int diasDeAtraso;
	private String dataEntrega;
	private String dataDevolucao;
	
	
	public Emprestimo(Usuario dono, Usuario emprestimo, Item item, int didasDoEmprestimo, String dataEtrega) {
		
		this.dono = dono;
		this.emprestimo = emprestimo;
		this.item = item;
		
		//this.item.setEstado(Estado item); #FALTA TERMINAR
		
		this.dataEntrega = dataEntrega;
		this.dataDevolucao = dataDevolucao;
	
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dono == null) ? 0 : dono.hashCode());
		result = prime * result + ((emprestimo == null) ? 0 : emprestimo.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
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
		Emprestimo other = (Emprestimo) obj;
		if (dono == null) {
			if (other.dono != null)
				return false;
		} else if (!dono.equals(other.dono))
			return false;
		if (emprestimo == null) {
			if (other.emprestimo != null)
				return false;
		} else if (!emprestimo.equals(other.emprestimo))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		return true;
	}
	
	public Item getItem(){
		return this.item;
	}
	
	public boolean getEstadoItem(){
		return item.getEstadoEmprestimo(); // # FALTA TERMINAR
	}
	
	public void devolverItem() {
		
	}

	public int getDiasDoEmprestimo() {
		return diasDoEmprestimo;
	}

	public Usuario getDono() {
		return dono;
	}

	public Usuario getEmprestimo() {
		return emprestimo;
	}
}
