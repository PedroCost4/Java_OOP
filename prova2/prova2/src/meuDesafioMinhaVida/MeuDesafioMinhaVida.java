package meuDesafioMinhaVida;

import meuDesafioMinhaVida.acoes.AcaoController;
import meuDesafioMinhaVida.desafios.DesafioController;

public class MeuDesafioMinhaVida{
    
    DesafioController desafioController;
    AcaoController acaoController;

    public MeuDesafioMinhaVida () {
        this.desafioController = new DesafioController();
        this.acaoController = new AcaoController();
    }

    public void adicionaAcao(int idAcao, String dataCriacao, int idDesafio) {
        String tituloDesafio = this.desafioController.getDesafio(idDesafio).getTitulo();
        this.acaoController.adicionaAcao(idAcao, tituloDesafio, dataCriacao);
    }

    public void adicionaDesafio(String titulo, String desc) {
        this.desafioController.adicionaDesafio(titulo, desc);
    }

    public int adicionaDesafio(String titulo) {
        return this.desafioController.adicionaDesafio(titulo);
    }

    public String exibeDesafio(int id) {
        return this.desafioController.exibirDesafio(id);
    }

    public String listarAcoes() {
        return this.acaoController.listarAcoes();
    }

    public void adicionarAcaoDesafio(int idDesafio, int idAcao) {
        this.desafioController.adicionaAcao(idDesafio, idAcao, this.acaoController.getAcao(idAcao));
    }

    public void atualizaProgresso(int idDesafio, int idAcao, int progresso) {
        this.desafioController.atualizaProgresso(idDesafio, idAcao, progresso);
    }

    public void atualizaProgressoAcao(int idAcao, int progresso) {
        this.acaoController.atualizaProgresso(idAcao, progresso);
    }
}
