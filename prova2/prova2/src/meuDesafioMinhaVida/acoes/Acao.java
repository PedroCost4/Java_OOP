package meuDesafioMinhaVida.acoes;


public class Acao{
    
    private Integer id;
    private String tituloDesafio;
    public String dataCriacao;
    public int progresso; 

    public Acao(Integer id, String tituloDesafio, String dataCriacao) {
        this.id = id;
        this.tituloDesafio = tituloDesafio;
        this.dataCriacao = dataCriacao;
        this.progresso = 0;
    }

    public Integer getId() {
        return this.id;
    }

    public String getTituloDesafio () {
        return this.tituloDesafio;
    }

    public int getProgresso() {
        return this.progresso;
    }

    public String getDataCriacao() {
        return this.dataCriacao;
    }

    public void atualizaProgresso(int progresso) {
        this.progresso = progresso;
    }

    @Override
    public String toString() {
        return String.format("%d - %s - %s - Progresso %d", this.id, this.dataCriacao, this.tituloDesafio, this.progresso);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((tituloDesafio == null) ? 0 : tituloDesafio.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Acao) {
            Acao acao = (Acao) obj;
            return acao.getId().equals(this.getId());
        }

        return false;
    }
}




