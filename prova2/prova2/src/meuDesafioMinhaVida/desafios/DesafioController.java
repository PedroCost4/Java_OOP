package meuDesafioMinhaVida.desafios;

import meuDesafioMinhaVida.desafios.tiposDesafios.desafioMaterial;
import meuDesafioMinhaVida.desafios.tiposDesafios.desafioSocial;

public class DesafioController {
    
    private DesafioRepository desafioRepository;

    public DesafioController() {
        this.desafioRepository = new DesafioRepository();
    }

    public int adicionaDesafio (String titulo, String desc) {
        Desafio Desafio = new Desafio(this.desafioRepository.getDesafioMap().size() + 1, titulo, desc);
        this.desafioRepository.adicionaDesafio(Desafio);
        return this.desafioRepository.getDesafioMap().size();
    }

    public int adicionaDesafio(String titulo) {
        Desafio Desafio = new Desafio(this.desafioRepository.getDesafioMap().size() + 1, titulo);
        this.desafioRepository.adicionaDesafio(Desafio);
        return this.desafioRepository.getDesafioMap().size();
    }

    public int adicionaDesafioMaterial (String titulo, String desc, int valor) {
        desafioMaterial Desafio = new desafioMaterial(this.desafioRepository.getDesafioMap().size() + 1, titulo, desc, valor);
        this.desafioRepository.adicionaDesafio(Desafio);
        return this.desafioRepository.getDesafioMap().size();
    }

    public int adicionaDesafioMaterial (String titulo, int valor) {
        desafioMaterial Desafio = new desafioMaterial(this.desafioRepository.getDesafioMap().size() + 1, titulo, valor);
        this.desafioRepository.adicionaDesafio(Desafio);
        return this.desafioRepository.getDesafioMap().size();
    }

    public int adicionaDesafioSocial (String titulo, String desc, int pessoasAtingidas) {
        desafioSocial Desafio = new desafioSocial(this.desafioRepository.tamanhoMap() + 1, titulo, desc, pessoasAtingidas);
        this.desafioRepository.adicionaDesafio(Desafio);
        return this.desafioRepository.tamanhoMap();
    }

    public int adicionaDesafioSocial (String titulo, int pessoasAtingidas) {
        desafioSocial Desafio = new desafioSocial(this.desafioRepository.tamanhoMap() + 1, titulo, pessoasAtingidas);
        this.desafioRepository.adicionaDesafio(Desafio);
        return this.desafioRepository.tamanhoMap();
    }

    public String listarDesafios() {
        return this.desafioRepository.listaDesafios();
    }

    public Desafio getDesafio(String titulo) {
        return this.desafioRepository.getDesafio(titulo);
    }

    public int getSatisfacao(String titulo) {
        return this.desafioRepository.getDesafio(titulo).getSatisfacao();
    }

    public int adicionaExecucao(String titulo) {
        this.desafioRepository.adicionaExecucao(titulo);
        return this.desafioRepository.getDesafio(titulo).getSatisfacao();
    }

    public String exibirDesafio(String titulo) {
        return this.desafioRepository.exibirDesafio(titulo);
    }

}
