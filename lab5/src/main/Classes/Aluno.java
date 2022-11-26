package Classes;

/**
 * Um aluno que contém informações sobre sua matrícula, nome e curso do aluno.
 * 
 * @author pedro.henrique.costa
 *
 */
public class Aluno {
    
    private String matricula;
    private String nome;
    private String curso;

    /**
     * Constrói um aluno a partir de sua matrícula, nome e curso.
     * 
     * @param matricula
     * @param nome
     * @param curso
     */
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
     * Cria uma String com as informações do aluno.
     * @return String
     */
    @Override
    public String toString() {
        return this.getNome() + " - " + this.getCurso();
    }
}

