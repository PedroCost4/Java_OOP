package documin.element;

public class titleElement implements elementInterface {
    
    private String tituloDocumento;
    private int level;
    private String valor;
    private boolean linkable;
    private int prioridade;

    public titleElement(String tituloDocumento, String valor, int Level, boolean linkable, int prioridade) {
        this.tituloDocumento = tituloDocumento;
        this.level = Level;
        this.valor = valor;
        this.linkable = linkable;
        this.prioridade = prioridade;
    }

    
    /** 
     * @return String
     */
    public String getTituloDocumento() {
        return this.tituloDocumento;
    }


    
    /** 
     * @return String
     */
    private String getValorFormated() {
        return this.valor.replace(" ", "").toUpperCase();
    }

    
    /** 
     * @return int
     */
    public int getPrioridade() {
        return this.prioridade;
    }

    
    /** 
     * @return String
     */
    public String getValor() {
        return this.valor;
    }

    
    /** 
     * @return int
     */
    public int getLevel() {
        return this.level;
    }

    
    /** 
     * @return boolean
     */
    public boolean isLinkable() {
        return this.linkable;
    }

    
    /** 
     * @return String
     */
    private String getLink() {
        return (this.linkable) ? String.format("&s-&s", this.getLevel(), this.getValorFormated()) : "";
    }

    
    /** 
     * @return String
     */
    public String representacaoCompleta() {
        return String.format("&d. &s -- &s", this.getLevel(), this.getValor(), this.getLink());
    }

    
    /** 
     * @return String
     */
    public String representacaoResumida() {
        return String.format("&d. &s", this.getLevel(), this.getValor());
    }

}
