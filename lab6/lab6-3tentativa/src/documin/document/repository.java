package documin.document;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.NoSuchElementException;

import documin.element.elementInterface;

public class repository {
    
    private HashMap<String, document> documents;
    private ArrayList<String[]> visoes;

    public repository() {
        documents = new HashMap<String, document>();
    }

    
    /** 
     * @param doc
     */
    public void addDocument(document doc) {
        emptyTitle(doc.getTitulo());
        checkIfDocumentAlreadyExists(doc.getTitulo());
        checkIfBypassSize(doc.getTitulo());
        documents.put(doc.getTitulo(), doc);
    }

    
    /** 
     * @param titulo
     * @return document
     */
    public document getDocument(String titulo) {
        checkIfDocumentExists(titulo);
        return documents.get(titulo);
    }

    
    /** 
     * @param titulo
     */
    public void removeDocument(String titulo) {
        checkIfDocumentExists(titulo);
        documents.remove(titulo);
    }

      
    /** 
     * @param tituloDocument
     * @param element
     */
    public int addElementDocument(String tituloDocument, elementInterface element) {
        documents.get(tituloDocument).addElements(element);
        return documents.get(tituloDocument).countElements() - 1 ;
    }

    
    /** 
     * @param tituloDocument
     * @param element
     */
    public void removeElementDocument(String tituloDocument, elementInterface element) {
        checkIfDocumentExists(tituloDocument);
        documents.get(tituloDocument).removeElements(element);
    }

    
    /** 
     * @param tituloDocument
     * @param element
     */
    public void moveElementDown(String tituloDocument, int posicaoElement) {
        checkIfDocumentExists(tituloDocument);
        documents.get(tituloDocument).moveElementDown(posicaoElement);
    }

    
    /** 
     * @param tituloDocument
     * @param element
     */
    public void moveElementUp(String tituloDocument, int posicaoElement) {
        checkIfDocumentExists(tituloDocument);
        documents.get(tituloDocument).moveElementUp(posicaoElement);
    }

    
    /** 
     * @param tituloDocument
     * @return int
     */
    public int countElementsDocument(String tituloDocument) {
        checkIfDocumentExists(tituloDocument);
        return documents.get(tituloDocument).countElements();
    }

    
    /** 
     * @param tituloDocument
     * @param element
     */
    public String getRepresentacaoCompleta(String tituloDocument, int posicaoElement) {
        checkIfDocumentExists(tituloDocument);
        return documents.get(tituloDocument).getRepresentacaoCompleta(posicaoElement);
    }

    
    /** 
     * @param tituloDocument
     * @param element
     */
    public String getRepresentacaoResumida(String tituloDocument, int posicaoElement) {
        checkIfDocumentExists(tituloDocument);
        return documents.get(tituloDocument).getRepresentacaoResumida(posicaoElement);
    }

    
    /** 
     * @param tituloDocument
     * @return int
     */
    public int addVisaoCompleta(String tituloDocument) {
        checkIfDocumentExists(tituloDocument);
        visoes.add(documents.get(tituloDocument).visaoCompleta());
        return visoes.size() - 1;
    }

    
    /** 
     * @param tituloDocument
     * @return int
     */
    public int addVisaoResumida(String tituloDocument) {
        checkIfDocumentExists(tituloDocument);
        visoes.add(documents.get(tituloDocument).visaoResumida());
        return visoes.size() - 1;
    }

    
    /** 
     * @param tituloDocument
     * @param prioridade
     * @return int
     */
    public int addVisaoPrioritaria(String tituloDocument, int prioridade) {
        checkIfDocumentExists(tituloDocument);
        visoes.add(documents.get(tituloDocument).visaoPrioritaria(prioridade));
        return visoes.size() - 1;
    }

    
    /** 
     * @param tituloDocument
     * @return int
     */
    public int addVisaoTitulo(String tituloDocument) {
        checkIfDocumentExists(tituloDocument);
        visoes.add(documents.get(tituloDocument).visaoTitulo());
        return visoes.size() - 1;
    }

    
    /** 
     * @param idVisao
     * @return String[]
     */
    public String[] getVisao(int idVisao) {
        return visoes.get(idVisao);
    }

    private void checkIfDocumentExists(String documentTitle) {
        if(documents.containsKey(documentTitle)) {
            throw new NoSuchElementException("Document does not exist");
        };
    }

    private boolean booleanCheckIfDocumentExists(String documentTitle) {
        return documents.containsKey(documentTitle);
    }

    private void checkIfBypassSize(String documentTitle) {
        if (documents.get(documentTitle).checkIfBypassSize()) {
            throw new IllegalArgumentException("");
        };
    }


    private void checkIfDocumentAlreadyExists(String tituloDocument){
        if (this.booleanCheckIfDocumentExists(tituloDocument)) {
            throw new NoSuchElementException ("Document already exists");
        }
    }

    private void emptyTitle(String titleDocument) {
        if (titleDocument.isBlank()) {
            throw new IllegalArgumentException("Title is empty");
        }
    }



}
