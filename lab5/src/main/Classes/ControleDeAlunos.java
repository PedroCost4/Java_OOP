package Classes;


import java.util.HashMap;

/**
 * Controle de todos os alunos cadastrados no sistema.
 * 
 * @author pedro.henrique.costa
 *
 */
public class ControleDeAlunos {
    
    private HashMap<String, Grupo> grupos;
    private HashMap<String, Aluno> alunos;

    /**
     * Constrói um controle de alunos a partir de um HashMap de alunos.
     * 
     */
    public ControleDeAlunos() {
        this.grupos = new HashMap<String, Grupo>();
        this.alunos = new HashMap<String, Aluno>();
    }

    
    /** 
     * @return HashMap<String, Aluno>
     */
    public HashMap<String, Aluno> getAlunos() {
        return alunos;
    }

    
    /** 
     * @return HashMap<String, Grupo>
     */
    public HashMap<String, Grupo> getGrupos() {
        return grupos;
    }

    
    /** 
     * Trata erros de entrada e cadastra o aluno no sistema.
     * 
     * @param matricula
     * @param nome
     * @param curso
     */
    public String cadastrarAluno(String matricula, String nome, String curso) {
        if (matricula.isBlank() || nome.isBlank() || curso.isBlank()) {
            throw new IllegalArgumentException("ALGUMA ENTRADA VAZIA");
        }
        if (alunos.containsKey(matricula)) {
            throw new IllegalArgumentException("MATRÍCULA JÁ CADASTRADA");
        }
        
        alunos.put(matricula, new Aluno(matricula, nome, curso));

        return "Aluno cadastrado com sucesso!";
    }

    
    /** 
     * Trata erros de entrada e cadastra o grupo no sistema.
     * 
     * @param tema
     * @param tamanho
     */
    public String cadastrarGrupo(String tema, Integer tamanho) {
        if (tema.isBlank()) {
            throw new IllegalArgumentException("TEMA VAZIA");
        }
        if (grupos.containsKey(tema.toUpperCase())) {
            throw new IllegalArgumentException("GRUPO JÁ CADASTRADO");
        }
        if (tamanho != null && tamanho < 1) {
            throw new IllegalArgumentException("TAMANHO INVÁLIDO");
        }

        Grupo grupo = new Grupo(tema, tamanho);
        grupos.put(tema.toUpperCase(), grupo);

        return "Grupo Cadastrado com sucesso!";
    }

    
    /** 
     * Trata erros e aloca aluno dentro de um grupo.
     * 
     * @param tema
     * @param matricula
     */
    public String alocarAluno(String matricula, String tema) {
        if (tema.isBlank() || matricula.isBlank()) {
            throw new IllegalArgumentException("ALGUMA ENTRADA VAZIA");
        }
        if (!alunos.containsKey(matricula)) {
            throw new IllegalArgumentException("ALUNO NÃO CADASTRADO");
        }
        Grupo grupo = hasGrupo(tema);

        if (grupo.hasAluno(matricula)) {
            throw new IllegalArgumentException("ALUNO JÁ CADASTRADO NO GRUPO");
        }

        grupo.addAluno(matricula);

        return "Aluno Alocado com sucesso!";
    }

    
    /** 
     * Trata erros e verifica se o aluno pertence ao grupo pesquisado.
     * 
     * @param tema
     * @param matricula
     * @return boolean se o aluno pertence = true
     * @return boolean se o aluno não pertence = false
     */
    public boolean pertinenciaGrupo(String matricula, String tema) {
        if (tema.isBlank() || matricula.isBlank()) {
            throw new IllegalArgumentException("ALGUMA ENTRADA VAZIA");
        }
        if (!alunos.containsKey(matricula)) {
            throw new IllegalArgumentException("ALUNO NÃO CADASTRADO");
        }

        Grupo grupo = hasGrupo(tema);
        if (grupo.hasAluno(matricula)) {
            return true;
        } else {
            return false;
        }
    }

    
    /** 
     * Exibe as informações (com matricula) de todos os alunos cadastrados.
     * 
     * @param matricula
     * @return String
     */
    public String exibirAluno(String matricula) {
        return "Aluno: " + matricula + " " + alunos.get(matricula).toString();
    }

    
    /** 
     * Retorna a string que representa a lista de grupos que o aluno faz parte.
     * 
     * @param matricula
     * @return String
     */
    public String gruposDoAluno(String matricula) {
        String saida = "";
        boolean checker = false;
        for (Grupo grupo : grupos.values()) {
            if (grupo.hasAluno(matricula)) {
                saida += grupo.toString() + System.lineSeparator();
                checker = true;
            }
        }
        if (!checker){
            return "Aluno não pertence a nenhum grupo.";
        }

        return saida;
    }


    
    /** 
     * @param tema
     * @return Grupo
     */
    private Grupo hasGrupo(String tema) {
        if (grupos.containsKey(tema.toUpperCase())){
            return grupos.get(tema);
        } else {
            throw new IllegalArgumentException("GRUPO NÃO CADASTRADO");
        }
    }

    }