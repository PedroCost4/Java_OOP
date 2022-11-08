package main;

public class LocalVisitacao {
    
    private String idUnico;
    private String local;
    private String ramal;

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

    @Override
    public String toString() {
        return this.idUnico + " - " + this.local + " - " + this.ramal;
    }
}