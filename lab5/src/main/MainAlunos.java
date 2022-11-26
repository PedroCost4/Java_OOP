import java.util.Scanner;

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
                      "(A)locar Aluno no Grupo e verificar pertinência a Grupos\n" +
                      "(O)lha quais grupos o Aluno tá\n" +
                      "(S)im, quero sair\n";
        return menu;
    }
    /** 
     * @param scanner
     * @param control
     */
    private static void switchMenu(Scanner scanner, ControleDeAlunos control) {
        String opcao = scanner.nextLine().toUpperCase();
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
                switchMenu2(scanner, control);
                break;
            case "O":
                olhaGrupos(scanner, control);
                break;
            case "S":
                sai();
                break;
            default:
                sai();
                break;
        }
    }

    public static void switchMenu2(Scanner scanner, ControleDeAlunos control) {
        String menu = "(A)locar Aluno no Grupo\n" +
                      "(V)erificar pertinência a Grupos\n";
        System.out.println(menu);
        String opcao = scanner.nextLine().toUpperCase();
        switch (opcao) {
            case "A":
                alocarAluno(scanner, control);
                break;
            case "P":
                pertinenciaGrupo(scanner, control);
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
                System.out.println(control.cadastrarAluno(matricula, nome, curso));
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
     * @param scanner
     * @param control
     */
    private static void novoGrupo(Scanner scanner, ControleDeAlunos control) {
        System.out.println("Tema: ");
        String tema = scanner.nextLine();
        System.out.println("Tamanho: ");
        String tamanho = scanner.nextLine();
        try {
            System.out.println(control.cadastrarGrupo(tema, tamanho.isBlank() ? null : Integer.parseInt(tamanho)));
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
            System.out.println(control.alocarAluno(matricula, grupo));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    
    /** 
     * @param control
     * @param scanner
     */
    public static void pertinenciaGrupo(Scanner scanner, ControleDeAlunos control) {
        System.out.println("Grupo: ");
        String grupo = scanner.nextLine();
        System.out.println("Aluno: ");
        String aluno = scanner.nextLine();
        
        try {
            System.out.println(control.pertinenciaGrupo(aluno, grupo)? "ALUNO PERTENCE AO GRUPO" : "ALUNO NÃO PERTENCE AO GRUPO");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    
    /** 
     * @param scanner
     * @param control
     */
    public static void olhaGrupos(Scanner scanner, ControleDeAlunos control) {
        System.out.println("Matrícula: ");
        String matricula = scanner.nextLine();
        try {
            System.out.println(control.gruposDoAluno(matricula));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}