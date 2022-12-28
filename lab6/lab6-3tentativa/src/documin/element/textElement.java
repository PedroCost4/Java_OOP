package documin.element;

public class textElement implements elementInterface {
    
    private String tituloDocumento;
    private String valor;
    private int prioridade;


    public textElement(String tituloDocumento, String valor, int prioridade) {
        this.tituloDocumento = tituloDocumento;
        this.valor = valor;
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
    public String getValor() {
        return this.valor;
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
    public String representacaoCompleta() {
        return this.getValor();
    }

    
    /** 
     * @return String
     */
    public String representacaoResumida() {
        return this.getValor();
    }

}
