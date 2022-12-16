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

    public void adicionaAcao(int idAcao, String dataCriacao, String tituloDesafio) {
        this.acaoController.adicionaAcao(idAcao, tituloDesafio, dataCriacao);
    }

    public void adicionaDesafio(String titulo, String desc) {
        this.desafioController.adicionaDesafio(titulo, desc);
    }

    public void adicionaDesafio(String titulo) {
        this.desafioController.adicionaDesafio(titulo);
    }

    public void adicionaDesafioMaterial(String titulo, String desc, int valor) {
        this.desafioController.adicionaDesafioMaterial(titulo, desc, valor);
    }

    public void adicionaDesafioMaterial(String titulo, int valor) {
        this.desafioController.adicionaDesafioMaterial(titulo, valor);
    }

    public void adicionaDesafioSocial(String titulo, String desc, int pessoasAtingidas) {
        this.desafioController.adicionaDesafioSocial(titulo, desc, pessoasAtingidas);
    }

    public void adicionaDesafioSocial(String titulo, int pessoasAtingidas) {
        this.desafioController.adicionaDesafioSocial(titulo, pessoasAtingidas);
    }

    public String listarAcoes() {
        return this.acaoController.listarAcoes();
    }

    public int pegarSatisfacao(String tituloDesafio) {
        return this.desafioController.getSatisfacao(tituloDesafio);
    }

    public void atualizaProgressoAcao(int idAcao, int progresso) {
        int prog = this.acaoController.atualizaProgresso(idAcao, progresso);
        String tituloDesafio = this.acaoController.getAcao(idAcao).getTituloDesafio();

        if (prog >= 100) {
            this.desafioController.adicionaExecucao(tituloDesafio);
        }
    }

    public void atualizaProgressoAcao(int idAcao) {
        int prog = this.acaoController.atualizaProgresso(idAcao, 10);
        String tituloDesafio = this.acaoController.getAcao(idAcao).getTituloDesafio();

        if (prog >= 100) {
            this.desafioController.adicionaExecucao(tituloDesafio);
        }
    }

    public String exibeDesafio(String tituloDesafio) {
        return this.desafioController.exibirDesafio(tituloDesafio);
    }



    
}
