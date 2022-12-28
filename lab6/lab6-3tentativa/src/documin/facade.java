package documin;

import documin.document.controller;

public class facade {

    private controller controller;
    
    public facade() {
        controller = new controller();
    }
    
    /** 
     * @param titulo
     * @return boolean
     */
    public boolean criarDocumento(String titulo) {
        return controller.addDocument(titulo);
    }

    
    /** 
     * @param titulo
     * @param tamanhoMaximo
     * @return boolean
     */
    public boolean criarDocumento(String titulo, int tamanhoMaximo) {
        return controller.addDocument(titulo, tamanhoMaximo);
    }

    
    /** 
     * @param titulo
     */
    public void removerDocumento(String titulo) {
        controller.removeDocument(titulo);
    }

    
    /** 
     * @param tituloDoc
     * @param valor
     * @param prioridade
     * @return int
     */
    public int criarTexto(String tituloDoc, String valor, int prioridade) {
        return controller.addTextElementDocument(tituloDoc, valor, prioridade);
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
        return controller.addTitleElementDocument(tituloDoc, valor, nivel, linkavel, prioridade);
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
        return controller.addListElementDocument(tituloDoc, valorLista, separador, charLista, prioridade);
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
        return controller.addTermElementDocument(tituloDoc, valorTermos, separador, ordem, prioridade);
    }

    
    /** 
     * @param tituloDoc
     * @param elementoPosicao
     * @return String
     */
    public String pegarRepresentacaoCompleta(String tituloDoc, int elementoPosicao) {
        return controller.getRepresentacaoCompleta(tituloDoc, elementoPosicao);
    }

    
    /** 
     * @param tituloDoc
     * @param elementoPosicao
     * @return String
     */
    public String pegarRepresentacaoResumida(String tituloDoc, int elementoPosicao) {
        return controller.getRepresentacaoResumida(tituloDoc, elementoPosicao);
    }

    
    /** 
     * @param tituloDoc
     * @param elementoPosicao
     * @return boolean
     */
    public boolean apagarElemento(String tituloDoc, int elementoPosicao) {
        return true;
    }

    
    /** 
     * @param tituloDoc
     * @param elementoPosicao
     */
    public void moverParaCima(String tituloDoc, int elementoPosicao) {
        controller.moveElementUp(tituloDoc, elementoPosicao);
    } 

    
    /** 
     * @param tituloDoc
     * @param elementoPosicao
     */
    public void moverParaBaixo(String tituloDoc, int elementoPosicao) {
        controller.moveElementDown(tituloDoc, elementoPosicao);
    }

    
    /** 
     * @param tituloDoc
     * @param tituloDocReferenciado
     * @return int
     */
    public int criarAtalho(String tituloDoc, String tituloDocReferenciado, int prioridade) {
        return controller.addShortcutElementDocument(tituloDoc, tituloDocReferenciado, prioridade);
    }

    
    /** 
     * @param tituloDoc
     * @return int
     */
    public int criarVisaoCompleta(String tituloDoc) {
        return controller.addVisaoCompleta(tituloDoc);
    }
    
    
    /** 
     * @param tituloDoc
     * @return int
     */
    public int criarVisaoResumida(String tituloDoc) {
        return controller.addVisaoResumida(tituloDoc);
    }
    
    
    /** 
     * @param tituloDoc
     * @param prioridade
     * @return int
     */
    public int criarVisaoPrioritaria(String tituloDoc, int prioridade) {
        return controller.addVisaoPrioritaria(tituloDoc, prioridade);
    }
    
    
    /** 
     * @param tituloDoc
     * @return int
     */
    public int criarVisaoTitulo(String tituloDoc) {
        return controller.addVisaoTitulo(tituloDoc);
    }
    
    
    /** 
     * @param visaoId
     * @return String[]
     */
    public String[] exibirVisao(int visaoId) {
        return controller.getVisao(visaoId);
    }

}

