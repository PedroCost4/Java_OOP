package meuDesafioMinhaVida.desafios.tiposDesafios;

import meuDesafioMinhaVida.desafios.Desafio;

public class desafioMaterial extends Desafio {
    
    private int valor;

    public desafioMaterial(int id, String titulo, String desc, int valor) {
        super(id, titulo, desc);
        super.setTipo("Material");
        this.valor = valor;
    }

    public desafioMaterial(int id, String titulo, int valor) {
        super(id, titulo);
        super.setTipo("Material");
        this.valor = valor;
    }

    public int getValor() {
        return this.valor;
    }

    public void aumentaSatisfacao() { 
        super.setSatisfacao(this.valor/10);
    }

    @Override
    public void finalizaAcao() {
        super.adicionaExecucao();
        this.aumentaSatisfacao();
    }

}
