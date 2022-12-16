package meuDesafioMinhaVida.acoes;

public class AcaoController {

    private AcoesRepository acoesRepository;

    public AcaoController() {
        this.acoesRepository = new AcoesRepository();
    }

    public void adicionaAcao (int id, String tituloDesafio, String dataCriacao) {
        Acao Acao = new Acao(id, tituloDesafio ,dataCriacao);
        this.acoesRepository.adicionaAcao(Acao);
    }

    public String listarAcoes() {
        return this.acoesRepository.listarAcoes();
    }

    public Acao getAcao(int id) {
        return this.acoesRepository.getAcao(id);
    }

    public int atualizaProgresso(int id, int progresso) {
        return this.acoesRepository.atualizaProgresso(id, progresso);
    }

    public int atualizaProgresso(int id)  {
        return this.acoesRepository.atualizaProgresso(id, 10);
    }

}
