package projeto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import comparators.EmprestimoNomeDonoItemComparator;
import comparators.EmprestimoNomeItemComparator;
import emprestimo.Emprestimo;
import emprestimo.EmprestimoID;
import item.EstadoItem;
import item.Item;
import usuario.Usuario;

/**
 * Representa��o de um Controller de Empr�stimos, que controla e executa as
 * a��es sobre os empr�stimos.
 * 
 * @author Higor
 *
 */

public class EmprestimoController implements Serializable {

	private Map<EmprestimoID, Emprestimo> emprestimos;

	/**
	 * Constr�i um Controller de Empr�stimos.
	 * 
	 */

	public EmprestimoController() {
		this.emprestimos = new HashMap<EmprestimoID, Emprestimo>();
	}

	/**
	 * Registra um empr�stimo no sistema: Map<EmprestimoID, Emprestimo>.
	 * 
	 * @param donoItem
	 *            usuario dono do item
	 * @param usuarioReceptor
	 *            usuario que recebe o item
	 * @param item
	 *            item que est� sendo emprestado
	 * @param dataEmprestimo
	 *            data em que item foi emprestado
	 * @param diasDoEmprestimo
	 *            dias at� a devolu��o
	 */

	public void registrarEmprestimo(Usuario donoItem, Usuario usuarioReceptor, Item item, String dataEmprestimo,
			int diasDoEmprestimo) {

		EmprestimoID emprestimoID = new EmprestimoID(donoItem, usuarioReceptor, item);
		if (this.emprestimos.containsKey(emprestimoID)) {
			throw new IllegalArgumentException("Emprestimo ja existe");
		}
		Emprestimo emprestimo = new Emprestimo(donoItem, usuarioReceptor, item, diasDoEmprestimo, dataEmprestimo);
		this.emprestimos.put(emprestimoID, emprestimo);
	}

	/**
	 * Finaliza um emprestimo, o item emprestado passa a ficar dispon�vel.
	 * 
	 * @param donoItem
	 *            usuario dono do item
	 * @param usuarioReceptor
	 *            usuario que recebe o item
	 * @param item
	 *            item que est� sendo emprestado
	 * @param dataInicial
	 *            data em que item foi emprestado
	 * @param dataDevolucao
	 *            data em que item foi devolvido
	 */

	public void devolverItem(Usuario usuarioDono, Usuario usuarioEmprestimo, Item item, String dataInicial,
			String dataDevolucao) {
		EmprestimoID emprestimoID = new EmprestimoID(usuarioDono, usuarioEmprestimo, item);
		if (emprestimos.containsKey(emprestimoID)) {
			emprestimos.get(emprestimoID).devolveItem(dataInicial, dataDevolucao);
		} else {
			throw new IllegalArgumentException("Emprestimo nao encontrado");
		}

	}

	/**
	 * Lista itens que determinado usu�rio (recebido como param�tro) est�
	 * emprestando.
	 * 
	 * @param nome
	 *            nome do usu�rio dono do item
	 * @param telefone
	 *            telefone do usu�rio dono do item
	 * @return listagem dos itens que esse usu�rio est� emprestando
	 */

	public String listarEmprestimosEmprestando(String nome, String telefone) {
		ArrayList<Emprestimo> emprestimosEmprestando = new ArrayList<Emprestimo>();

		for (Emprestimo emprestimo : this.emprestimos.values()) {
			if (emprestimo.getDonoItem().getNome().equals(nome)
					&& emprestimo.getDonoItem().getTelefone().equals(telefone)) {
				emprestimosEmprestando.add(emprestimo);
			}

		}

		if (emprestimosEmprestando.size() == 0) {
			return "Nenhum item emprestado";
		}

		Collections.sort(emprestimosEmprestando, new EmprestimoNomeItemComparator());
		String emprestimos = "Emprestimos: ";

		for (Emprestimo emprestimo : emprestimosEmprestando) {
			emprestimos += emprestimo.toString() + "|";
		}
		return emprestimos;
	}

	/**
	 * Lista itens que determinado usu�rio (recebido como param�tro) est� pegando
	 * emprestado.
	 * 
	 * @param nome
	 *            nome do usu�rio receptor
	 * @param telefone
	 *            telefone do usu�rio receptor
	 * @return listagem dos itens que esse usu�rio est� pegando emprestado
	 */

	public String listarEmprestimosPegandoEmprestado(String nome, String telefone) {
		ArrayList<Emprestimo> emprestimosPegandoEmprestado = new ArrayList<Emprestimo>();

		for (Emprestimo emprestimo : this.emprestimos.values()) {
			if (emprestimo.getUsuarioReceptor().getNome().equals(nome)
					&& emprestimo.getUsuarioReceptor().getTelefone().equals(telefone)) {
				emprestimosPegandoEmprestado.add(emprestimo);
			}
		}
		if (emprestimosPegandoEmprestado.size() == 0) {
			return "Nenhum item pego emprestado";
		}

		Collections.sort(emprestimosPegandoEmprestado, new EmprestimoNomeItemComparator());
		String emprestimos = "Emprestimos pegos: ";

		for (Emprestimo emprestimo : emprestimosPegandoEmprestado) {
			emprestimos += emprestimo.toString() + "|";
		}
		return emprestimos;
	}

	/**
	 * Lista os empr�stimos que est�o associados a esse item.
	 * 
	 * @param nomeItem
	 *            nome do item da listagem
	 * @return listagem dos emprestimos associados ao item
	 */

	public String listaEmprestimosItem(String nomeItem) {
		String emprestimos = "Emprestimos associados ao item: ";
		ArrayList<Emprestimo> emprestimosList = new ArrayList<Emprestimo>();

		for (Emprestimo emprestimo : this.emprestimos.values()) {
			if (emprestimo.getItemEmprestado().getNome().equals(nomeItem) && !emprestimosList.contains(emprestimo)) {
				emprestimos += emprestimo.toString() + "|";
				emprestimosList.add(emprestimo);
			}

		}

		if (emprestimosList.size() == 0) {
			return "Nenhum emprestimos associados ao item";
		}

		return emprestimos;
	}

	/**
	 * Lista itens que est�o sendo emprestados atualmente.
	 * 
	 * @return listagem dos itens que est�o sendo emprestados
	 */

	public String listarItensEmprestados() {
		String listagem = "";
		ArrayList<Emprestimo> emprestimosList = new ArrayList<Emprestimo>();

		for (Emprestimo emprestimo : this.emprestimos.values()) {
			if (emprestimo.getItemEmprestado().getEstado().equals(EstadoItem.INDISPONIVEL)
					&& emprestimo.getDataDevolucao() == null) {
				emprestimosList.add(emprestimo);
			}
		}

		Collections.sort(emprestimosList, new EmprestimoNomeDonoItemComparator());

		for (Emprestimo emprestimo : emprestimosList) {

			listagem += "Dono do item: " + emprestimo.getDonoItem().getNome() + ", Nome do item emprestado: "
					+ emprestimo.getItemEmprestado().getNome() + "|";

		}

		return listagem;

	}

}
