package documin.models;

public class document {
    
    private String titulo;
    private Integer tamanho;

    public document(String titulo, Integer tamanho) {
        this.titulo = titulo;
        this.tamanho = tamanho;
    }

    public document(String titulo) {
        this.titulo = titulo;
        this.tamanho = null;
    }

    
    /** 
     * @return String
     */
    public String getTitulo() {
        return titulo;
    }

    
    /** 
     * @return int
     */
    public int getTamanho() {
        return tamanho;
    }

    
    /** 
     * @param tamanho
     */
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
}
