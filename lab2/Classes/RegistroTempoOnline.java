package Classes;

public class RegistroTempoOnline {
    private int TempoOnline = 0;
    private boolean metaAtingida = false;
    private String nomeDisciplina;
    private int TempoOnlineEsperado = 120;

    public RegistroTempoOnline(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
        this.nomeDisciplina = nomeDisciplina;
        this.TempoOnlineEsperado = tempoOnlineEsperado;
    }

    
    /** 
     * @param tempo
     */
    public void adicionaTempoOnline(int tempo) {
        this.TempoOnline += tempo;
    }

    
    /** 
     * @return boolean
     */
    public boolean atingiuMetaTempoOnline() {
        if (TempoOnline >= TempoOnlineEsperado)  {
            this.metaAtingida = true;
        }else {
            this.metaAtingida = false;
        }
        return metaAtingida;
    }

    
    /** 
     * @return String
     */
    public String toString() {
        return String.format("%s %d / %d", nomeDisciplina, TempoOnline , TempoOnlineEsperado);
    }
}