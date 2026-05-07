package Exercicio_02;

import java.util.ArrayList;
import java.util.List;

public class Locadora {
    private List<Filme> filmes;
    private int contadorID = 0;

    public Locadora(){
        this.filmes = new ArrayList<>();
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public void adicionarFilme(String titulo, String genero, int quantidade, int duracao){
        Filme filme = new Filme(titulo, genero, quantidade, duracao);
        this.contadorID++;
        filme.setCodigo(this.contadorID);
    }

    public void removerFilme(int id){
        for(Filme f : filmes){
            if(f.getCodigo() == id){
                filmes.remove(f);
            }
        }
    }

    public List<Filme> listarFilmesDisponíveis(){
        List<Filme> filmesDisponiveis = new ArrayList<>();
        for(Filme f : filmes){
            if(f.isDisponivel()){
                filmesDisponiveis.add(f);
            }
        }
        return filmesDisponiveis;
    }

    public void alugarFilme(int id){
        for(Filme f : filmes){
            if(f.getCodigo() == id){
                try {
                    f.alugar();
                }catch (FilmeIndisponivelException e){
                    System.out.println("Erro ao alugar: " + e.getMessage());
                }
            }
        }
    }

    public void devolverFilme(int id){
        for(Filme f : filmes){
            if(f.getCodigo() == id){
                f.devolver();
            }
        }
    }
}
