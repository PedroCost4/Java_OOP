package Classes;

public class Aluno {
    
    private String matricula;
    private String nome;
    private String curso;

    public Aluno(String matricula, String nome, String curso) {
        this.matricula = matricula;
        this.nome = nome;
        this.curso = curso;
    }

    
    /** 
     * @return String
     */
    public String getMatricula() {
        return matricula;
    }

    
    /** 
     * @return String
     */
    public String getNome() {
        return nome;
    }

    
    /** 
     * @return String
     */
    public String getCurso() {
        return curso;
    }

    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return getNome() + " - " + getCurso();
    }
}

