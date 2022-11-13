package Classes;

public class Aluno {
    
    private String nome;
    private String curso;

    public Aluno( String nome, String curso) {
        this.nome = nome;
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }

    @Override
    public String toString() {
        return String.format("%s - %s",this.nome, this.curso);
    }
}

