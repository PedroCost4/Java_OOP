package Classes;

import java.util.HashSet;


/**
 * Um grupo que contém informações sobre seu tema e tamanho além de alunos que pertencem a ele. 
 * 
 * @author nazareno
 *
 */
public class Grupo {
    
    private HashSet<String> alunos; 
    private Integer tamanho;
    private String tema;

    /**
     * Constrói um grupo a partir de seu tema e tamanho.
     * 
     * @param tema
     * @param tamanho
     */
    public Grupo(String tema, Integer tamanho) {
        this.alunos = new HashSet<String>();
        this.tamanho = tamanho;
        this.tema = tema;
    }

    
    /** 
     *
     * @return HashMap<String, Aluno>
     */
    public HashSet<String> getAlunos() {
        return alunos;
    }

    
    /** 
     * Trata erros de entrada e então adiciona aluno ao array de alunos.
     * 
     * @param aluno
     */
    public void addAluno(String matricula) {
        if (tamanho != null && alunos.size() + 1 > tamanho){
            throw new IllegalArgumentException("GRUPO CHEIO");
        }
        if (alunos.contains(matricula)) {
            throw new IllegalArgumentException("ALUNO JÁ ESTÁ NO GRUPO");
        }
        this.alunos.add(matricula);
    }

    
    /** 
     * @return String
     */
    public Integer getTamanho() {
        return tamanho;
    }

    
    /** 
     * @return String
     */
    public String getTema() {
        return tema;
    }
    
    
    /** 
     * checa se aluno já pertence ao grupo.
     * 
     * @param matricula
     * @return boolean
     */
    public boolean hasAluno(String matricula) {
        return alunos.contains(matricula);
    }

    private String capitalizeTema() {
        return this.tema.substring(0, 1).toUpperCase() + this.tema.substring(1);
    }
    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return this.capitalizeTema() + " " + alunos.size() + "/" + (tamanho != null ? this.getTamanho() : "∞");
    }
}
