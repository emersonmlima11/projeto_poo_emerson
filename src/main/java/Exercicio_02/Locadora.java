package Exercicio_02;

import java.util.ArrayList;
import java.util.List;

public class Locadora {
    private List<Filme> filmes;

    public Locadora(){
        this.filmes = new ArrayList<>();
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public void adicionarFilme(){

    }

    public void removerFilme(){

    }

    public List<Filme> listarFilmesDisponíveis(){
        return new ArrayList<>();
    }
}
