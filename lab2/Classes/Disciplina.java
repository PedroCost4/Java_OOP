package Classes;

import java.util.Arrays;
import java.text.MessageFormat;

public class Disciplina {
    String nomeDisciplina;
    int horas;
    double[] notas = new double[4];
    double mediaNotas;

    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public void cadastraHoras(int horas) {
        this.horas = horas;
    }

    public void cadastraNota(int nota, double valorNota) {
        this.notas[nota-1] = valorNota;
    }

    public boolean aprovado() {
        this.mediaNotas = (Arrays.stream(notas).sum()) / notas.length;
        return mediaNotas >= 7;
    }

    public String toString() {
        return (MessageFormat.format("Nome da Disciplina: {0}.\nHoras de estudo: {1}.\nNotas do aluno: {2}.",
                this.nomeDisciplina, this.horas, this.mediaNotas));
    }
}
