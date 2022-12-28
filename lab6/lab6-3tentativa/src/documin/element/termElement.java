package documin.element;

import java.util.Arrays;
import java.util.Comparator;

public class termElement implements elementInterface {

    private String tituloDocumento;
    private String separator;
    private String valor;
    private String ordem;
    private int prioridade;

    public termElement(String tituloDocumento, String valor,  String separator, String ordem, int prioridade) {
        this.tituloDocumento = tituloDocumento;
        this.separator = separator;
        this.valor = valor;
        this.ordem = ordem;
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
    public String getSeparator() {
        return separator;
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
    public String getOrdem() {
        return ordem;
    }

    
    /** 
     * @return String
     */
    private String processarOrdemRepCompleta() {
        String[] valores = this.getValor().split(this.getSeparator());
        if (this.ordem.equalsIgnoreCase("ALFABÉTICA")) {
            Arrays.sort(valores);
            return String.format("Total termos: %d\n- %s", valores.length, String.join(",", valores));
        }
        else if (this.ordem.equalsIgnoreCase("TAMANHO")) {
            Arrays.sort(valores, Comparator.comparingInt(String::length));
            return String.format("Total termos: %d\n- %s", valores.length, String.join(",", valores));
        }
        else {
            return String.format("Total termos: %d\n- %s", valores.length, String.join(",", valores));
        }
    }

    
    /** 
     * @return String
     */
    public String representacaoCompleta() {
        return processarOrdemRepCompleta();
    }

    
    /** 
     * @return String
     */
    public String representacaoResumida() {
        return this.getValor();
    }


}

