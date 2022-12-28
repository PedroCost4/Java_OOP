package documin.elementos.elementTypes;

import documin.elementos.elementAbstract;

public class textElement extends elementAbstract {
    
    private String tituloDocumento;
    private String valor;
    private int prioridade;


    public textElement(String tituloDocumento, String valor, int prioridade) {
        this.tituloDocumento = tituloDocumento;
        this.valor = valor;
        this.prioridade = prioridade;
    }

    public String getTituloDocumento() {
        return tituloDocumento;
    }

    public String getValor() {
        return valor;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public String representacaoCompleta() {
        return this.getValor();
    }

    public String representacaoResumida() {
        return this.getValor();
    }

}

