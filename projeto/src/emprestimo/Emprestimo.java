package emprestimo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import item.EstadoItem;
import item.Item;
import usuario.Usuario;

/**
 * Representa��o de um empr�stimo no sistema do Tracking Things. Um empr�stimo �
 * concretizado quando um usu�rio cadastrado , que possui um item e esse item
 * est� dispon�vel, empresta esse item a outro usu�rio cadastrado, estipulando
 * um intervalo de tempo para devolu��o desse item.
 * 
 * @author Higor
 *
 */

public class Emprestimo {
	// Atributos
	private Usuario donoItem;
	private Usuario usuarioReceptor;
	private Item itemEmprestado;
	private int diasDoEmprestimo;
	private int diasDeAtraso;
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;

	/**
	 * Constr�i um Emprestimo a partir de um usu�rio que possui um item, um usu�rio
	 * que quer esse item emprestado, um item a ser emprestado, os dias estipulados
	 * para esse empr�stimo, e a data em que o empr�stimo foi realizado.
	 * 
	 * @param donoItem
	 *            Usuario que possui o item
	 * @param usuarioReceptor
	 *            Usuario que quer o item emprestado
	 * @param itemEmprestado
	 *            Item que ser� emprestado
	 * @param diasDoEmprestimo
	 *            Previs�o de dias de empr�stimo
	 * @param dataEmprestimo
	 *            Data em que empr�stimo ocorreu
	 */

	public Emprestimo(Usuario donoItem, Usuario usuarioReceptor, Item itemEmprestado, int diasDoEmprestimo,
			String dataEmprestimo) {

		this.donoItem = donoItem;
		this.donoItem.aumentarReputacao(itemEmprestado.getValor() * 0.10);
		this.usuarioReceptor = usuarioReceptor;
		this.itemEmprestado = itemEmprestado;
		this.itemEmprestado.setEstado(EstadoItem.INDISPONIVEL);
		this.itemEmprestado.somaNumeroDeEmprestimos();
		this.diasDoEmprestimo = diasDoEmprestimo;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(dataEmprestimo, formatter);
		this.dataEmprestimo = date;

	}

	public Usuario getDonoItem() {
		return donoItem;
	}

	public Usuario getUsuarioReceptor() {
		return usuarioReceptor;
	}

	public Item getItemEmprestado() {
		return itemEmprestado;
	}

	public int getDiasDoEmprestimo() {
		return diasDoEmprestimo;
	}

	public int getDiasDeAtraso() {
		return diasDeAtraso;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((donoItem == null) ? 0 : donoItem.hashCode());
		result = prime * result + ((itemEmprestado == null) ? 0 : itemEmprestado.hashCode());
		result = prime * result + ((usuarioReceptor == null) ? 0 : usuarioReceptor.hashCode());
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
		if (donoItem == null) {
			if (other.donoItem != null)
				return false;
		} else if (!donoItem.equals(other.donoItem))
			return false;
		if (itemEmprestado == null) {
			if (other.itemEmprestado != null)
				return false;
		} else if (!itemEmprestado.equals(other.itemEmprestado))
			return false;
		if (usuarioReceptor == null) {
			if (other.usuarioReceptor != null)
				return false;
		} else if (!usuarioReceptor.equals(other.usuarioReceptor))
			return false;
		return true;
	}

	/**
	 * Devolve um item ao usu�rio dono.
	 * 
	 * @param dataEmprestimo
	 *            Data em que empr�stimo ocorreu
	 * @param dataDevolucao
	 *            Data em que o item foi devolvido
	 */

	public void devolveItem(String dataEmprestimo, String dataDevolucao) {
		this.dataDevolucao = LocalDate.parse(dataDevolucao, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		int diasDesdeEmprestimo = (int) ChronoUnit.DAYS.between(this.dataEmprestimo, this.dataDevolucao);

		if (diasDesdeEmprestimo <= this.diasDoEmprestimo) {
			this.diasDeAtraso = 0;
		} else {
			this.diasDeAtraso = diasDesdeEmprestimo - this.diasDoEmprestimo;

		}

		this.itemEmprestado.setEstado(EstadoItem.DISPONIVEL);
		this.calculaAtraso(this.diasDeAtraso);
	}

	/**
	 * Verifica se teve dias de atraso ou n�o na devolu��o do emprestimo.
	 * 
	 * @param diasDeAtraso
	 */

	public void calculaAtraso(int diasDeAtraso) {
		if (diasDeAtraso > 0) {
			this.usuarioReceptor.diminuirReputacao(this.itemEmprestado.getValor() * diasDeAtraso * 0.01);
		} else if (diasDeAtraso <= 0) {
			this.usuarioReceptor.aumentarReputacao(itemEmprestado.getValor() * 0.05);
		}
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String representacao = "EMPRESTIMO - De: " + this.donoItem.getNome() + ", Para: "
				+ this.usuarioReceptor.getNome() + ", " + this.itemEmprestado.getNome() + ", "
				+ this.dataEmprestimo.format(formatter) + ", " + this.diasDoEmprestimo + " dias, ENTREGA: ";

		if (this.dataDevolucao == null) {
			representacao += "Emprestimo em andamento";
			return representacao;
		} else {
			representacao += this.dataDevolucao.format(formatter);
			return representacao;
		}

	}

}