package documin.document;

import documin.element.*;

public class controller {
    
    private repository repository;

    public controller() {
        repository = new repository();
    }

    
    /** 
     * @param titulo
     * @param tamanho
     */
    public boolean addDocument(String titulo, Integer tamanho) {
        try{
            repository.addDocument(new document(titulo, tamanho));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    
    /** 
     * @param titulo
     */
    public boolean addDocument(String tituloDocument) {
        try{
            repository.addDocument(new document(tituloDocument));
            return true;
        }catch (Exception e){
            return false;
        } 
    }

    
    /** 
     * @param titulo
     */
    public boolean removeDocument(String tituloDocument) {
        try{
            repository.removeDocument(tituloDocument);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    
    /** 
     * @param tituloDocument
     * @param valor
     * @param separator
     * @param caractereDeLista
     * @param prioridade
     */
    public int addListElementDocument(String tituloDocument, String valor, String separator, String caractereDeLista, int prioridade) {
        return repository.addElementDocument(tituloDocument, new listElement(tituloDocument, valor, separator, caractereDeLista, prioridade));
    }

    
    /** 
     * @param tituloDocument
     * @param valor
     * @param separator
     * @param ordem
     * @param prioridade
     */
    public int addTermElementDocument(String tituloDocument, String valor,  String separator, String ordem, int prioridade) {
        return repository.addElementDocument(tituloDocument, new termElement(tituloDocument, valor, separator, ordem, prioridade));
    }

    
    /** 
     * @param tituloDocument
     * @param valor
     * @param prioridade
     */
    public int addTextElementDocument(String tituloDocument, String valor, int prioridade) {
        return repository.addElementDocument(tituloDocument, new textElement(tituloDocument, valor, prioridade));
    }

    
    /** 
     * @param tituloDocument
     * @param valor
     * @param Level
     * @param linkable
     * @param prioridade
     */
    public int addTitleElementDocument(String tituloDocument, String valor, int Level, boolean linkable, int prioridade) {
        return repository.addElementDocument(tituloDocument, new titleElement(tituloDocument, valor, Level, linkable, prioridade));
    }

    
    /** 
     * @param tituloDocument
     * @param tituloReferenciado
     * @param prioridade
     */
    public int addShortcutElementDocument(String tituloDocument, String tituloReferenciado, int prioridade) {
        return repository.addElementDocument(tituloDocument, new atalhoElement(repository.getDocument(tituloReferenciado), prioridade));
    }

    
    /** 
     * @param tituloDocument
     * @return int
     */
    public boolean countElementsDocument(String tituloDocument) {
        try{
            repository.countElementsDocument(tituloDocument);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    
    /** 
     * @param tituloDocument
     * @param element
     */
    public boolean moveElementUp(String tituloDocument, int posicaoElement) {
        try{
            repository.moveElementUp(tituloDocument, posicaoElement);
            return true;
        }catch (Exception e){
            return false;
        }        
    }

    
    /** 
     * @param tituloDocument
     * @param element
     */
    public boolean moveElementDown(String tituloDocument, int posicaoElement) {
        try{
            repository.moveElementDown(tituloDocument, posicaoElement);
            return true;
        }catch (Exception e){
            return false;
        }        
    }

    
    /** 
     * @param tituloDocument
     * @param element
     */
    public String getRepresentacaoResumida(String tituloDocument, int posicaoElement) {
        try{
            return repository.getRepresentacaoResumida(tituloDocument, posicaoElement);
            
        }catch (Exception e){
            return e.getMessage();
        }        
    }

    public String getRepresentacaoCompleta(String tituloDocument, int posicaoElement) {
        try{
            return repository.getRepresentacaoCompleta(tituloDocument, posicaoElement);
        }catch (Exception e){
            return e.getMessage();
        }              
    }

    public int addVisaoCompleta(String tituloDocument) {
        return repository.addVisaoCompleta(tituloDocument);             
    }

    public int addVisaoResumida(String tituloDocument) {
        return repository.addVisaoResumida(tituloDocument);      
    }

    public int addVisaoPrioritaria(String tituloDocument, int prioridade) {
        return repository.addVisaoPrioritaria(tituloDocument, prioridade);      
    }

    public int addVisaoTitulo(String tituloDocument) {
        return repository.addVisaoTitulo(tituloDocument);      
    }

    public String[] getVisao(int idVisao) {
        return repository.getVisao(idVisao);      
    }

}
