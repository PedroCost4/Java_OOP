package Classes;

public class RegistroResumos {
    private int numeroMaxResumos;
    private String[] Tema = new String[numeroMaxResumos];
    private String[] Resumos = new String[numeroMaxResumos];
    private boolean TemResumo = false;
    
    public RegistroResumos(int numeroDeResumos) {
        this.numeroMaxResumos = numeroDeResumos;
    }

    public String[] pegaResumos() {
        return Resumos;
    }

    public String imprimeResumos() {
        return ("");
    }

    public void adiciona(String tema, String resumos) {
        int i = 0;
        for (i = 0; i < numeroMaxResumos; i++) {
            
        }
    }

    public boolean temResumo(String tema) {
        for (int i = 0; i < numeroMaxResumos; i++) {
            if (Tema[i].equals(tema)) {
                TemResumo = true;
            }
        }
        return TemResumo;
    }

    public int conta() {
        return Resumos.length;
    }
        
}
