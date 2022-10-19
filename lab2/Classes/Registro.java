package Classes;

public class Registro {
    private String Tema;
    private String Resumo;

    public Registro(String tema, String Resumo) {
        this.Tema = tema;
        this.Resumo = Resumo;
    }

    
    /** 
     * @return String
     */
    public String getTema() {
        return this.Tema;
    }

    
    /** 
     * @return String
     */
    public String getResumo() { 
        return this.Resumo;
    }
}