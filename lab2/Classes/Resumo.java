package Classes;

/**
 * Classe para criar o objeto de resumo.
 *
 * @author Pedro Henrique Almeida Costa
 */
public class Resumo {
    private String tema;
    private String resumo;

    /**
    * Constrói um resumo a partir de seu tema e conteudo.
    *
    * @param tema 
    * @param resumo
    */
    public Resumo(String tema, String resumo) {
        this.tema = tema;
        this.resumo = resumo;
    }

    
    /** Retorna o tema do resumo
     * 
     * 
     * @return String
     */
    public String getTema() {
        return this.tema;
    }

    
    /** Retorna o conteúdo do resumo 
     * 
     * @return String
     */
    public String getResumo() { 
        return this.resumo;
    }
}