package main;

import java.util.ArrayList;

public class LocalVisitacao {
    
    private String idUnico;
    private String local;
    private String ramal;
    private int numVisitantes = 0;
    private ArrayList<Comitiva> comitivas;

    public LocalVisitacao(String idUnico, String local, String ramal) {
        this.idUnico = idUnico;
        this.local = local;
        this.ramal = ramal;
    }

    public String getIdUnico() {
        return this.idUnico;
    }

    public String getLocal() {
        return this.local;
    }

    public String getRamal() {
        return this.ramal;
    }

    public void adicionaVisitantes(int numVisitantes) {
        this.numVisitantes += numVisitantes;
    }

    public int getNumVisitantes() {
        return this.numVisitantes;
    }

    public void adicionaComitiva(Comitiva comitiva) {
        this.comitivas.add(comitiva);
    }

    public ArrayList<Comitiva> getComitivas() {
        return this.comitivas;
    }

    @Override
    public String toString() {
        return this.idUnico + " - " + this.local + " - " + this.ramal;
    }
}