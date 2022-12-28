package documin.models.elemenTypes;

import documin.interfaces.elementInterface;

public class listElement implements elementInterface {
    
    private String tituloDocumento;
    private String separator;
    private String valor;
    private String caractereDeLista;
    private int prioridade;

    public listElement(String tituloDocumento, String valor, String separator, String caractereDeLista, int prioridade) {
        this.tituloDocumento = tituloDocumento;
        this.valor = valor;
        this.separator = separator;
        this.caractereDeLista = caractereDeLista;
        this.prioridade = prioridade;
    }

    
    /** 
     * @return String
     */
    public String getValor() {
        return valor;
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
    private String processarValorRepCompleta() {
        String[] valores = this.getValor().split(this.getSeparator());
        String retorno = "";
        for (String valor : valores) {
            retorno += this.getCaractereDeLista() + " " + valor + "\n";
        }
        return retorno;
    }

    
    /** 
     * @return String
     */
    private String processarValorRepResumida() {
        String[] valores = this.getValor().split(this.getSeparator());
        String retorno = "";
        for (String valor : valores) {
            retorno += valor + ", ";
        }
        return retorno;
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
    public String getSeparator() {
        return separator;
    }

    
    /** 
     * @return String
     */
    public String getCaractereDeLista() {
        return caractereDeLista;
    }

    
    /** 
     * @return String
     */
    public String representacaoCompleta() {
        return this.processarValorRepCompleta();
    }

    
    /** 
     * @return String
     */
    public String representacaoResumida() {
        return this.processarValorRepResumida();
    }
}
