package documin.elementos;

import documin.elementos.elementTypes.*;

public class elementController {
    
    private elementRepository elementRepository;

    public elementController() {
        this.elementRepository = new elementRepository();
    }

    public void adicionarElementoTexto(String tituloDocumento, String valor, int prioridade) {
        textElement textElement = new textElement(tituloDocumento, valor, prioridade);
        this.elementRepository.adicionarElemento(textElement);
    }

    public void adicionarElementoLista(String tituloDocumento, String titulo, String separator, String caractereDeLista, int prioridade) {
        listElement listElement = new listElement(tituloDocumento, titulo, separator, caractereDeLista, prioridade);
        this.elementRepository.adicionarElemento(listElement);
    }

    public void adicionarElementoTermo(String tituloDocumento, String valor, String separator, String ordem, int prioridade) {
        termElement termElements = new termElement(tituloDocumento, valor, separator, ordem, prioridade);
        this.elementRepository.adicionarElemento(termElements);
    }

    public void adicionarElementoTitulo(String tituloDocumento, String valor, int Level, boolean linkable, int prioridade) {
        titleElement titleElement = new titleElement(tituloDocumento, valor, Level, linkable, prioridade);
        this.elementRepository.adicionarElemento(titleElement);
    }

    public void removerElemento(int elementoPosicao) {
        this.elementRepository.removerElemento(elementoPosicao);
    }

    public String pegarRepresentacaoCompleta(int elementoPosicao) {
        return this.elementRepository.pegarRepresentacaoCompleta(elementoPosicao);
    }

    public String pegarRepresentacaoResumida(int elementoPosicao) {
        return this.elementRepository.pegarRepresentacaoResumida(elementoPosicao);
    }

}
