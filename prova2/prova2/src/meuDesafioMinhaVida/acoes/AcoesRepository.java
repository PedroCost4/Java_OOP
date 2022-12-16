package meuDesafioMinhaVida.acoes;

import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

public class AcoesRepository {
    
    private HashMap< Integer, Acao > AcaoMap;

    public AcoesRepository() {
        this.AcaoMap = new HashMap < Integer, Acao > ();
    }

    public void adicionaAcao(Acao Acao) {
        this.AcaoMap.put(Acao.getId(), Acao);
    }

    public String listarAcoes() {
        return sortedMapProresso();
    }

    public Acao getAcao(int id) {
        return this.AcaoMap.get(id);
    }

    public int atualizaProgresso(int id, int progresso) {
        this.AcaoMap.get(id).atualizaProgresso(progresso);
        return this.AcaoMap.get(id).getProgresso();
    }

    private String sortedMapProresso() {
        Collection<Acao> Acoes = this.AcaoMap.values();
        return Acoes.stream().sorted((a1, a2) -> a1.getProgresso() - a2.getProgresso()).map(Acao::toString)
        .collect(Collectors.joining("\n"));
    }
}
