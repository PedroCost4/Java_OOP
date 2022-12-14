package documin.elementos.elementTypes;

import documin.elementos.elementAbstract;
import java.util.Arrays;
import java.util.Comparator;

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

    public String representacaoCompleta() {
        return processarOrdemRepCompleta();
    }

    public String representacaoResumida() {
        return this.getValor();
    }


}
