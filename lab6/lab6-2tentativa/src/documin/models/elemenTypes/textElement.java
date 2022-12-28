package documin.models.elemenTypes;

import documin.interfaces.elementInterface;

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
        return tituloDocumento;
    }

    
    /** 
     * @return String
     */
    public String getValor() {
        return valor;
    }

    
    /** 
     * @return int
     */
    public int getPrioridade() {
        return prioridade;
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
