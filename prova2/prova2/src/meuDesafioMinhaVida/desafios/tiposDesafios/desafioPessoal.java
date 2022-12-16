package meuDesafioMinhaVida.desafios.tiposDesafios;

import meuDesafioMinhaVida.desafios.desafio;

public class desafioPessoal extends desafio implements desafioInteface{
    
    public desafioPessoal(int id, String titulo, String desc) {
        super(id, titulo, desc);
        super.setTipo("Pessoal");
        super.setSatisfacao(0);
    }

    public desafioPessoal(int id, String titulo) {
        super(id, titulo);
        super.setTipo("Pessoal");
        super.setSatisfacao(0);
    }

    public void aumentaSatisfacao() {
        super.setSatisfacao(10);
    }

    @Override
    public void finalizaAcao() {
        super.adicionaExecucao();
        this.aumentaSatisfacao();
    }

}
