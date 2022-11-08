package main;

public class LULA {
    
    private LocalVisitacao[] locais;
    private Comitiva[] comitivas;

    public LULA() {
        this.locais = new LocalVisitacao[100];
        this.comitivas = new Comitiva[100];
    }

    public LocalVisitacao[] getLocais() {
        return this.locais;
    }

    public Comitiva[] getComitivas() {
        return this.comitivas;
    }

    public void cadastraLocal(String idUnico, String local, String ramal) {
        EntradasInvalidasExceptions.entradasInvalidasLocais(this.locais, idUnico, local, ramal);

        for (int i = 0; i < this.locais.length; i++) {
            if (this.locais[i] == null) {
                this.locais[i] = new LocalVisitacao(idUnico, local, ramal);
                break;
            }
        }
    }

    public void cadastraComitiva(int id, String descricaoComitiva, int numIntegrantes, String contato) {
        EntradasInvalidasExceptions.entradasInvalidasComitivas(this.comitivas, id, descricaoComitiva, numIntegrantes, contato);
        this.comitivas[id] = new Comitiva(id, descricaoComitiva, numIntegrantes, contato);
    }

    public String exibeLocal(String idUnico) {
        EntradasInvalidasExceptions.entradasInvalidasExibeLocais(this.locais, idUnico);

        String locaisString = "";
        for (LocalVisitacao local : locais) {
            if (local != null && local.getIdUnico().equals(idUnico)) {
                locaisString += local.toString();
            }
        }
        return locaisString;
    }

    public String exibeComitiva(int id) {
        EntradasInvalidasExceptions.entradasInvalidasExibeComitivas(this.comitivas, id);

        String comitivaString = "";
        for (Comitiva comitiva : comitivas) {
            if (comitiva != null && comitiva.getId() == id) {
                comitivaString += comitiva.toString();
            }
        }
        return comitivaString;
    }

    
    
}
