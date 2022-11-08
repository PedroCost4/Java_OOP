package main;

public class Comitiva {

    private int id;
    private String descricaoComitiva;
    private int numIntegrantes;
    private String contato;

    public Comitiva(int id, String descricaoComitiva, int numIntegrantes, String contato) {
        this.id = id;
        this.descricaoComitiva = descricaoComitiva;
        this.numIntegrantes = numIntegrantes;
        this.contato = contato;
    }

    public int getId() {
        return this.id;
    }

    public String getdescricaoComitiva() {
        return this.descricaoComitiva;
    }

    public void atualizaDescricao(String descricaoComitiva) {
        this.descricaoComitiva = descricaoComitiva;
    }

    public int getNumIntegrantes() {
        return this.numIntegrantes;
    }

    public String getContato() {
        return this.contato;
    }

    @Override   
    public String toString() {
        return String.format("ID: %s\nComitiva: %s\nIntegrantes: %d\nContato: %s",
        this.id, this.descricaoComitiva, this.numIntegrantes, this.contato);
    }
}