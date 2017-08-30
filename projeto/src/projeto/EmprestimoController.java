package projeto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import comparators.EmprestimoNomeItemComparator;
import emprestimo.Emprestimo;
import emprestimo.EmprestimoID;
import item.EstadoItem;
import item.Item;
import usuario.Usuario;

public class EmprestimoController {

	private Map<EmprestimoID, Emprestimo> emprestimos;
	private ArrayList<Emprestimo> historicoEmprestimos;

	public EmprestimoController() {
		this.emprestimos = new HashMap<EmprestimoID, Emprestimo>();
		this.historicoEmprestimos = new ArrayList<Emprestimo>();
	}

	public void registrarEmprestimo(Usuario donoItem, Usuario usuarioReceptor, Item item, String dataEmprestimo,
			int diasDoEmprestimo) {

		EmprestimoID emprestimoID = new EmprestimoID(donoItem, usuarioReceptor, item);
		if (this.emprestimos.containsKey(emprestimoID)) {
			throw new IllegalArgumentException("Emprestimo ja existe");
		}
		Emprestimo emprestimo = new Emprestimo(donoItem, usuarioReceptor, item, diasDoEmprestimo, dataEmprestimo);
		this.emprestimos.put(emprestimoID, emprestimo);
		historicoEmprestimos.add(emprestimo);
	}

	public void devolverItem(Usuario usuarioDono, Usuario usuarioEmprestimo, Item item, String dataInicial,
			String dataDevolucao) {
		EmprestimoID emprestimoID = new EmprestimoID(usuarioDono, usuarioEmprestimo, item);
		if (emprestimos.containsKey(emprestimoID)) {
			emprestimos.get(emprestimoID).devolveItem(dataInicial, dataDevolucao);
		} else {
			throw new IllegalArgumentException("Emprestimo nao encontrado");
		}

	}

	public String listarEmprestimosEmprestando(String nome, String telefone) {
		ArrayList<Emprestimo> emprestimosEmprestando = new ArrayList<Emprestimo>();

		for (Emprestimo emprestimo : this.historicoEmprestimos) {
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

	public String listarEmprestimosPegandoEmprestado(String nome, String telefone) {
		ArrayList<Emprestimo> emprestimosPegandoEmprestado = new ArrayList<Emprestimo>();

		for (Emprestimo emprestimo : this.historicoEmprestimos) {
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

	public String listaEmprestimosItem(String nomeItem) {
		String emprestimos = "Emprestimos associados ao item: ";
		ArrayList<Emprestimo> emprestimosList = new ArrayList<Emprestimo>();

		for (Emprestimo emprestimo : this.historicoEmprestimos) {
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
		
	
	public String listarItensEmprestados() {
		String listagem = "";
		ArrayList<Emprestimo> emprestimosList = new ArrayList<Emprestimo>();

		for (Emprestimo emprestimo : this.emprestimos.values()) {
			if (emprestimo.getItemEmprestado().getEstado().equals(EstadoItem.INDISPONIVEL)
					&& !emprestimosList.contains(emprestimo)) {
				emprestimosList.add(emprestimo);
			}
		}

		Collections.sort(emprestimosList, new EmprestimoNomeItemComparator());

		for (Emprestimo emprestimo : emprestimosList) {

			listagem += "Dono do item:" + emprestimo.getDonoItem().getNome() + ", Nome do item emprestado: "
					+ emprestimo.getItemEmprestado().getNome() + "|";

		}

		return listagem;

	}

}
