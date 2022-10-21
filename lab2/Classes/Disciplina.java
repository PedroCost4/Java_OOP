package Classes;

import java.util.Arrays;

/**
 * Representação de uma Disciplina de um aluno.
 *
 * @author Pedro Henrique Almeida Costa
 */
public class Disciplina {
    private String nome_disciplina;
    private int horas;
    private double[] notas = new double[4];

    /**
    * Constrói uma disciplina a partir de seu nome.
    *
    * @param nome_disci nome da disciplina
    */
    public Disciplina(String nome_disci) {
        this.nome_disciplina = nome_disci;
    }

    /** Define as horas de estudo cadastradas.
     * 
     * @param horas
     */
    public void cadastraHoras(int horas) {
        this.horas = horas;
    }

    
    /** 
     * Define a notas da disciplina em um array array.
     * 
     * @param nota
     * @param valorNota
     */
    public void cadastraNota(int nota, double valorNota) {
        this.notas[nota-1] = valorNota;
    }

    
    /**Calcula se o aluno está aprovado ou não, considerando se a nota está maior que 7 ou não. 
     * 
     * @return boolean
     */
    public boolean aprovado() {
        double mediaNotas = calculaMedia();
        return mediaNotas >= 7;
    }

    private double calculaMedia() {
        return (Arrays.stream(notas).sum()) / notas.length;
    }
    
    /** Retorna os dados do objeto no formato.
     * 
     * "noma da disciplina" horascursadas mediadasnotas [array de notas] 
     * 
     * @return String
     */
    public String toString() {
        return String.format("%s %d %.1f %s" , nome_disciplina, horas, calculaMedia(), Arrays.toString(notas));
    }
}

