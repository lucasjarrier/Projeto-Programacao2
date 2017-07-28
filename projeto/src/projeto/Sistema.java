package projeto;

import java.util.ArrayList;

public class Sistema {
	
	private final String LN = System.lineSeparator();
	private ArrayList<Usuario> usuarios;

	public Sistema() {
		this.usuarios = new ArrayList<Usuario>();
	}
	
	public void cadastraUsuario(String nome,String email,String numero) throws Exception {
		
		Usuario novoUsuario = new Usuario(nome,email,numero);
		this.usuarios.add(novoUsuario);		
	}	
	
	public String exibeUsuario(int usuario) throws Exception{
		
		if (usuario <= 0) {
			throw new Exception("Erro ao atualizar usuario: Posição invalida");
		}
		if (usuario > usuarios.size()) {
			throw new Exception("Erro ao atualizar usuario: Usuario não cadastrado");
		}

		return usuarios.get(usuario - 1).toString();
	}
	
	public void atualizaUsuario(int usuario,String nome, String email, String numero) throws Exception {
		
		if (usuario <= 0) {
			throw new Exception("Erro ao atualizar usuario: Posição invalida");
		}
		if (usuario > usuarios.size()) {
			throw new Exception("Erro ao atualizar usuario: Usuario não cadastrado");
		}	
		
		Usuario atualizaUsuario = new Usuario(nome,email,numero);
		this.usuarios.remove(usuario - 1);
		this.usuarios.add(atualizaUsuario);	
	}
	public void deletaUsuario(int usuario) throws Exception {
		
		if (usuario <= 0) {
			throw new Exception("Erro ao atualizar usuario: Posição invalida");
		}
		if (usuario > usuarios.size()) {
			throw new Exception("Erro ao atualizar usuario: Usuario não cadastrado");
		}
		this.usuarios.remove(usuario - 1);
	}

	public void cadastraItens(int usuario, String nome) throws Exception {
		if (usuario <= 0) {
			throw new Exception("Erro ao cadastrar item: Usuario invalido");
		}
		if (usuario > usuarios.size()) {
			throw new Exception("Erro ao cadastrar item: Usuario não cadastrado");
		}
		if (nome == null || nome.trim().isEmpty()) {
			throw new Exception("Erro ao cadastrar item: Nome nao pode ser vazio ou nulo");
		}
		Itens novoItem = new Itens(nome);
		usuarios.get(usuario - 1).getItens().add(novoItem);
	}
	
	public String exibeItens(int usuario) throws Exception {
		
		if (usuario <= 0) {
			throw new Exception("Erro ao exibir item: Usuario invalido");
		}
		if (usuario > usuarios.size()) {
			throw new Exception("Erro ao exibir item: Usuario não cadastrado");
		}
		
		String retorno = "";	
		for(int i = 0; i < usuarios.get(usuario - 1).getItens().size(); i++) {
			retorno += usuarios.get(usuario - 1).getItens().get(i).toString() + LN;
		}
		return retorno;
	}
	
	public void atualizaItem(int usuario, int item, EstadoItem estado) throws Exception {
		
		if (usuario <= 0) {
			throw new Exception("Erro ao atualizar item: Usuario inválido");
		}
		if (usuario > usuarios.size()) {
			throw new Exception("Erro ao atualizar item: Usuario não cadastrado");
		}
		if (item <= 0) {
			throw new Exception("Erro ao atualizar item: Item inválido");
		}
		if (item > usuarios.get(usuario).getItens().size()) {
			throw new Exception("Erro ao atualizar item: Item não cadastrado");
		}	
		
		/*
		 * FALTA IMPLEMENTAR ... 
		 */
	}
	
	public void deletaItem(int usuario, int item) throws Exception {
		
		if (usuario <= 0) {
			throw new Exception("Erro ao deletar item: Usuario inválido");
		}
		if (usuario > usuarios.size()) {
			throw new Exception("Erro ao deletar item: Usuario não cadastrado");
		}
		if (item <= 0) {
			throw new Exception("Erro ao deletar item: Item inválido");
		}
		if (item > usuarios.get(usuario).getItens().size()) {
			throw new Exception("Erro ao deletar item: Item não cadastrado");
		}
		this.usuarios.get(usuario).getItens().remove(item);
	}
}

	
	
	
	
