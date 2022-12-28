package documin.element;

import java.util.List;

import documin.document.document;

public class atalhoElement implements elementInterface {
    
    private String tituloDocumento;
    private String valor;
    private document document;
    private int prioridade;

    public atalhoElement(document document, int prioridade) {
        this.document = document;
        this.tituloDocumento = document.getTitulo();
        this.valor = document.getTitulo();
        this.prioridade = prioridade;
    }

    
    /** 
     * @return String
     */
    public String getTituloDocumento() {
        return tituloDocumento;
    };

    
    /** 
     * @return int
     */
    public int getPrioridade() {
        return prioridade;
    };

    
    /** 
     * @return document
     */
    public document getDocument() {
        return document;
    };

    
    /** 
     * @return String
     */
    public String getValor() {
        return valor;
    };

    
    /** 
     * @return String
     */
    public String representacaoCompleta() {
        return processarRepresentacao();
    };

    
    /** 
     * @return String
     */
    public String representacaoResumida() {
        return processarRepresentacao();
    };

    
    /** 
     * @return String
     */
    public String processarRepresentacao() {
        List<elementInterface> elements = document.getElementsByPriority();
        String result = "";
        for (elementInterface element : elements) {
            result += element.representacaoResumida();
        }
        return result;
    }

}
