package Classes;

/**
 * Representação de um Descanso de um aluno e se ele está cansado ou desnansado.
 *
 * @author Pedro Henrique Almeida Costa
 */

public class Descanso {
    private int horasDescansadas = 0;
    private String status = "Cansado";
    private int numeroSemanas = 0;

    
    /**
    * Define a quantidade horas descansadas pelo aluno.
    */
    public void defineHorasDescanso(int valor) {
        this.horasDescansadas = valor;
    }

    
    /** 
     * Define o numero de semanas estudadas pelo aluno.
     * 
     * @param valor
     */
    public void defineNumeroSemanas(int valor) {
        this.numeroSemanas = valor;
    }

    
    /** Retorna o estado atual do aluno, se "cansado" ou "descansado".
     * 
     * @return String
     */
    public String getStatusGeral() {
        
        if (numeroSemanas >= 1 && (horasDescansadas / numeroSemanas) >= 26) {
            this.status = "Descansado";
        } else{
            this.status = "Cansado";
        }
        return status;
    }
}