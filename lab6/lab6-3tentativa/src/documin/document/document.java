package documin.document;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

import documin.element.elementInterface;
import documin.element.titleElement;

public class document {
    
    private String titulo;
    private Integer tamanho;
    private List<elementInterface> elements;

    public document(String titulo, Integer tamanho) {
        this.titulo = titulo;
        this.tamanho = tamanho;
        this.elements = new ArrayList<elementInterface>();
    }

    public document(String titulo) {
        this.titulo = titulo;
        this.tamanho = null;
    }

    
    /** 
     * @return String
     */
    public String getTitulo() {
        return titulo;
    }

    
    /** 
     * @return int
     */
    public int getTamanho() {
        return tamanho;
    }

    
    /** 
     * @param tamanho
     */
    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }


    /** 
     * @param elements
     */
    public void addElements(elementInterface elements) {
        this.elements.add(elements);
    }

    
    /** 
     * @param elements
     */
    public void removeElements(elementInterface elements){
        this.elements.remove(elements);
    }

    
    /** 
     * @param posicaoELement
     */
    public void moveElementUp(int posicaoElement) {
        Collections.swap(elements, posicaoElement, posicaoElement + 1);
    }

    
    /** 
     * @param positionElement
     */
    public void moveElementDown(int posicaoElement) {
        Collections.swap(elements, posicaoElement, posicaoElement + 1);
    }

  
    /** 
     * @return int
     */
    public int countElements() {
        return elements.size();
    }


    public elementInterface getElement(int position) {
        return elements.get(position);
    }
    
    /** 
     * @param element
     */
    public String getRepresentacaoCompleta(int posicaoElement) {
        return elements.get(posicaoElement).representacaoCompleta();
    }

    
    /** 
     * @param element
     */
    public String getRepresentacaoResumida(int posicaoElement) {
        return elements.get(posicaoElement).representacaoResumida();
    }

    
    /** 
     * @return List<elementInterface>
     */
    public List<elementInterface> getElementsByPriority() {
        return elements
                .stream()
                .filter(t -> t.getPrioridade() >= 4)
                .collect(Collectors.toList());
    }

    
    /** 
     * @return String[]
     */
    public String[] visaoCompleta() {
        return elements
                .stream()
                .map(t -> t.representacaoCompleta())
                .toArray(String[]::new);
    }

    
    /** 
     * @return String[]
     */
    public String[] visaoResumida() {
        return elements
                .stream()
                .map(t -> t.representacaoResumida())
                .toArray(String[]::new);
    }

    
    /** 
     * @param prioridade
     * @return String[]
     */
    public String[] visaoPrioritaria(int prioridade) {
        return elements
                .stream()
                .filter(t -> t.getPrioridade() >= prioridade)
                .map(t -> t.representacaoResumida())
                .toArray(String[]::new);
    }

    
    /** 
     * @return String[]
     */
    public String[] visaoTitulo() {
        return elements
                .stream()
                .filter(t -> t instanceof titleElement)
                .map(t -> t.representacaoResumida())
                .toArray(String[]::new);
    }

    public boolean checkIfBypassSize() {
        return (this.tamanho != null && (this.tamanho < 0 || this.tamanho > elements.size())); 
    }

}
