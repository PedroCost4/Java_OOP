package Classes;

import java.util.Arrays;

public class Disciplina {
    String nomeDisciplina;
    int horas;
    double[] notas = new double[4];
    double mediaNotas;


    public Disciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    /** 
     * @param horas
     */
    public void cadastraHoras(int horas) {
        this.horas = horas;
    }

    
    /** 
     * @param nota
     * @param valorNota
     */
    public void cadastraNota(int nota, double valorNota) {
        this.notas[nota-1] = valorNota;
    }

    
    /** 
     * @return boolean
     */
    public boolean aprovado() {
        this.mediaNotas = (Arrays.stream(notas).sum()) / notas.length;
        return mediaNotas >= 7;
    }

    
    /** 
     * @return String
     */
    public String toString() {
        return String.format("%s %d %.1f %s" , nomeDisciplina, horas, mediaNotas, Arrays.toString(notas));
    }
}

