package Classes;

import java.util.Arrays;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author nazareno
 *
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 100;

	private static final int TAMANHO_FAVORITOS = 10;
	
	private Contato[] contatos;  //apenas uma simplificacao de contato

	private Contato[] favoritos;

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[TAMANHO_FAVORITOS];
	}
	
	/**
	 * Acessa a lista de contatos mantida.
	 * @return O array de contatos.
	 */
	public Contato[] getContatos() {
		return this.contatos.clone();
	}

	/**
	 * Acessa os dados de um contato específico.
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public Contato getContato(int posicao) {
		return contatos[posicao];
	}

	/** 
	 * @return Contato[]
	 */
	public Contato[] getFavoritos() {
		return this.favoritos.clone();
	}

	/**
	 * Acessa os dados de um contato específico que foi favoritado.
	 * @param posicao Posição do contato na agenda.
	 * @return Dados do contato. Null se não há contato na posição.
	 */
	public Contato getFavorito(int posicao) {
		return favoritos[posicao];
	}

	/** 
	 * Atualiza o telefone do contato.
	 * 
	 * @param posicao
	 * @param novoTelefone
	 */
	public void mudarTelefone(int posicao, String novoTelefone) {
		contatos[posicao].setNewTelefone(novoTelefone);
	}

	/**
	 * Cadastra um contato em uma posição. Um cadastro em uma posição que já existe sobrescreve o anterior. 
	 * @param posicao Posição do contato.
	 * @param nome Nome do contato.
	 * @param sobrenome Sobrenome do contato.
	 * @param telefone Telefone do contato.
	 */
	public void cadastraContato(int posicao, String nome, String sobrenome, String telefone) {
		if (posicao < 0 || posicao >= TAMANHO_AGENDA){
			throw new IllegalArgumentException("POSIÇÃO INVÁLIDA");
		}
		else if (hasContato(nome,sobrenome)) {
			throw new IllegalArgumentException("CONTATO JA CADASTRADO");
		}
		else if (nome.isBlank() || telefone.isBlank()) {
			throw new IllegalArgumentException("CONTATO INVALIDO");
		}

		this.contatos[posicao] = new Contato(nome, sobrenome, telefone);
	}

	
	/** 
	 * @param posicao
	 */
	public void delContato(int posicao) {
		if (posicao < 0 || posicao >= TAMANHO_AGENDA){
			throw new IllegalArgumentException("POSIÇÃO INVÁLIDA");
		}
		if(contatos[posicao].isFavorito()){
			favoritos[findFavorito(contatos[posicao])] = null;
		}

		contatos[posicao] = null;

	}

	
	/** 
	 * @param contato
	 * @return int
	 */
	private int findFavorito(Contato contato) {
		return Arrays.asList(favoritos).indexOf(contato);
	}

	/** 
	 * @param nome
	 * @param sobrenome
	 * @return boolean
	 */
	private boolean hasContato(String nome, String sobrenome) {
		for (Contato contato : contatos) {
			if (contato != null && 
			contato.getNome().equals(nome) && 
			contato.getSobrenome().equals(sobrenome)) {
                return true;
            }
		}
		return false;
	}
	
	/** 
	 * Adiciona o favorito na lista de favoritos além de mudar o atributo do objeto como true para favorito.
	 * 
	 * @param posicaoContato
	 * @param posicaoFavoritos
	 */
	public void adicionaFavorito(int posicaoContato, int posicaoFavoritos) {

		if (posicaoContato < 0 || posicaoContato >= TAMANHO_AGENDA || posicaoFavoritos < 0 || posicaoFavoritos > 10) {
			throw new IllegalArgumentException("POSIÇÃO INVÁLIDA");
		}
		else if (contatos[posicaoContato] == null) {
			throw new IllegalArgumentException("CONTATO NAO CADASTRADO");
		}
		else if (contatos[posicaoContato].isFavorito()) {
			removeFavorito(posicaoContato, posicaoFavoritos);
		}
		contatos[posicaoContato].setFavorito(true);
		favoritos[posicaoFavoritos] = contatos[posicaoContato];

	}

	
	/** 
	 * Remove o favorito na lista de favoritos além de mudar o atributo do objeto como false para favorito
	 * 
	 * @param posicaoContato
	 * @param posicaoFavoritos
	 */
	public void removeFavorito(int posicaoContato, int posicaoFavoritos) {
		if (posicaoContato < 0 || posicaoContato >= TAMANHO_AGENDA || posicaoFavoritos < 0 || posicaoFavoritos > 10) {
			throw new IllegalArgumentException("POSIÇÃO INVÁLIDA");
		}
		else if (contatos[posicaoContato] == null) {
			throw new IllegalArgumentException("CONTATO NAO CADASTRADO");
		}
		contatos[posicaoContato].setFavorito(false);
		favoritos[posicaoFavoritos] = null;

	}

}