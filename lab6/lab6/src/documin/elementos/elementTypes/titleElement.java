package documin.elementos.elementTypes;

import documin.elementos.elementAbstract;

public class titleElement extends elementAbstract {
    
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

    public String getTituloDocumento() {
        return tituloDocumento;
    }


    private String getValorFormated() {
        return valor.replace(" ", "").toUpperCase();
    }

    public int getPrioridade() {
        return prioridade;
    }

    public String getValor() {
        return valor;
    }

    public int getLevel() {
        return level;
    }

    public boolean isLinkable() {
        return linkable;
    }

    public String getLink() {
        return (linkable) ? String.format("&s-&s", this.getLevel(), this.getValorFormated()) : "";
    }

    public String representacaoCompleta() {
        return String.format("&d. &s -- &s", this.getLevel(), this.getValor(), this.getLink());
    }

    public String representacaoResumida() {
        return String.format("&d. &s", this.getLevel(), this.getValor());
    }

}