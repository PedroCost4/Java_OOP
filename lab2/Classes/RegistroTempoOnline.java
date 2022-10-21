package Classes;

/**
 * Representação de um registro de tempo online de estudo de uma disciplina
 *
 * @author Pedro Henrique Almeida Costa
 */
public class RegistroTempoOnline {
    private int TempoOnline = 0;
    private String nomeDisciplina;
    private int TempoOnlineEsperado = 120;

    /**
    * Constrói um registro a partir do nome da disciplina
    *
    * @param nome_disci nome da disciplina
    */
    public RegistroTempoOnline(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    /**
    * Constrói um registro de tempo online na disciplina.
    *   *
    * @param nomeDisciplina nome da disciplina
    * @param TempoOnlineEsperado tempo online para atingir a meta
    */
    public RegistroTempoOnline(String nomeDisciplina, int tempoOnlineEsperado) {
        this.nomeDisciplina = nomeDisciplina;
        this.TempoOnlineEsperado = tempoOnlineEsperado;
    }

    
    /** 
     * Adiciona o tempo online do aluno.
     * 
     * @param tempo tempo que o aluno está online
     */
    public void adicionaTempoOnline(int tempo) {
        this.TempoOnline += tempo;
    }

    
    /** 
     * Verifica se o aluno atingiu a meta.
     * 
     * @return boolean se atingiu ou nâo a meta
     */
    public boolean atingiuMetaTempoOnline() {
        if (TempoOnline >= TempoOnlineEsperado)  {
            return true;
        }else {
            return false;
        }
    }

    
    /** 
     * Retorna a string com os dados da disciplina
     * 
     * @return String 
     * "nome da disciplina" tempoonline / tempoonline esperado
     */
    public String toString() {
        return String.format("%s %d / %d", nomeDisciplina, TempoOnline , TempoOnlineEsperado);
    }
}