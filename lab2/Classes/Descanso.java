package Classes;

public class Descanso {
    private int horasDescanso = 0;
    private String status = "Cansado";
    private int numeroSemanas = 0;

    
    /** 
     * @param valor
     */
    public void defineHorasDescanso(int valor) {
        this.horasDescanso = valor;
    }

    
    /** 
     * @param valor
     */
    public void defineNumeroSemanas(int valor) {
        this.numeroSemanas = valor;
    }

    
    /** 
     * @return String
     */
    public String getStatusGeral() {
        
        if (numeroSemanas >= 1 && (horasDescanso / numeroSemanas) >= 26) {
            this.status = "Descansado";
        } else{
            this.status = "Cansado";
        }
        return status;
    }
}