package meuDesafioMinhaVida.desafios.tiposDesafios;

import meuDesafioMinhaVida.desafios.desafio;

public class desafioSocial extends desafio implements desafioInteface{
    
    private int pessoasAtingidas;

    public desafioSocial(int id, String titulo, String desc, int pessoasAtingidas) {
        super(id, titulo, desc);
        super.setTipo("Social");
        super.setSatisfacao(0);
        this.pessoasAtingidas = pessoasAtingidas;
    }

    public desafioSocial(int id, String titulo, int pessoasAtingidas) {
        super(id, titulo);
        super.setTipo("Social");
        super.setSatisfacao(0);
        this.pessoasAtingidas = pessoasAtingidas;
    }

    public int getpessoasAtingidas() {
        return this.pessoasAtingidas;
    }

    public void aumentaSatisfacao() {
        if (pessoasAtingidas > 10 && pessoasAtingidas < 50) {
            super.setSatisfacao(20);
        } 
        else if (pessoasAtingidas > 50 && pessoasAtingidas < 100) {
            super.setSatisfacao(50);;
        } 
        else if (pessoasAtingidas > 100) {
            super.setSatisfacao(pessoasAtingidas);
        }
    }

    @Override
    public void finalizaAcao() {
        super.adicionaExecucao();
        this.aumentaSatisfacao();
    }
}
