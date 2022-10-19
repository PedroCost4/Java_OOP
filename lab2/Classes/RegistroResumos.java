package Classes;


public class RegistroResumos {
    private int numeroMaxResumos;
    private int ContadorRegistros = 0;
    private Registro[] Resumos;
    private boolean TemResumo;
    private Registro Registro;
    private String[] searchedResumo;

    public RegistroResumos(int numeroMaxResumos) {
        this.numeroMaxResumos = numeroMaxResumos;
        this.Resumos = new Registro[numeroMaxResumos];
    }

    
    /** 
     * @return Registro[]
     */
    public Registro[] pegaResumos() {
        return Resumos;
    }

    
    /** 
     * @return int
     */
    public int conta() {
        return ContadorRegistros;
    }

    
    /** 
     * @return String
     */
    public String imprimeResumos() {
        String Auxiliar = "";
        Auxiliar += String.format("- %d resumo(s) cadastrado(s)\n- ", ContadorRegistros);
        for (int i = 0; i < ContadorRegistros-1; i++) {
            Auxiliar += Resumos[i].getTema() + " | ";
        }
        Auxiliar += Resumos[ContadorRegistros-1].getTema();
        return Auxiliar;
    }

    
    /** 
     * @param tema
     * @param resumos
     */
    public void adiciona(String tema, String resumos) {
        ContadorRegistros = (ContadorRegistros == numeroMaxResumos) ? 0 : ContadorRegistros;
        Registro = new Registro(tema, resumos);
        Resumos[ContadorRegistros] = Registro;
        ContadorRegistros++;
    }

    
    /** 
     * @param tema
     * @return boolean
     */
    public boolean temResumo(String tema) {
        TemResumo = false;
        for (int i = 0; i < ContadorRegistros-1; i++) {
            TemResumo = (Resumos[i].getTema() == tema);
        }
        return TemResumo;
    }

    public String[] busca(String chaveDeBusca) {
        searchedResumo = new String[ContadorRegistros];
        for (int i = 0; i < ContadorRegistros; i++) {
            if (Resumos[i].getResumo().contains(chaveDeBusca)) {
                searchedResumo[i] = Resumos[i].getTema();
            }
        } 

        return searchedResumo;
    }
}