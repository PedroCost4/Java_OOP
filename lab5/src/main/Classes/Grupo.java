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

    public HashMap<String, Aluno> getAlunos() {
        return alunos;
    }

    public void addAluno(String matricula, String nome, String curso) {
        this.alunos.put(matricula, new Aluno(nome, curso));
    }

    public Integer getTamanho() {
        return tamanho;
    }

    public String getTema() {
        return tema;
    }
    
    public boolean hasAluno(String matricula) {
        return alunos.containsKey(matricula);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Grupo) {
            Grupo grupo = (Grupo) obj;
            return this.tema.equals(grupo.getTema());
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + tema.hashCode();
        return result;
    }

}
