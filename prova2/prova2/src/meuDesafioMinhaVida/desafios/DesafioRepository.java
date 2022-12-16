package meuDesafioMinhaVida.desafios;

import java.util.HashMap;
import meuDesafioMinhaVida.acoes.Acao;

public class DesafioRepository {
    
    private HashMap < Integer, Desafio > DesafioMap;

    public DesafioRepository() {
        this.DesafioMap = new HashMap < Integer, Desafio > ();
    }

    public void adicionaDesafio(Desafio Desafio) {
        this.DesafioMap.put(Desafio.getId(), Desafio);
    }

    public String listaDesafios() {
        String desafios = "";
        for (Desafio desafio : this.DesafioMap.values()) {
            desafios += desafio.toString() + "\n";
        }
        return desafios;
    }

    public Desafio getDesafio(int id) {
        return this.DesafioMap.get(id);
    }
    
    public HashMap < Integer, Desafio > getDesafioMap() {
        return this.DesafioMap;
    }

    public void adicionaExecucao(int id) {
        this.DesafioMap.get(id).adicionaExecucao();
    }

    public void adicionaAcao(int idDesafio, int id, Acao acao){
        this.DesafioMap.get(idDesafio).adicionaAcao(id, acao);
    }

    public String exibirDesafio( int id) {
        return this.DesafioMap.get(id).toString();
    }

    public void atualizaProgresso(int idDesafio, int idAcao, int Progresso) {
        this.DesafioMap.get(idDesafio).atualizaProgresso(idAcao, Progresso);
    }

    public int getProgessoAcao(int idDesafio, int idAcao) {
        return this.DesafioMap.get(idDesafio).getProgressoAcao(idAcao);
    }

}


