package Classes;


import java.util.HashMap;
import java.util.HashSet;

public class ControleDeAlunos {
    
    private HashSet<Grupo> grupos;
    private HashMap<String, Aluno> alunos;

    public ControleDeAlunos() {
        this.grupos = new HashSet<Grupo>();
        this.alunos = new HashMap<String, Aluno>();
    }

    
    /** 
     * @return HashMap<String, Aluno>
     */
    public HashMap<String, Aluno> getAlunos() {
        return alunos;
    }

    
    /** 
     * @param matricula
     * @param nome
     * @param curso
     */
    public void cadastrarAluno(String matricula, String nome, String curso) {
        if (matricula.isBlank() || nome.isBlank() || curso.isBlank()) {
            throw new IllegalArgumentException("ALGUMA ENTRADA VAZIA");
        }
        if (alunos.containsKey(matricula)) {
            throw new IllegalArgumentException("MATRÍCULA JÁ CADASTRADA");
        }
        
        alunos.put(matricula, new Aluno(matricula, nome, curso));
    }

    
    /** 
     * @param tema
     * @param tamanho
     */
    public void cadastrarGrupo(String tema, Integer tamanho) {
        if (tema.isBlank() || tamanho.equals(null) || tamanho < 0) {
            throw new IllegalArgumentException("ALGUMA ENTRADA VAZIA");
        }
        if (grupos.contains(new Grupo(tema, tamanho))) {
            throw new IllegalArgumentException("GRUPO JÁ CADASTRADO");
        }
        Grupo grupo = new Grupo(tema, tamanho);
        grupos.add(grupo);
    }

    
    /** 
     * @param tema
     * @param matricula
     */
    public void addAlunoEmGrupo(String tema, String matricula) {
        for (Grupo grupo: grupos) {
            if (grupo.getTema().equals(tema)) {
                grupo.addAluno(alunos.get(matricula));
            }
        }
    }

    
    /** 
     * @param tema
     * @param matricula
     */
    public void pertinenciaGrupo(String tema, String matricula) {
        for (Grupo grupo: grupos) {
            if (grupo.getTema().equals(tema)) {
                if (grupo.hasAluno(matricula)) {
                    throw new IllegalArgumentException("ALUNO JÁ CADASTRADO NO GRUPO");
                } else {
                    throw new IllegalArgumentException("ALUNO NÃO CADASTRADO NO GRUPO");
                }
            }
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
     * @param tema
     * @param matricula
     * @return boolean
     */
    public boolean hasAlunoInGrupo(String tema, String matricula) {
        for (Grupo grupo: grupos) {
            if (grupo.getTema().equals(tema)) {
                return grupo.hasAluno(matricula);
            }
        }
        return false;
    }

    }