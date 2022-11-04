package Classes;

/**
 * Um contato com nome, sobrenome e telefone e se ele está favoritado.
 * 
 * @author pedro.henrique.costa
 *
 */
public class Contato {
    private String nome;
    private String sobrenome;
    private String telefone;
    private boolean favorito;

    /*
     * Constrói um contato com nome, sobrenome e telefone.
     * 
     */
    public Contato(String nome, String sobrenome, String telefone) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
    }
    /*
     * Constrói um contato com nome e telefone.
     * 
     */
    public Contato (String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    
    /** 
     * define o boolean se é favorito ou não
     * 
     * @param favorito
     */
    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    
    /** 
     * define o nome do contato
     * 
     * @return String
     */
    public String getNome() {
        return this.nome;
    }

    
    /** 
     * define o sobrenome do contato
     * 
     * @return String
     */
    public String getSobrenome() {
        return this.sobrenome;
    }

    
    /** 
     * define o telefone do contato
     * 
     * @return String
     */
    public String getTelefone() {
        return this.telefone;
    }

    
    /** 
     * checa se o contato é favorito ou não.
     * 
     * @return boolean
     */
    public boolean isFavorito() {
        return this.favorito;
    }

    
    /** 
     * toString do contato
     * 
     * @return String
     */
    @Override
    public String toString() {
        return String.format("%s %s\n%s", this.nome, this.sobrenome, this.telefone);
    }
} 