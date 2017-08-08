package projeto;

import java.util.ArrayList;
import java.util.Collections;

public class Sistema {

	private ArrayList<Usuario> usuarios;
	private ArrayList<Item> todosItens;

	public Sistema() {
		this.usuarios = new ArrayList<Usuario>();
		this.todosItens = new ArrayList<Item>();
	}

	public Usuario getUsuario(int usuario) {
		return this.usuarios.get(usuario - 1);
	}
		
	public String getInfoUsuario(String nome, String numero, String atributo) {
		
	}
	
	public void cadastraUsuario(String nome, String email, String numero) {
		Validador.validaUsuario(nome, email, numero);
		Usuario novoUsuario = new Usuario(nome, email, numero);
		this.usuarios.add(novoUsuario);

	}

	public String exibeUsuario(int usuario) {

		return this.getUsuario(usuario).toString();
	}

	public void atualizaUsuario(String nome, String email, String numero, String atributo, String valor) {
			
			for (Usuario usuario : usuarios) {
				if (usuario.getNome().equals(nome) && usuario.getNumero().equals(numero)) {
					if (atributo == "Nome") {
	                	usuario.setNome(valor);
	                }
	            	if (atributo == "Email") {
	            		usuario.setNome(valor);
	            	}
	            	if (atributo == "Numero") {
	            		usuario.setNumero(valor);
	            	}
	            }
			}
		}

	public void removerUsuario(String nome, String numero) throws Exception {
		validaRemover(nome, numero);
		
		for (int i = 0; i < usuarios.size(); i++) {
		    if (this.usuarios.get(i).getNome().equals(nome) && this.usuarios.get(i).getNumero().equals(numero)) {
		      this.usuarios.remove(i);
		    }
		}
		
	}

	public void cadastraItem(int usuario, String nome) {
		this.getUsuario(usuario).adicionaItem(nome);
	}

	public String exibeItens(int usuario) {
	
		return this.getUsuario(usuario).exibirItens();
	}

	public void atualizaItem(int usuario, int item, EstadoItem estado) {

		if (usuario <= 0) {
			throw new IllegalArgumentException("Erro ao atualizar item: Usuario inv�lido");
		}
		if (usuario > usuarios.size()) {
			throw new IllegalArgumentException("Erro ao atualizar item: Usuario n�o cadastrado");
		}
		if (item <= 0) {
			throw new IllegalArgumentException("Erro ao atualizar item: Item inv�lido");
		}
		if (item > usuarios.get(usuario).getItens().size()) {
			throw new IllegalArgumentException("Erro ao atualizar item: Item n�o cadastrado");
		}

		/*
		 * FALTA IMPLEMENTAR ...
		 */
	}

	public void deletaItem(int usuario, int item) {

		if (usuario <= 0) {
			throw new IllegalArgumentException("Erro ao deletar item: Usuario inv�lido");
		}
		if (usuario > usuarios.size()) {
			throw new IllegalArgumentException("Erro ao deletar item: Usuario n�o cadastrado");
		}
		if (item <= 0) {
			throw new IllegalArgumentException("Erro ao deletar item: Item inv�lido");
		}
		if (item > usuarios.get(usuario).getItens().size()) {
			throw new IllegalArgumentException("Erro ao deletar item: Item n�o cadastrado");
		}

	}
	
	public String listarItensOrdenadosPorNome() {

		ArrayList<Item> novoArray = new ArrayList<Item>();
		for (int i = 0; i < usuarios.size(); i++) {
			for (int e = 0; e < usuarios.get(i).getItens().size(); e++) {
				novoArray.addAll(usuarios.get(i).getItens());
			}
		}
		String retorno = "";
		Collections.sort(novoArray, new NomeComparator());

		for (int i = 0; i < novoArray.size(); i++) {
			retorno += novoArray.get(i).toString() + " ";
		}
		return retorno;
	}

	/**
	 * 
	 * @return Retorna em String todos os Itens cadastrado em ordem de maior
	 *         Valor.
	 */

	public String listarItensOrdenadosPorValor() {

		ArrayList<Item> novoArray = new ArrayList<Item>();
		for (int i = 0; i < usuarios.size(); i++) {
			for (int e = 0; e < usuarios.get(i).getItens().size(); e++) {
				novoArray.addAll(usuarios.get(i).getItens());
			}
		}
		String retorno = "";
		Collections.sort(novoArray, new ValorComparator());

		for (int i = 0; i < novoArray.size(); i++) {
			retorno += novoArray.get(i).toString() + " ";
		}
		return retorno;
	}

	/**
	 * 
	 * @param nomeItem
	 *            Parametro que recebe o nome de um Item.
	 * @param nomeUsuario
	 *            Parametro que recebe o nome de um Usuario que Possui esse
	 *            Item.
	 * @param numeroUsuario
	 *            Parametro que recebe o numero de um USuario que Possui esse
	 *            Item.
	 * @return Retorna em String um determinado Item de forma detalhada.
	 */

	public String pesquisarDetalhesItem(String nomeItem, String nomeUsuario, String numeroUsuario) {

		boolean contemNome = false;
		boolean contemNumero = false;

		String retorno = "";

		for (int i = 0; i < usuarios.size(); i++) {
			if (usuarios.get(i).getNome().equals(nomeUsuario)) {
				contemNome = true;
			}
			if (usuarios.get(i).getNumero().equals(numeroUsuario)) {
				contemNumero = true;
			}
			if (contemNome == true && contemNumero == true) {
				for (int e = 0; e < usuarios.get(i).getItens().size(); e++) {
					if (usuarios.get(i).getItens().get(e).getNome().equals(nomeItem)) {
						retorno += usuarios.get(i).getItens().get(e).toString();
					}
				}
			}
		}
		return retorno;
	}


}
