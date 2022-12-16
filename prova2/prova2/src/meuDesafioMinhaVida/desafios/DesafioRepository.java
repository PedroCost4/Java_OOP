package meuDesafioMinhaVida.desafios;

import java.util.HashMap;

public class DesafioRepository {
    
    private HashMap < String, Desafio > DesafioMap;

    public DesafioRepository() {
        this.DesafioMap = new HashMap < String, Desafio > ();
    }

    public int tamanhoMap() {
        return this.DesafioMap.size();
    }

    public void adicionaDesafio(Desafio Desafio) {
        this.DesafioMap.put(Desafio.getTitulo(), Desafio);
    }

    public String listaDesafios() {
        String desafios = "";
        for (Desafio desafio : this.DesafioMap.values()) {
            desafios += desafio.toString() + "\n";
        }
        return desafios;
    }

    public Desafio getDesafio(String titulo) {
        return this.DesafioMap.get(titulo);
    }
    
    public HashMap < String, Desafio > getDesafioMap() {
        return this.DesafioMap;
    }

    public int adicionaExecucao(String titulo) {
        this.DesafioMap.get(titulo).finalizaAcao();
        return this.DesafioMap.get(titulo).getSatisfacao();
    }

    public String exibirDesafio( String titulo) {
        return this.DesafioMap.get(titulo).toString();
    }

}


