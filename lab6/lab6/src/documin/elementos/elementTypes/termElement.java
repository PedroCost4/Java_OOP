package documin.elementos.elementTypes;

import documin.elementos.elementAbstract;

public class termElement extends elementAbstract {

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

    public String getValor() {
        return valor;
    }

    public String getTituloDocumento() {
        return tituloDocumento;
    }

    public String getSeparator() {
        return separator;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public String getOrdem() {
        return ordem;
    }

    public String representacaoCompleta() {
        return "";
    }

    public String representacaoResumida() {
        return "";
    }

}
