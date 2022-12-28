package documin.elementos.elementTypes;

import documin.elementos.elementAbstract;

public class listElement extends elementAbstract {
    
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

    public String getValor() {
        return valor;
    }

    public String getTituloDocumento() {
        return tituloDocumento;
    }

    private String processarValorRepCompleta() {
        String[] valores = this.getValor().split(this.getSeparator());
        String retorno = "";
        for (String valor : valores) {
            retorno += this.getCaractereDeLista() + " " + valor + "\n";
        }
        return retorno;
    }

    private String processarValorRepResumida() {
        String[] valores = this.getValor().split(this.getSeparator());
        String retorno = "";
        for (String valor : valores) {
            retorno += valor + ", ";
        }
        return retorno;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public String getSeparator() {
        return separator;
    }

    public String getCaractereDeLista() {
        return caractereDeLista;
    }

    public String representacaoCompleta() {
        return this.processarValorRepCompleta();
    }

    public String representacaoResumida() {
        return this.processarValorRepResumida();
    }
}
