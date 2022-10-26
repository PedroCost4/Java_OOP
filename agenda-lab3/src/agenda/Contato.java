package agenda;

public class Contato {
    private String nome;
    public String sobrenome;
    public String telefone;


    public Contato(String nome, String sobrenome, String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
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

    @Override
    public String toString() {
        return String.format("%s %s\n%s", this.nome, this.sobrenome, this.telefone);
    }
} 