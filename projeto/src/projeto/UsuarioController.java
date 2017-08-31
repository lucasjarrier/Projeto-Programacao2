package projeto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import comparators.ItemNomeComparator;
import comparators.ItemNumeroDeEmprestimosComparator;
import comparators.ItemValorComparator;
import comparators.MelhoresUsuariosReputacaoComparator;
import comparators.PioresUsuariosReputacaoComparator;
import item.EstadoItem;
import item.Item;
import usuario.Usuario;
import usuario.UsuarioID;
import utils.Validador;

/**
 * Representa��o de um Controller de Usu�rios, que controla e exerce
 * funcionalidades sobre os usu�rios.
 * 
 * @author Higor
 *
 */

public class UsuarioController implements Serializable {

	private Map<UsuarioID, Usuario> usuarios;
	private EmprestimoController emprestimoController;

	/**
	 * Constr�i um Controller de Usu�rios.
	 * 
	 */

	public UsuarioController() {
		this.usuarios = new HashMap<UsuarioID, Usuario>();
		this.emprestimoController = new EmprestimoController();
	}

	public void iniciarSistema() {
        Map<UsuarioID, Usuario> uc = null;
        EmprestimoController ec = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("projeto.dat"));
            uc = (HashMap<UsuarioID, Usuario>) ois.readObject();
            ec = (EmprestimoController) ois.readObject();
            this.usuarios = uc;
            this.emprestimoController = ec;
            ois.close();

        } catch (FileNotFoundException e) {
            this.usuarios = new HashMap<UsuarioID, Usuario>();
            this.emprestimoController = new EmprestimoController();
            return;

        } catch (IOException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
    }

    public void fecharSistema() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("projeto.dat"));
            oos.writeObject(this.usuarios);
            oos.writeObject(this.emprestimoController);
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
	
	/**
	 * Cadastra um novo usuario no sistema.
	 * 
	 * @param nome
	 *            nome do usu�rio
	 * @param telefone
	 *            telefone do usu�rio
	 * @param email
	 *            email eletr�nico do usu�rio
	 */

	public void cadastrarUsuario(String nome, String telefone, String email) {
		Validador.validaUsuario(nome, email, telefone);

		if (this.usuarios.containsKey(new UsuarioID(nome, telefone))) {
			throw new IllegalArgumentException("Usuario ja cadastrado");
		}

		this.usuarios.put((new UsuarioID(nome, telefone)), new Usuario(nome, telefone, email));
	}

	/**
	 * Remove usuario j� cadastrado.
	 * 
	 * @param nome
	 *            nome do usu�rio
	 * @param telefone
	 *            telefone do usu�rio
	 */
	public void removerUsuario(String nome, String telefone) {
		Validador.validaRemover(nome, telefone);

		UsuarioID usuarioID = new UsuarioID(nome, telefone);
		if (usuarios.containsKey(usuarioID)) {
			this.usuarios.remove(usuarioID);
		} else {
			throw new IllegalArgumentException("Usuario invalido");
		}

	}

	/**
	 * Recebe um atributo e atualiza o valor do atributo no Usuario j� cadastrado.
	 * 
	 * @param nome
	 *            nome do usu�rio
	 * @param telefone
	 *            telefone do usu�rio
	 * @param atributo
	 *            atributo a ser atualizado
	 * @param valor
	 *            valor do novo atributo
	 */
	public void atualizarUsuario(String nome, String telefone, String atributo, String valor) {
		Validador.validaAtualizar(nome, telefone, valor, atributo);

		UsuarioID usuario = new UsuarioID(nome, telefone);

		if (!usuarios.containsKey(usuario)) {
			throw new IllegalArgumentException("Usuario invalido");
		}

		if (atributo.equals("Nome")) {
			this.usuarios.put(new UsuarioID(valor, telefone),
					new Usuario(valor, telefone, this.usuarios.get(usuario).getEmail()));
			usuarios.remove(usuario);
		} else if (atributo.equals("Telefone")) {
			this.usuarios.put(new UsuarioID(nome, valor),
					new Usuario(nome, valor, this.usuarios.get(usuario).getEmail()));
			usuarios.remove(usuario);
		} else if (atributo.equals("Email")) {
			this.usuarios.get(usuario).setEmail(valor);
		}
	}

	/**
	 * Recebe um atributo e depedendo do mesmo, retorna o valor atribuido a ele.
	 * 
	 * @param nome
	 *            nome do usu�rio
	 * @param telefone
	 *            telefone do usu�rio
	 * @param atributo
	 *            atributo a ser retornado
	 * @return valor equivalente ao atributo.
	 */

	public String getInfoUsuario(String nome, String telefone, String atributo) {
		UsuarioID usuario = new UsuarioID(nome, telefone);

		if (!usuarios.containsKey(usuario)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		return usuarios.get(usuario).getInfoUsuario(atributo);
	}

	private Usuario getUsuario(String nome, String telefone) {
		UsuarioID usuario = new UsuarioID(nome, telefone);
		if (!usuarios.containsKey(usuario)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		return this.usuarios.get(usuario);
	}

	/**
	 * Cadastra um filme no sistema.
	 * 
	 * @param nomeUsuario
	 *            nome do usu�rio
	 * @param telefone
	 *            numero telef�nico do usu�rio
	 * @param nomeItem
	 *            nome do item
	 * @param preco
	 *            pre�o do item
	 * @param duracao
	 *            dura��o do filme
	 * @param genero
	 *            g�nero do filme
	 * @param classificacao
	 *            classifica��o indicativa do filme
	 * @param ano
	 *            ano de lancamento do filme
	 * 
	 */

	public void cadastraFilme(String nomeUsuario, String telefone, String nomeItem, double preco, int duracao,
			String genero, String classificacao, int ano) {
		if (preco <= 0) {
			throw new IllegalArgumentException("Preco invalido");
		}

		getUsuario(nomeUsuario, telefone).adicionaFilme(nomeItem, preco, duracao, classificacao, genero, ano);
	}

	/**
	 * Esse metodo eh responsavel por cadastrar uma serie.
	 * 
	 * @param nomeUsuario
	 *            nome do usuario
	 * @param telefone
	 *            numero do telefone do usuario
	 * @param nomeItem
	 *            nome do item
	 * @param preco
	 *            pre�o do item
	 * @param descricao
	 *            descri��o da serie
	 * @param duracao
	 *            dura��o da serie
	 * @param genero
	 *            g�nero da serie
	 * @param classificacao
	 *            classifica��o indicativa da serie
	 * @param temporada
	 *            temporada da serie
	 * 
	 */

	public void cadastraSerie(String nomeUsuario, String telefone, String nomeItem, double preco, String descricao,
			int duracao, String genero, String classificacao, int temporada) {
		if (preco <= 0) {
			throw new IllegalArgumentException("Preco invalido");
		}
		getUsuario(nomeUsuario, telefone).adicionaSerie(nomeItem, preco, duracao, classificacao, descricao, genero,
				temporada);
	}

	/**
	 * Cadastra um show no sistema.
	 * 
	 * @param nomeUsuario
	 *            nome do usuario
	 * @param telefone
	 *            numero do telefone do usu�rio
	 * @param nomeItem
	 *            nome do item
	 * @param preco
	 *            pre�o do item
	 * @param duracao
	 *            dura��o da serie
	 * @param faixas
	 *            quantidade de faixas do show
	 * @param artista
	 *            nome do artista
	 * @param classificacao
	 *            classificacao indicativa do show
	 * 
	 */

	public void cadastraShow(String nomeUsuario, String telefone, String nomeItem, double preco, int duracao,
			int faixas, String artista, String classificacao) {
		if (preco <= 0) {
			throw new IllegalArgumentException("Preco invalido");
		}
		getUsuario(nomeUsuario, telefone).adicionaShow(nomeItem, preco, duracao, classificacao, artista, faixas);
	}

	/**
	 * Cadastra um jogo eletr�nico no sistema.
	 * 
	 * @param nomeUsuario
	 *            nome do usuario
	 * @param telefone
	 *            numero do telefone
	 * @param nomeItem
	 *            nome do item
	 * @param preco
	 *            pre�o do item
	 * @param plataforma
	 *            plataforma do jogo
	 * 
	 */

	public void cadastraEletronico(String nomeUsuario, String telefone, String nomeItem, double preco,
			String plataforma) {
		if (preco <= 0) {
			throw new IllegalArgumentException("Preco invalido");
		}
		getUsuario(nomeUsuario, telefone).adicionaEletronico(nomeItem, preco, plataforma);
	}

	/**
	 * Cadastra um jogo de tabuleiro no sistema.
	 * 
	 * @param nomeUsuario
	 *            nome do usuario
	 * @param telefone
	 *            numero do telefone do usu�rio
	 * @param nomeItem
	 *            nome do item
	 * @param preco
	 *            pre�o do item
	 * 
	 */

	public void cadastraJogoTabuleiro(String nomeUsuario, String telefone, String nomeItem, double preco) {
		if (preco <= 0) {
			throw new IllegalArgumentException("Preco invalido");
		}
		getUsuario(nomeUsuario, telefone).adicionaTabuleiro(nomeItem, preco);
	}

	/**
	 * Adiciona um epis�dio a um BluRaySerie.
	 * 
	 * @param nomeUsuario
	 *            nome do usuario
	 * @param telefone
	 *            numero do telefone do usu�rio
	 * @param nomeBlurayTemporada
	 *            nome do bluray
	 * @param duracao
	 *            duracao do episodio a ser adicionado
	 * 
	 */

	public void adicionarBluRay(String nomeUsuario, String telefone, String nomeBlurayTemporada, int duracao) {
		getUsuario(nomeUsuario, telefone).adicionaBluRay(nomeBlurayTemporada, duracao);
	}

	/**
	 * Adiciona uma pe�a perdida a um jogo de tabuleiro.
	 * 
	 * @param nome
	 *            nome do usuario
	 * @param telefone
	 *            numero do telefone do usuario
	 * @param nomeItem
	 *            nome do item
	 * @param nomePeca
	 *            nome da pe�a perdida
	 */

	public void adicionarPecaPerdida(String nome, String telefone, String nomeItem, String nomePeca) throws Exception {
		getUsuario(nome, telefone).adicionaPecaPerdida(nomeItem, nomePeca);
	}

	/**
	 * Esse metodo retorna informa��es sobre o item de acordo com o atributo
	 * escolhido.
	 * 
	 * @param nomeUsuario
	 *            nome do usuario
	 * @param telefone
	 *            numero do telefone do usuario
	 * @param nomeItem
	 *            nome do item
	 * @param atributo
	 *            atributo que se quer ter a informacao
	 * @return atributo escolhido
	 * 
	 */

	public String getInfoItem(String nomeUsuario, String telefone, String nomeItem, String atributo) {
		UsuarioID usuario = new UsuarioID(nomeUsuario, telefone);
		if (!usuarios.containsKey(usuario)) {
			throw new IllegalArgumentException("Usuario invalido");
		}
		return usuarios.get(usuario).getInfoItem(nomeItem, atributo);

	}

	/**
	 * Esse metodo atualiza determinado atributo do item.
	 * 
	 * @param nomeUsuario
	 *            nome do usuario
	 * @param telefone
	 *            numero do telefone
	 * @param nomeItem
	 *            nome do item
	 * @param atributo
	 *            atributo que se quer atualizar
	 * @param valor
	 *            novo valor do atributo
	 * 
	 */

	public void atualizaItem(String nomeUsuario, String telefone, String nomeItem, String atributo, String valor) {
		Usuario usuario = getUsuario(nomeUsuario, telefone);
		usuario.atualizarItem(nomeItem, atributo, valor);
	}

	/**
	 * 
	 * Esse metodo remove um item do usuario.
	 * 
	 * @param nomeUsuario
	 *            nome do usuario
	 * @param telefone
	 *            numero do telefone do usu�rio
	 * @param nomeItem
	 *            nome do item a ser removido
	 * 
	 */

	public void removerItem(String nomeUsuario, String telefone, String nomeItem) {
		Usuario usuario = getUsuario(nomeUsuario, telefone);
		usuario.removeItem(nomeItem);
	}

	/**
	 * Lista os itens cadastrados de todos os usu�rios ordenados pelo nome.
	 * 
	 * @return listagem de todos itens ordenados pelo nome
	 */

	public String listarItensOrdenadosPorNome() {
		ArrayList<Item> itensOrdenados = new ArrayList<Item>();
		String listagem = "";

		for (Usuario usuario : this.usuarios.values()) {
			itensOrdenados.addAll(usuario.getItens());
		}
		Collections.sort(itensOrdenados, new ItemNomeComparator());

		for (Item item : itensOrdenados) {
			listagem += item.toString() + "|";
		}
		return listagem;
	}

	/**
	 * Lista os itens cadastrados de todos os usu�rios ordenados pelo valor.
	 * 
	 * @return listagem de todos os itens ordenados pelo valor
	 */

	public String listarItensOrdenadosPorValor() {
		ArrayList<Item> itensOrdenados = new ArrayList<Item>();
		String listagem = "";

		for (Usuario usuario : this.usuarios.values()) {

			itensOrdenados.addAll(usuario.getItens());
		}

		Collections.sort(itensOrdenados, new ItemValorComparator());

		for (Item item : itensOrdenados) {
			listagem += item.toString() + "|";
		}
		return listagem;
	}

	/**
	 * Pesquisa detalhes de determinado item.
	 * 
	 * @param nome
	 *            nome do usu�rio
	 * @param telefone
	 *            telefone do usu�rio
	 * @param item
	 *            nome do item a retornar essas informa��es
	 * @return detalhes do item em String
	 */

	public String pesquisarDetalhesItem(String nome, String telefone, String item) {
		UsuarioID usuario = new UsuarioID(nome, telefone);
		if (!this.usuarios.containsKey(usuario)) {
			throw new NullPointerException("Usuario invalido");
		}
		return this.usuarios.get(usuario).getItem(item).toString();
	}

	/**
	 * Esse m�todo passa os param�tros para o m�todo de registro de empr�stimo no
	 * Controller de Empr�stimos.
	 * 
	 * @param nomeDono
	 *            nome do usu�rio dono do item
	 * @param telefoneDono
	 *            telefone do usu�rio dono do item
	 * @param nomeReceptor
	 *            nome do usu�rio que vai receber o item
	 * @param telefoneReceptor
	 *            telefone do usu�rio que vai receber o item
	 * @param nomeItem
	 *            nome do item a ser emprestado
	 * @param dataEmprestimo
	 *            data inicial do emprestimo
	 * @param periodo
	 *            periodo em dias at� a devolu��o
	 */

	public void registrarEmprestimo(String nomeDono, String telefoneDono, String nomeReceptor, String telefoneReceptor,
			String nomeItem, String dataEmprestimo, int periodo) {
		UsuarioID usuarioDonoID = new UsuarioID(nomeDono, telefoneDono);
		UsuarioID usuarioReceptorID = new UsuarioID(nomeReceptor, telefoneReceptor);
		if (!this.usuarios.containsKey(usuarioDonoID) || !this.usuarios.containsKey(usuarioReceptorID)) {
			throw new NullPointerException("Usuario invalido");
		}

		if (usuarios.get(usuarioReceptorID).getReputacao() < 0) {
			throw new IllegalArgumentException("Usuario nao pode pegar nenhum item emprestado");
		}

		if (periodo > usuarios.get(usuarioReceptorID).getCartaoReputacao().getPeriodoMaximo()) {
			throw new IllegalArgumentException("Usuario impossiblitado de pegar emprestado por esse periodo");
		}

		Usuario dono = this.usuarios.get(usuarioDonoID);
		Usuario receptor = this.usuarios.get(usuarioReceptorID);
		Item itemEmprestimo = dono.getItem(nomeItem);

		if (itemEmprestimo.getEstado().equals(EstadoItem.INDISPONIVEL)) {
			throw new IllegalArgumentException("Item emprestado no momento");
		}

		this.emprestimoController.registrarEmprestimo(dono, receptor, itemEmprestimo, dataEmprestimo, periodo);

	}

	/**
	 * Esse m�todo passa os param�tros para o m�todo de devolu��o de empr�stimo no
	 * Controller de Empr�stimos.
	 * 
	 * @param nomeDono
	 *            nome do usu�rio dono do item
	 * @param telefoneDono
	 *            telefone do usu�rio dono do item
	 * @param nomeReceptor
	 *            nome do usu�rio que vai receber o item
	 * @param telefoneReceptor
	 *            telefone do usu�rio que vai receber o item
	 * @param nomeItem
	 *            nome do item a ser emprestado
	 * @param dataEmprestimo
	 *            data inicial do emprestimo
	 * @param dataDevolucao
	 *            data em que item foi devolvido
	 */

	public void devolverItem(String nomeDono, String telefoneDono, String nomeReceptor, String telefoneReceptor,
			String nomeItem, String dataEmprestimo, String dataDevolucao) {
		UsuarioID usuarioDonoID = new UsuarioID(nomeDono, telefoneDono);
		UsuarioID usuarioReceptorID = new UsuarioID(nomeReceptor, telefoneReceptor);
		if (!this.usuarios.containsKey(usuarioDonoID) || !this.usuarios.containsKey(usuarioReceptorID)) {
			throw new NullPointerException("Usuario invalido");
		}

		Usuario dono = this.usuarios.get(usuarioDonoID);
		Usuario receptor = this.usuarios.get(usuarioReceptorID);
		Item itemEmprestimo = dono.getItem(nomeItem);

		this.emprestimoController.devolverItem(dono, receptor, itemEmprestimo, dataEmprestimo, dataDevolucao);

	}

	/**
	 * Lista os 10 usu�rios com as reputa��es mais baixas.
	 * 
	 * @return listagem de 10 usu�rios com reputa��es mais baixas.
	 */

	public String listarTop10PioresUsuarios() {
		ArrayList<Usuario> top10Usuarios = new ArrayList<Usuario>(this.usuarios.values());
		String listagem = "";

		Collections.sort(top10Usuarios, new PioresUsuariosReputacaoComparator());

		int cont = 1;
		for (Usuario usuario : top10Usuarios) {
			if (cont > 10) {
				return listagem;
			}
			String reputacao = String.format("%.2f", usuario.getReputacao());
			listagem += (cont + ": " + usuario.getNome() + " - Reputacao: " + reputacao + "|");
			cont++;
		}
		return listagem;
	}

	/**
	 * Lista os usu�rios do sistema que possuem reputa��o negativa.
	 * 
	 * @return listagem dos usu�rios caloteiros.
	 */

	public String listarCaloteiros() {
		String listarCaloteiros = "";

		for (Usuario usuario : this.usuarios.values()) {
			if (usuario.getReputacao() < 0) {
				listarCaloteiros += usuario.toString() + "|";
			}
		}
		return "Lista de usuarios com reputacao negativa: " + listarCaloteiros;
	}

	/**
	 * Lista os 10 usu�rios com as reputa��es mais altas.
	 * 
	 * @return listagem de 10 usu�rios com as melhores reputa��es.
	 */

	public String listarTop10MelhoresUsuarios() {
		ArrayList<Usuario> top10Usuarios = new ArrayList<Usuario>(this.usuarios.values());
		String listagem = "";

		Collections.sort(top10Usuarios, new MelhoresUsuariosReputacaoComparator());

		int cont = 1;
		for (Usuario usuario : top10Usuarios) {
			if (cont > 10) {
				return listagem;
			}
			String reputacao = String.format("%.2f", usuario.getReputacao());
			listagem += (cont + ": " + usuario.getNome() + " - Reputacao: " + reputacao + "|");
			cont++;
		}
		return listagem;
	}

	/**
	 * Listagem de itens dos usu�rios que n�o est�o sendo emprestados.
	 * 
	 * @return lista itens que est�o dispon�veis.
	 */

	public String listarItensNaoEmprestados() {
		ArrayList<Item> itensNaoEmprestados = new ArrayList<Item>();

		for (Usuario usuario : this.usuarios.values()) {
			itensNaoEmprestados.addAll(usuario.listarItensNaoEmprestados());
		}

		Collections.sort(itensNaoEmprestados, new ItemNomeComparator());
		String listagem = "";

		for (Item item : itensNaoEmprestados) {
			listagem += item.toString() + "|";
		}

		return listagem;

	}

	/**
	 * Lista os 10 itens mais emprestados.
	 * 
	 * @return listagem com os itens mais emprestados.
	 */

	public String listarTop10Itens() {
		ArrayList<Item> itens = new ArrayList<Item>();
		String top10 = "";

		for (Usuario usuario : this.usuarios.values()) {
			itens.addAll(usuario.getItensComEmprestimos());
		}

		Collections.sort(itens, new ItemNumeroDeEmprestimosComparator());

		int cont = 1;
		for (Item item : itens) {
			if (cont > 10) {
				return top10;
			}
			top10 += cont + ") " + item.getNumeroDeEmprestimos() + " emprestimos - " + item.toString() + "|";
			cont++;
		}

		return top10;

	}

	/**
	 * Valida se um usu�rio existe.
	 * 
	 * @param nome
	 *            nome do usu�rio
	 * @param telefone
	 *            telefone do usu�rio
	 */

	public void validaUsuario(String nome, String telefone) {
		if (!this.usuarios.containsKey(new UsuarioID(nome, telefone))) {
			throw new IllegalArgumentException("Usuario invalido");
		}
	}

	/*
	 * M�todos que passam param�tros para o Controller de Empr�stimos.
	 */

	public String listarEmprestimosEmprestando(String nome, String telefone) {
		this.validaUsuario(nome, telefone);
		return this.emprestimoController.listarEmprestimosEmprestando(nome, telefone);
	}

	public String listarEmprestimosPegandoEmprestado(String nome, String telefone) {
		this.validaUsuario(nome, telefone);
		return this.emprestimoController.listarEmprestimosPegandoEmprestado(nome, telefone);
	}

	public String listaEmprestimosItem(String nomeItem) {
		return this.emprestimoController.listaEmprestimosItem(nomeItem);

	}

	public String listarItensEmprestados() {
		return this.emprestimoController.listarItensEmprestados();

	}

}