package meuDesafioMinhaVida.desafios;

import java.util.HashMap;
import meuDesafioMinhaVida.acoes.Acao;

public class Desafio {

    private int id;
    private String titulo;
    private String descricao;
    private int execucoes;
    private HashMap < Integer, Acao> acaoMap; 
    
    public Desafio(int id, String titulo, String desc) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = desc;
        this.execucoes = 0;
        this.acaoMap = new HashMap < Integer, Acao > ();
    }

    public Desafio(int id, String titulo) {
        this.id = id;
        this.titulo = titulo;
        this.execucoes = 0;
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

    public HashMap < Integer, Acao > getAcaoMap() {
        return this.acaoMap;
    }

    public void adicionaAcao(int id, Acao acao) {
        this.acaoMap.put(id, acao);
    }

    public void getAcao (int id) {
        this.acaoMap.get(id);
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void adicionaExecucao() {
        this.execucoes++;
    }

    public void atualizaProgresso(int idAcao, int progresso) {
        this.acaoMap.get(idAcao).atualizaProgresso(progresso);
    }

    public int getProgressoAcao(int idAcao) {
        return this.acaoMap.get(idAcao).getProgresso();
    }

    @Override
    public String toString() {
        return String.format("Titulo: %s\n%d execuções", this.titulo, this.execucoes);
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

        if (obj instanceof Desafio) {
            Desafio desafio = (Desafio) obj;
            return desafio.getTitulo().equals(this.getTitulo());
        }

        return false;
    }

}
