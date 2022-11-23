package Classes;

import java.util.HashSet;

public class Grupo {
    
    private HashSet<String> alunos; 
    private Integer tamanho;
    private String tema;

    public Grupo(String tema, Integer tamanho) {
        this.alunos = new HashSet<String>();
        this.tamanho = tamanho;
        this.tema = tema;
    }

    
    /** 
     * @return HashMap<String, Aluno>
     */
    public HashSet<String> getAlunos() {
        return alunos;
    }

    
    /** 
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
     * @param matricula
     * @return boolean
     */
    public boolean hasAluno(String matricula) {
        return alunos.contains(matricula);
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return this.getTema() + " " + alunos.size() + "/" + (tamanho != null ? this.getTamanho() : "∞");
    }
    
    /** 
     * @param obj
     * @return boolean
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Grupo) {
            Grupo grupo = (Grupo) obj;
            return this.tema.equals(grupo.getTema());
        }
        return false;
    }

    
    /** 
     * @return int
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + tema.hashCode();
        return result;
    }

}
