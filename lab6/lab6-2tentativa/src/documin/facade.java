package documin;

import documin.Controllers.*;

public class facade {

    private documentController documentController;
    private elementController elementController;

    public facade() {
        documentController = new documentController();
        elementController = new elementController();
    }
    
    
    /** 
     * @param titulo
     * @return boolean
     */
    public boolean criarDocumento(String titulo) {
        try{
            documentController.createDocument(titulo);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    
    /** 
     * @param titulo
     * @param tamanhoMaximo
     * @return boolean
     */
    public boolean criarDocumento(String titulo, int tamanhoMaximo) {
        try{
            documentController.createDocument(titulo, tamanhoMaximo);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    
    /** 
     * @param titulo
     */
    public void removerDocumento(String titulo) {
        documentController.removeDocument(titulo);
    }

    
    /** 
     * @param tituloDoc
     * @param valor
     * @param prioridade
     * @return int
     */
    public int criarTexto(String tituloDoc, String valor, int prioridade) {
        try{
            elementController.adicionarElementoTexto(tituloDoc, valor, prioridade);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    
    /** 
     * @param tituloDoc
     * @param valor
     * @param prioridade
     * @param nivel
     * @param linkavel
     * @return int
     */
    public int criarTitulo(String tituloDoc, String valor, int prioridade, int nivel, boolean linkavel) {
        try{
            elementController.adicionarElementoTitulo(tituloDoc, valor, nivel, linkavel, prioridade);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    
    /** 
     * @param tituloDoc
     * @param valorLista
     * @param prioridade
     * @param separador
     * @param charLista
     * @return int
     */
    public int criarLista(String tituloDoc, String valorLista, int prioridade, String separador, String charLista) {
        try{
            elementController.adicionarElementoLista(tituloDoc, valorLista, separador, charLista, prioridade);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    
    /** 
     * @param tituloDoc
     * @param valorTermos
     * @param prioridade
     * @param separador
     * @param ordem
     * @return int
     */
    public int criarTermos(String tituloDoc, String valorTermos, int prioridade, String separador, String ordem) {
        try{
            elementController.adicionarElementoTermo(tituloDoc, valorTermos, separador, ordem, prioridade);
            return 1;
        }catch (Exception e){
            return 0;
        }
    }

    
    /** 
     * @param tituloDoc
     * @param elementoPosicao
     * @return String
     */
    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
        return elementController.pegarRepresentacaoCompleta(elementoPosicao);
    }

    
    /** 
     * @param tituloDoc
     * @param elementoPosicao
     * @return String
     */
    public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
        return elementController.pegarRepresentacaoResumida(elementoPosicao);
    }

    
    /** 
     * @param tituloDoc
     * @param elementoPosicao
     * @return boolean
     */
    public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
        try{
            elementController.removerElemento(elementoPosicao);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    
    /** 
     * @param tituloDoc
     * @param elementoPosicao
     */
    public void moverParaCima(String tituloDoc, int elementoPosicao) {
        
    } 

    
    /** 
     * @param tituloDoc
     * @param elementoPosicao
     */
    public void moverParaBaixo(String tituloDoc, int elementoPosicao) {

    }

    public int criarAtalho(String tituloDoc, String tituloDocReferenciado) {
        return 1;
    }

    public int criarVisaoCompleta(String tituloDoc) {
        return 1;
    }
    
    public int criarVisaoResumida(String tituloDoc) {
        return 1;
    }
    
    public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
        return 1;
    }
    
    public int criarVisaoTitulo(String tituloDoc) {
        return 1;
    }
    
    public String[] exibirVisao(int visaoId) {
        return null;
    }

}
