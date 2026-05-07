package Exercicio_02;

import java.util.List;

public interface Gerenciador {
    public void adicionarFilme(String titulo, String genero, int quantidade, int duracao);
    public void removerFilme(int id) throws FilmeNaoEncontradoException;
    public List<Filme> listarFilmesDisponiveis();
    public void alugarFilme(int id) throws FilmeNaoEncontradoException;
    public void devolverFilme(int id) throws FilmeNaoEncontradoException;
}
