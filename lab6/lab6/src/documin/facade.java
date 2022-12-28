package documin;

import documin.documentos.documentController;
import documin.elementos.elementController;


public class facade {

    private documentController documentController;
    private elementController elementController;

    public facade() {
        documentController = new documentController();
        elementController = new elementController();
    }
    
    public boolean criarDocumento(String titulo) {
        try{
            documentController.createDocument(titulo);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean criarDocumento(String titulo, int tamanhoMaximo) {
        try{
            documentController.createDocument(titulo, tamanhoMaximo);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void removerDocumento(String titulo) {
        documentController.removeDocument(titulo);
    }

    public int criarTexto(String tituloDoc, String valor, int prioridade) {
        try{
            elementController.adicionarElementoTexto(tituloDoc, valor, prioridade);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
        try{
            elementController.adicionarElementoTitulo(tituloDoc, valor, nivel, linkavel, prioridade);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
        try{
            elementController.adicionarElementoLista(tituloDoc, valorLista, separador, charLista, prioridade);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
        try{
            elementController.adicionarElementoTermo(tituloDoc, valorTermos, separador, ordem, prioridade);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
        return elementController.pegarRepresentacaoCompleta(elementoPosicao);
    }

    public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
        return elementController.pegarRepresentacaoResumida(elementoPosicao);
    }

    public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
        try{
            elementController.removerElemento(elementoPosicao);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void moverParaCima(String tituloDoc, int elementoPosicao) {

    } 

    public void moverParaBaixo(String tituloDoc, int elementoPosicao) {

    }


}
