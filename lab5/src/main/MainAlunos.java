import java.util.Scanner;

import Classes.*;

public class MainAlunos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ControleDeAlunos control = new ControleDeAlunos();
        
        while (true) {
            System.out.println(menu());
            switchMenu(scanner,control);
        }
    }

    private static String menu() {
        String menu = "(C)adastrar Aluno\n" +
                      "(E)xibir Aluno\n" +
                      "(N)ovo Grupo\n" +
                      "(A)locar Aluno no Grupo e (P)ertincencia de Grupos\n" +
                      "(S)im, quero sair\n";
        return menu;
    }

    private static void switchMenu(Scanner scanner, ControleDeAlunos control) {
        String opcao = scanner.nextLine();
        switch (opcao) {
            case "C":
                cadastrarAluno(scanner, control);
                break;
            case "E":
                exibirAluno(scanner, control);
                break;
            case "N":
                novoGrupo(scanner, control);
                break;
            case "A":
                //alocarAluno();
                break;
            case "P":
                //pertinenciaGrupo();
                break;
            case "S":
                sai();
                break;
            default:
                sai();
                break;
        }
    }

    private static void sai() {
        System.exit(0);
    }

    private static void cadastrarAluno(Scanner scanner, ControleDeAlunos control) {
            System.out.println("Matrícula: ");
            String matricula = scanner.nextLine();
            System.out.println("Nome: ");
            String nome = scanner.nextLine();
            System.out.println("Curso: ");
            String curso = scanner.nextLine();
            
            try {
                control.cadastrarAluno(matricula, nome, curso);
                System.out.println("CADASTRO REALIZADO!");
            }catch(Exception e) {
                System.out.println(e.getMessage());
            }
        }

    private static void exibirAluno(Scanner scanner, ControleDeAlunos control) {
        System.out.println("Matrícula: ");
        String matricula = scanner.nextLine();

        try {
            System.out.println(control.exibirAluno(matricula));
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private static void novoGrupo(Scanner scanner, ControleDeAlunos control) {
        System.out.println("Tema: ");
        String tema = scanner.nextLine();
        System.out.println("Tamanho: ");
        Integer tamanho = scanner.nextInt();
        try {
            control.cadastrarGrupo(tema, tamanho);
            System.out.println("CADASTRO REALIZADO!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}