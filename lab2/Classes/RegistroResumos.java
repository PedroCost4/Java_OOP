package Classes;

public class RegistroResumos {
    private int numeroMaxResumos;
    private String[] Tema;
    private String[] Resumos;
    private int ContadorRegistros = 0;
    private boolean TemResumo;

    public RegistroResumos(int numeroMaxResumos) {
        this.numeroMaxResumos = numeroMaxResumos;
        this.Tema = new String[numeroMaxResumos];
        this.Resumos = new String[numeroMaxResumos];
    }

    public String[] pegaResumos() {
        return Resumos;
    }

    public String imprimeResumos() {
        String Auxiliar = "";
        Auxiliar += String.format("- %d resumo(s) cadastrado(s)\n- ", ContadorRegistros);
        for (int i = 0; i < ContadorRegistros-1; i++) {
            Auxiliar += Tema[i] + " | ";
        }
        Auxiliar += Tema[ContadorRegistros-1];
        return Auxiliar;
    }

    public void adiciona(String tema, String resumos) {
        if (ContadorRegistros == numeroMaxResumos ){
            ContadorRegistros = 0;
        }
        Tema[ContadorRegistros] = tema;
        Resumos[ContadorRegistros] = tema + ": " + resumos ;
        ContadorRegistros++;
    }

    public boolean temResumo(String tema) {
        TemResumo = false;
        for (int i = 0; i < ContadorRegistros; i++) {
            if (Tema[i].equals(tema)) {
                TemResumo = true;
            }
        }
        return TemResumo;
    }

    public int conta() {
        return ContadorRegistros;
    }

}