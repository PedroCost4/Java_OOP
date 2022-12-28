package documin.elementos;

import java.util.ArrayList;

public class elementRepository {
    
    private ArrayList<elementAbstract> elementos;

    public elementRepository() {
        this.elementos = new ArrayList<elementAbstract>();
    }

    public void adicionarElemento(elementAbstract elemento) {
        this.elementos.add(elemento);
    }

    public elementAbstract getElement(int posicao) {
        return this.elementos.get(posicao);
    }

    public void removerElemento(int elementoPosicao) {
        this.elementos.remove(elementoPosicao);
    }

    public String pegarRepresentacaoCompleta(int elementoPosicao) {
        return this.elementos.get(elementoPosicao).representacaoCompleta();
    }

    public String pegarRepresentacaoResumida(int elementoPosicao) {
        return this.elementos.get(elementoPosicao).representacaoResumida();
    }
}
