package exercicio_02_locadora;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocadoraMap implements Gerenciador{
    private Map<Integer, Filme> filmes;
    private int contadorID = 0;

    public LocadoraMap(){
        this.filmes = Persistencia.ler();
    }

    public Map<Integer, Filme> getFilmes() {
        return filmes;
    }

    @Override
    public void adicionarFilme(String titulo, String genero, int quantidade, int duracao) {
        Filme filme = new Filme(titulo, genero, quantidade, duracao);
        this.contadorID++;
        filme.setCodigo(this.contadorID);
        filmes.put(filme.getCodigo(), filme);
        Persistencia.gravar(this.filmes);
    }

    @Override
    public void removerFilme(int id) throws FilmeNaoEncontradoException {
        if(!filmes.containsKey(id)){
            throw new FilmeNaoEncontradoException("Nenhum filme foi encontrado");
        }

        filmes.remove(id);
        Persistencia.gravar(this.filmes);
    }

    @Override
    public List<Filme> listarFilmesDisponiveis() {
        List<Filme> filmesDisponiveis = new ArrayList<>();
        for(Filme f : filmes.values()){
            if(f.isDisponivel()){
                filmesDisponiveis.add(f);
            }
        }
        return filmesDisponiveis;
    }

    @Override
    public void alugarFilme(int id) throws FilmeNaoEncontradoException {
        try{
            filmes.get(id).alugar();
        } catch (FilmeIndisponivelException e) {
            System.out.println("Erro: "+e.getMessage());
        }

        Persistencia.gravar(this.filmes);
    }

    @Override
    public void devolverFilme(int id) throws FilmeNaoEncontradoException {
        if(!filmes.containsKey(id)){
            throw new FilmeNaoEncontradoException("Nenhum Filme foi encontrado");
        }
        filmes.get(id).devolver();

        Persistencia.gravar(this.filmes);
    }


}
