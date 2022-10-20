package Classes;

/**
 * Representação de um criador de resumos do aluno na disciplina.
 *
 * @author Pedro Henrique Almeida Costa
 */
public class RegistroResumos {
    private int contador_registros = 0;
    private Registro[] resumos;
    private String[] searchedResumo;
    private int contador_total_registros = 0;

    /**
     * Constrói o array de resumos de acordo com o numero maximo de resumos.
     *
     * @param numeroMaxresumos
     */
    public RegistroResumos(int numeroMaxresumos) {;
        this.resumos = new Registro[numeroMaxresumos];
    }

    /**
     * Retorna o Array contendo os objetos de resumo.
     * 
     * @return Registro[]
     */
    public Registro[] pegaResumos() {
        return resumos;
    }

    /**
     * Retorna a quantidade de registros cadastrados.
     * 
     * @return int
     */
    public int conta() {
        return contador_total_registros;
    }

    /**
     * Retorna uma string com os resumos cadastrados.
     * 
     * @return String
     */
    public String imprimeResumos() {
        String Auxiliar = "";
        Auxiliar += String.format("- %d resumo(s) cadastrado(s)\n- ", contador_total_registros);
        for (int i = 0; i < contador_total_registros - 1; i++) {
            Auxiliar += resumos[i].getTema() + " | ";
        }
        Auxiliar += resumos[contador_total_registros - 1].getTema();
        return Auxiliar;
    }

    /**
     * Adiciona novos resumos no array de registros.
     * 
     * @param tema
     * @param resumos
     */
    public void adiciona(String tema, String resumo) {
        contador_total_registros = (contador_registros == resumos.length) ? resumos.length : contador_registros;
        contador_registros = (contador_registros == resumos.length) ? 0 : contador_registros;
        Registro Registro = new Registro(tema, resumo);
        resumos[contador_registros] = Registro;
        contador_registros++;
    }

    /**
     * Checa se tem algum resumo com o tema procurado, retornando um boolean true or
     * false.
     * 
     * @param tema
     * @return boolean
     */
    public boolean temResumo(String tema) {
        for (int i = 0; i < contador_total_registros - 1; i++) {
            if (resumos[i].getTema() == tema) {
                return true;
            };
        }
        return false;
    }

    /*
     * Retorna Array[String] com todos os resumos que contem a palavra de busca.
     * 
     * @param String ChaveDeBusca
     * 
     * @return Array[String]
     */
    public String[] busca(String chaveDeBusca) {
        searchedResumo = new String[contador_total_registros];
        for (int i = 0; i < contador_total_registros; i++) {
            if (resumos[i].getResumo().contains(chaveDeBusca)) {
                searchedResumo[i] = resumos[i].getTema();
            }
        }
        return searchedResumo;
    }
}