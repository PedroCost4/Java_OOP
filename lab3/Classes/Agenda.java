package Classes;

/**
 * Uma agenda que mantém uma lista de contatos com posições. Podem existir 100 contatos. 
 * 
 * @author nazareno
 *
 */
public class Agenda {
	
	private static final int TAMANHO_AGENDA = 100;
	
	private Contato[] contatos;  //apenas uma simplificacao de contato

	private Contato[] favoritos;

	/**
	 * Cria uma agenda.
	 */
	public Agenda() {
		this.contatos = new Contato[TAMANHO_AGENDA];
		this.favoritos = new Contato[10];
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
		return favoritos;
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
			throw new IllegalArgumentException("POSICÃO INVALIDA");
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
	 * @param index
	 * @param posicao
	 */
	public void adicionaFavorito(int index, int posicao) {
		if (index < 0 || index >= TAMANHO_AGENDA){
			throw new IllegalArgumentException("Posição inválida");
		}
		else if (contatos[index] == null) {
			throw new IllegalArgumentException("CONTATO NAO CADASTRADO");
		}
		else if (contatos[index].isFavorito()) {
			removeFavorito(index, posicao);
		}
		contatos[index].setFavorito(true);
		favoritos[posicao] = contatos[index];

	}

	
	/** 
	 * Remove o favorito na lista de favoritos além de mudar o atributo do objeto como false para favorito
	 * 
	 * @param index
	 * @param posicao
	 */
	public void removeFavorito(int index, int posicao) {
		if (index < 0 || index >= TAMANHO_AGENDA){
			throw new IllegalArgumentException("Posição inválida");
		}
		else if (contatos[index] == null) {
			throw new IllegalArgumentException("CONTATO NAO CADASTRADO");
		}
		contatos[index].setFavorito(false);
		favoritos[posicao] = null;

	}

}