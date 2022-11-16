import java.util.Scanner;
import java.util.HashMap;

import Classes.*;

public class MainAlunos {

    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ControleDeAlunos control = new ControleDeAlunos();
        
        while (true) {
            System.out.println(menu());
            switchMenu(scanner,control);
        }
    }

    
    /** 
     * @return String
     */
    private static String menu() {
        String menu = "\n(C)adastrar Aluno\n" +
                      "(E)xibir Aluno\n" +
                      "(N)ovo Grupo\n" +
                      "(A)locar Aluno no Grupo e (P)ertincencia de Grupos\n" +
                      "(S)im, quero sair\n";
        return menu;
    }

    
    /** 
     * @param scanner
     * @param control
     */
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
            case "L":
                listarAlunos(control);
                break;
            case "A":
                alocarAluno(scanner, control);
                break;
            case "P":
                pertinenciaGrupo(scanner, control);
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

    
    /** 
     * @param scanner
     * @param control
     */
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

    
    /** 
     * @param scanner
     * @param control
     */
    private static void exibirAluno(Scanner scanner, ControleDeAlunos control) {
        System.out.println("Matrícula: ");
        String matricula = scanner.nextLine();

        try {
            System.out.println(control.exibirAluno(matricula));
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }

    
    /** 
     * @param control
     */
    public static void listarAlunos(ControleDeAlunos control) {
        HashMap<String, Aluno> alunos = control.getAlunos();
        for (String matricula: alunos.keySet()) {
            System.out.println(matricula + " " + alunos.get(matricula));
        }
    }

    
    /** 
     * @param scanner
     * @param control
     */
    private static void novoGrupo(Scanner scanner, ControleDeAlunos control) {
        System.out.println("Tema: ");
        String tema = scanner.nextLine();
        System.out.println("Tamanho: ");
        Integer tamanho = scanner.nextInt();
        scanner.nextLine();
        try {
            control.cadastrarGrupo(tema, tamanho);
            System.out.println("CADASTRO REALIZADO!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    
    /** 
     * @param scanner
     * @param control
     */
    public static void alocarAluno(Scanner scanner, ControleDeAlunos control) {
        System.out.println("Matrícula: ");
        String matricula = scanner.nextLine();
        System.out.println("Grupo: ");
        String grupo = scanner.nextLine();
        try {
            control.addAlunoEmGrupo(grupo, matricula);
            System.out.println("ALUNO ALOCADO!");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    
    /** 
     * @param scanner
     * @param control
     */
    public static void pertinenciaGrupo(Scanner scanner, ControleDeAlunos control) {
        System.out.println("Grupo: ");
        String grupo = scanner.nextLine();
        System.out.println("Aluno: ");
        String aluno = scanner.nextLine();

        try {
            control.pertinenciaGrupo(grupo, aluno);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}