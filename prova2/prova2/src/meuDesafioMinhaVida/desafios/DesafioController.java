package meuDesafioMinhaVida.desafios;

import meuDesafioMinhaVida.acoes.Acao;

public class DesafioController {
    
    private DesafioRepository desafioRepository;

    public DesafioController() {
        this.desafioRepository = new DesafioRepository();
    }

    public int adicionaDesafio (String titulo, String desc) {
        Desafio Desafio = new Desafio(this.desafioRepository.getDesafioMap().size() + 1, titulo, desc);
        this.desafioRepository.adicionaDesafio(Desafio);
        return this.desafioRepository.getDesafioMap().size();
    }

    public int adicionaDesafio (String titulo) {
        Desafio Desafio = new Desafio(this.desafioRepository.getDesafioMap().size() + 1, titulo);
        this.desafioRepository.adicionaDesafio(Desafio);
        return this.desafioRepository.getDesafioMap().size();
    }

    public String listarDesafios() {
        return this.desafioRepository.listaDesafios();
    }

    public Desafio getDesafio(int id) {
        return this.desafioRepository.getDesafio(id);
    }

    public void adicionaExecucao(int id) {
        this.desafioRepository.adicionaExecucao(id);
    }

    public String exibirDesafio(int id) {
        return this.desafioRepository.exibirDesafio(id);
    }

    public void adicionaAcao(int idDesafio, int idAcao, Acao Acao) {
        this.desafioRepository.adicionaAcao(idDesafio, idAcao, Acao);
    }

    public void atualizaProgresso(int idDesafio, int idAcao, int Progresso) {
        this.desafioRepository.atualizaProgresso(idDesafio, idAcao, Progresso);
        if (this.desafioRepository.getProgessoAcao(idDesafio, idAcao) == 100) {
            this.desafioRepository.getDesafio(idDesafio).adicionaExecucao();
        }
    }
}
