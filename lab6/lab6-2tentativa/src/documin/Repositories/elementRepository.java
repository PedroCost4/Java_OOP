package documin.Repositories;

import java.util.ArrayList;
import java.util.Collections;

import documin.interfaces.elementInterface;


public class elementRepository {
    
    private ArrayList<elementInterface> elementos;

    public elementRepository() {
        this.elementos = new ArrayList<elementInterface>();
    }

    
    /** 
     * @param elemento
     */
    public void adicionarElemento(elementInterface elemento) {
        this.elementos.add(elemento);
    }

    
    /** 
     * @param posicao
     * @return elementAbstract
     */
    public elementInterface getElement(int posicao) {
        return this.elementos.get(posicao);
    }

    
    /** 
     * @param elementoPosicao
     */
    public void removerElemento(int elementoPosicao) {
        this.elementos.remove(elementoPosicao);
    }

    
    /** 
     * @param elementoPosicao
     * @return String
     */
    public String pegarRepresentacaoCompleta(int elementoPosicao) {
        return this.elementos.get(elementoPosicao).representacaoCompleta();
    }

    
    /** 
     * @param elementoPosicao
     * @return String
     */
    public String pegarRepresentacaoResumida(int elementoPosicao) {
        return this.elementos.get(elementoPosicao).representacaoResumida();
    }

    
    /** 
     * @param prioridadeElemento
     */
    public void moverParaBaixo(int prioridadeElemento) {
        Collections.swap(this.elementos, prioridadeElemento, prioridadeElemento + 1);
    }

    
    /** 
     * @param prioridadeElemento
     */
    public void moverParaCima(int prioridadeElemento) {
        Collections.swap(this.elementos, prioridadeElemento, prioridadeElemento - 1);
    }
    
}
