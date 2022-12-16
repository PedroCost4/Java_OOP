package meuDesafioMinhaVida.desafios;

public class desafio {

    private int id;
    private String titulo;
    private String descricao;
    private int execucoes;
    private String tipo;
    private int satisfacao;
    
    public desafio(int id, String titulo, String desc) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = desc;
        this.satisfacao = 0;
        this.execucoes = 0;
    }

    public desafio(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.satisfacao = 0;
        this.execucoes = 0;
    }

    public String getTipo() {
        return this.tipo;
    }

    protected void setSatisfacao(int satisfacao) {
        this.satisfacao = satisfacao;
    }

    protected void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getSatisfacao() {
        return this.satisfacao;
    }

    public int getId() {
        return this.id;
    }

    public String getTitulo () {
        return this.titulo;
    }

    public int getExecucoes() {
        return this.execucoes;
    }

    public String getDescricao() {
        return this.descricao;
    }

    protected void adicionaExecucao() {
        this.execucoes ++;
    }

    public void finalizaAcao() {
        this.execucoes++;
    }

    @Override
    public String toString() {
        return String.format("Titulo: %s (%s)\n%d execuções", this.titulo, this.tipo, this.execucoes);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof desafio) {
            desafio desafio = (desafio) obj;
            return desafio.getTitulo().equals(this.getTitulo());
        }

        return false;
    }

}
