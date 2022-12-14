import Classes.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Interface com menus texto para manipular uma agenda de contatos.
 * 
 * @author 
 *
 */
public class MainAgenda {

	/** 
	 * @param args
	 */
	public static void main(String[] args) {
		Agenda agenda = new Agenda();

		System.out.println("Carregando agenda inicial");
		try {
			/*
			 * Essa é a maneira de lidar com possíveis erros por falta do arquivo. 
			 */
			carregaAgenda("agenda_inicial.csv", agenda);
		} catch (FileNotFoundException e) {
			System.err.println("Arquivo não encontrado: " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Erro lendo arquivo: " + e.getMessage());
		}

		Scanner scanner = new Scanner(System.in);
		String escolha = "";
		while (true) {
			escolha = menu(scanner);
			comando(escolha, agenda, scanner);
		}

	}

	/**
	 * Exibe o menu e captura a escolha do/a usuário/a.
	 * 
	 * @param scanner Para captura da opção do usuário.
	 * @return O comando escolhido.
	 */
	private static String menu(Scanner scanner) {
		System.out.println(
				"\n---\nMENU\n" + 
						"(C)adastrar Contato\n" + 
						"(L)istar Contatos\n" + 
						"(E)xibir Contato\n" + 
						"(S)air\n" + 
						"(F)avoritos\n" + 
						"(A)dicionar Favorito\n" +
						"(R)emover Favorito\n" +
						"\n" + 
						"Opção> ");
		return scanner.next().toUpperCase();
	}

	/**
	 * Interpreta a opção escolhida por quem está usando o sistema.
	 * 
	 * @param opcao   Opção digitada.
	 * @param agenda  A agenda que estamos manipulando.
	 * @param scanner Objeto scanner para o caso do comando precisar de mais input.
	 */
	private static void comando(String opcao, Agenda agenda, Scanner scanner) {
		switch (opcao) {
		case "C":
			cadastraContato(agenda, scanner);
			break;
		case "RC":
			removeContato(agenda, scanner);
			break;
		case "L":
			listaContatos(agenda);
			break;
		case "E":
			exibeContato(agenda, scanner);
			break;
		case "S":
			sai();
			break;
		case "F":
			listaFavoritos(agenda);
			break;
		case "A":
			adicionaFavorito(agenda, scanner);
			break;
		case "R":
			removeFavorito(agenda, scanner);
			break;
		default:
			System.out.println("OPÇÃO INVAlIDA!");
		}
	}

	/**
	 * Imprime lista de contatos da agenda.
	 * 
	 * @param agenda A agenda sendo manipulada.
	 */
	private static void listaContatos(Agenda agenda) {
		System.out.println("\nLista de contatos: ");
		Contato[] contatos = agenda.getContatos();
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				System.out.println(formataContato(i, contatos[i]));
			}
		}
	}

	/**
	 * Imprime os detalhes de um dos contatos da agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para capturar qual contato.
	 */
	private static void exibeContato(Agenda agenda, Scanner scanner) {
		System.out.println("\nQual contato> ");
		int posicao = scanner.nextInt() - 1;
		System.out.println((agenda.getContato(posicao) != null) ? agenda.getContato(posicao): "POSIÇÃO INVÁLIDA!");
	}

	/**
	 * Formata um contato para impressão na interface. 
	 * 
	 * @param posicao A posição do contato (que é exib	ida)/
	 * @param contato O contato a ser impresso.
	 * @return A String formatada.
	 */
	private static String formataContato(int posicao, Contato contato) {
		return posicao + " - " + contato.getNome() + " " + contato.getSobrenome();
	}

	/**
	 * Cadastra um contato na agenda. 
	 * 
	 * @param agenda A agenda.
	 * @param scanner Scanner para pedir informações do contato.
	 */
	private static void cadastraContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição> ");
		int posicao = scanner.nextInt() - 1;
		scanner.nextLine();
		System.out.print("\nNome> ");
		String nome = scanner.nextLine();
		System.out.print("\nSobrenome> ");
		String sobrenome = scanner.nextLine();
		System.out.print("\nTelefone> ");
		String telefone = scanner.nextLine();	

		try{
			agenda.cadastraContato(posicao, nome, sobrenome, telefone);
			System.out.println("CADASTRO REALIZADO");
		}catch (IllegalArgumentException e){
			System.out.println(e.getMessage());
		}
	}

	
	/** 
	 * @param agenda
	 * @param scanner
	 */
	private static void removeContato(Agenda agenda, Scanner scanner) {
		System.out.print("\nPosição> ");
		int posicao = scanner.nextInt() - 1;

		try {
			agenda.delContato(posicao);
		}catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Sai da aplicação.
	 */
	private static void sai() {
		System.out.println("\nVlw flw o/");
		System.exit(0);
	}

	/**
	 * Lê uma agenda de um arquivo csv. 
	 * 
	 * @param arquivoContatos O caminho para o arquivo.
	 * @param agenda A agenda que deve ser populada com os dados. 
	 * @throws IOException Caso o arquivo não exista ou não possa ser lido.
	 */
	private static void carregaAgenda(String arquivoContatos, Agenda agenda) throws FileNotFoundException, IOException {
		LeitorDeAgenda leitor = new LeitorDeAgenda();
		int carregados =  leitor.carregaContatos(arquivoContatos, agenda);
		System.out.println("Carregamos " + carregados + " registros.");
	}

	
	/** 
	 * Printa todos os nomes da lista de favoritos.
	 * 
	 * @param agenda
	 */
	private static void listaFavoritos(Agenda agenda) {
		Contato[] contatos = agenda.getFavoritos();
		System.out.println("\nLista de favoritos: ");
		for (int i = 0; i < contatos.length; i++) {
			if (contatos[i] != null) {
				System.out.println(formataContato(i, contatos[i]));
			}
		}
	}


	
	/** 
	 * pede informações e adiciona o contato na lista de favoritos
	 * 
	 * @param agenda
	 * @param scanner
	 */
	private static void adicionaFavorito(Agenda agenda, Scanner scanner) {
		System.out.print("\nQual contato> ");
		int posicao = scanner.nextInt() - 1;
		System.out.print("\nQual posicao> ");
		int index = scanner.nextInt() - 1;
		if (agenda.getContato(posicao) != null) {
			agenda.adicionaFavorito(posicao, index);
		} else {
			System.out.println("POSIÇÃO INVÁLIDA!");
		}
	}

	
	/** 
	 * Pede informações e remove um contato da lista de favoritos.
	 * 
	 * @param agenda
	 * @param scanner
	 */
	private static void removeFavorito(Agenda agenda, Scanner scanner) {
		System.out.print("\nQual contato> ");
		int posicao = scanner.nextInt() - 1;
		System.out.print("\nQual posicao> ");
		int index = scanner.nextInt() - 1;
		if (agenda.getContato(posicao) != null) {
			agenda.removeFavorito(posicao, index);
		} else {
			System.out.println("POSIÇÃO INVÁLIDA!");
		}
	}
}
