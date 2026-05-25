package exercicio_02_locadora;

import java.util.ArrayList;
import java.util.List;

public class Locadora implements Gerenciador{
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

    @Override
    public void adicionarFilme(String titulo, String genero, int quantidade, int duracao){
        Filme filme = new Filme(titulo, genero, quantidade, duracao);
        this.contadorID++;
        filme.setCodigo(this.contadorID);
        filmes.add(filme);
    }

    @Override
    public void removerFilme(int id) throws FilmeNaoEncontradoException{
        for(Filme f : filmes){
            if(f.getCodigo() == id){
                filmes.remove(f);
                return;
            }
        }

        throw new FilmeNaoEncontradoException("Nenhum filme foi encontrado");
    }

    @Override
    public List<Filme> listarFilmesDisponiveis(){
        List<Filme> filmesDisponiveis = new ArrayList<>();
        for(Filme f : filmes){
            if(f.isDisponivel()){
                filmesDisponiveis.add(f);
            }
        }
        return filmesDisponiveis;
    }

    @Override
    public void alugarFilme(int id) throws FilmeNaoEncontradoException{
        for(Filme f : filmes){
            if(f.getCodigo() == id){
                try {
                    f.alugar();
                }catch (FilmeIndisponivelException e){
                    System.out.println("Erro ao alugar: " + e.getMessage());
                }
                return;
            }
        }

        throw new FilmeNaoEncontradoException("Nenhum Filme foi encontrado");
    }

    @Override
    public void devolverFilme(int id) throws FilmeNaoEncontradoException{
        for(Filme f : filmes){
            if(f.getCodigo() == id){
                f.devolver();
                return;
            }
        }

        throw new FilmeNaoEncontradoException("Nenhum Filme foi encontrado");

    }
}
