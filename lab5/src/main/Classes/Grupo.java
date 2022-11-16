package Classes;

import java.util.HashMap;

public class Grupo {
    
    private HashMap<String, Aluno> alunos; 
    private Integer tamanho;
    private String tema;

    public Grupo(String tema, Integer tamanho) {
        this.alunos = new HashMap<String,Aluno>();
        this.tamanho = (tamanho == null) ? 0 : tamanho;
        this.tema = tema;
    }

    
    /** 
     * @return HashMap<String, Aluno>
     */
    public HashMap<String, Aluno> getAlunos() {
        return alunos;
    }

    
    /** 
     * @param aluno
     */
    public void addAluno(Aluno aluno) {
        this.alunos.put(aluno.getMatricula(), aluno);
    }

    
    /** 
     * @return Integer
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
        return alunos.containsKey(matricula);
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
