package documin.documentos;

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

    public String getTitulo() {
        return titulo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }
}
