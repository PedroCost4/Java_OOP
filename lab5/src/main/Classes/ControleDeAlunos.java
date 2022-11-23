package Classes;


import java.util.HashMap;


public class ControleDeAlunos {
    
    private HashMap<String, Grupo> grupos;
    private HashMap<String, Aluno> alunos;

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
     * @param tema
     * @param tamanho
     */
    public String cadastrarGrupo(String tema, Integer tamanho) {
        if (tema.isBlank()) {
            throw new IllegalArgumentException("TEMA VAZIA");
        }
        if (grupos.containsKey(tema)) {
            throw new IllegalArgumentException("GRUPO JÁ CADASTRADO");
        }
        Grupo grupo = new Grupo(tema, tamanho);
        grupos.put(tema, grupo);

        return "Grupo Cadastrado com sucesso!";
    }

    
    /** 
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
     * @param tema
     * @param matricula
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
     * @param matricula
     * @return String
     */
    public String exibirAluno(String matricula) {
        return "Aluno: " + matricula + " " + alunos.get(matricula).toString();
    }

    
    /** 
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
        if (grupos.containsKey(tema)){
            return grupos.get(tema);
        } else {
            throw new IllegalArgumentException("GRUPO NÃO CADASTRADO");
        }
    }

    }