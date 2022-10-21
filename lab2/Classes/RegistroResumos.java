package Classes;

/**
 * Representação de um criador de resumos do aluno na disciplina.
 *
 * @author Pedro Henrique Almeida Costa
 */
public class RegistroResumos {
    private int indexLastResumo = 0;
    private Resumo[] resumos;
    private String[] searchedResumo;
    private int contador_total_registros = 0;

    /**
     * Constrói o array de resumos de acordo com o numero maximo de resumos.
     *
     * @param numeroMaxresumos numero máximo para tamanho do array
     */
    public RegistroResumos(int numeroMaxresumos) {;
        this.resumos = new Resumo[numeroMaxresumos];
    }

    /**
     * Retorna o Array contendo os objetos de resumo.
     * 
     * @return Registro[] array com todos os resumos.
     */
    public Resumo[] pegaResumos() {
        return resumos;
    }

    /**
     * Retorna a quantidade de registros cadastrados.
     * 
     * @return int quantidade de temas adicionados.
     */
    public int conta() {
        return contador_total_registros;
    }

    /**
     * Retorna uma string com os resumos cadastrados.
     * 
     * @return String com todos os temas e a quantidade de temas.
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
     * @param tema do resumo a ser adicionado.
     * @param resumo conteudo do resumo a ser adicionado
     */
    public void adiciona(String tema, String resumo) {
        contador_total_registros = (indexLastResumo == resumos.length) ? resumos.length : indexLastResumo+1;
        indexLastResumo = (indexLastResumo == resumos.length) ? 0 : indexLastResumo; 
        Resumo Registro = new Resumo(tema, resumo);
        resumos[indexLastResumo] = Registro;
        indexLastResumo++;
    }

    /**
     * Checa se tem algum resumo com o tema procurado, retornando um boolean true or
     * false.
     * 
     * @param tema tema para ser procurado.
     * @return boolean se achou o tema = true, se nâo = false.
     */
    public boolean temResumo(String tema) {
        for (int i = 0; i < contador_total_registros - 1; i++) {
            if (this.resumos[i].getTema() == tema) {
                return true;
            };
        }
        return false;
    }

    /**
     * Retorna Array[String] com todos os resumos que contem a palavra de busca.
     *
     *
     * @param String Chave para busca do resumo com a palavra.
     * @return Array[String] com a lista de resumos os quais tem a palavra buscada.
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