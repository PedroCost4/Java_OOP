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

    public void cadastrarAluno(String nome, String matricula, String curso) {
        if (matricula.isBlank() || nome.isBlank() || curso.isBlank()) {
            throw new IllegalArgumentException("ALGUMA ENTRADA VAZIA");
        }
        if (alunos.containsKey(matricula)) {
            throw new IllegalArgumentException("MATRÍCULA JÁ CADASTRADA");
        }
        

        Aluno aluno = new Aluno(nome, curso);
        alunos.put(matricula, aluno);
    }

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

    public void addAlunoEmGrupo(String tema, String matricula, String curso) {
        
        for (Grupo grupo: grupos) {
            if (grupo.getTema().equals(tema)) {
                grupo.addAluno(tema, matricula, curso);
            }
        }
        
        
    }

    public String exibirAluno(String matricula) {
        return "Aluno: " + matricula + " " + alunos.get(matricula).toString();
    }

    public boolean hasAlunoInGrupo(String tema, String matricula) {
        for (Grupo grupo: grupos) {
            if (grupo.getTema().equals(tema)) {
                return grupo.hasAluno(matricula);
            }
        }
        return false;
    }

    }