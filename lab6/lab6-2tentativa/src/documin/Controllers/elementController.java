package documin.Controllers;

import documin.models.elemenTypes.*;
import documin.Repositories.elementRepository;

public class elementController {
    
    private elementRepository elementRepository;

    public elementController() {
        this.elementRepository = new elementRepository();
    }

    
    /** 
     * @param tituloDocumento
     * @param valor
     * @param prioridade
     */
    public void adicionarElementoTexto(String tituloDocumento, String valor, int prioridade) {
        textElement textElement = new textElement(tituloDocumento, valor, prioridade);
        this.elementRepository.adicionarElemento(textElement);
    }

    
    /** 
     * @param tituloDocumento
     * @param titulo
     * @param separator
     * @param caractereDeLista
     * @param prioridade
     */
    public void adicionarElementoLista(String tituloDocumento, String titulo, String separator, String caractereDeLista, int prioridade) {
        listElement listElement = new listElement(tituloDocumento, titulo, separator, caractereDeLista, prioridade);
        this.elementRepository.adicionarElemento(listElement);
    }

    
    /** 
     * @param tituloDocumento
     * @param valor
     * @param separator
     * @param ordem
     * @param prioridade
     */
    public void adicionarElementoTermo(String tituloDocumento, String valor, String separator, String ordem, int prioridade) {
        termElement termElements = new termElement(tituloDocumento, valor, separator, ordem, prioridade);
        this.elementRepository.adicionarElemento(termElements);
    }

    
    /** 
     * @param tituloDocumento
     * @param valor
     * @param Level
     * @param linkable
     * @param prioridade
     */
    public void adicionarElementoTitulo(String tituloDocumento, String valor, int Level, boolean linkable, int prioridade) {
        titleElement titleElement = new titleElement(tituloDocumento, valor, Level, linkable, prioridade);
        this.elementRepository.adicionarElemento(titleElement);
    }

    
    /** 
     * @param elementoPosicao
     */
    public void removerElemento(int elementoPosicao) {
        this.elementRepository.removerElemento(elementoPosicao);
    }

    
    /** 
     * @param elementoPosicao
     * @return String
     */
    public String pegarRepresentacaoCompleta(int elementoPosicao) {
        return this.elementRepository.pegarRepresentacaoCompleta(elementoPosicao);
    }

    
    /** 
     * @param elementoPosicao
     * @return String
     */
    public String pegarRepresentacaoResumida(int elementoPosicao) {
        return this.elementRepository.pegarRepresentacaoResumida(elementoPosicao);
    }

    
    /** 
     * @param elementoPosicao
     */
    public void moverParaBaixo(int elementoPosicao) {
        this.elementRepository.moverParaBaixo(elementoPosicao);
    }

    
    /** 
     * @param elementoPosicao
     */
    public void moverParaCima(int elementoPosicao) {
        this.elementRepository.moverParaCima(elementoPosicao);
    }

}
