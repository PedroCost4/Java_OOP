package Classes;

public class Contato {
    private String nome;
    private String sobrenome;
    private String telefone;
    private boolean favorito;


    public Contato(String nome, String sobrenome, String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
    }

    public Contato (String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public String getNome() {
        return this.nome;
    }

    public String getSobrenome() {
        return this.sobrenome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public boolean isFavorito() {
        return this.favorito;
    }

    @Override
    public String toString() {
        return String.format("%s %s\n%s", this.nome, this.sobrenome, this.telefone);
    }
} 