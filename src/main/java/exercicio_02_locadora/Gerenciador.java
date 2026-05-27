package exercicio_02_locadora;

import java.util.List;

/**
 * Define o contrato para os gerencidaores de locadora
 * */

public interface Gerenciador {

    /**
     * Metodo para adicionar filmes a lista
     *
     * @param titulo Nome do filme
     * @param genero o genero desse filme
     * @param quantidade quantas cópias desse filme tem na locadora
     * @param duracao O valor inteiro da duracao do filme em minutos
     * */
    public void adicionarFilme(String titulo, String genero, int quantidade, int duracao);

    /**
     * Metodo que remove o filme das prateleiras, se assim ele existir
     *
     * @param id codigo de identificação do filme.
     * @throws FilmeNaoEncontradoException Se não existir um filme com o id designado.
     * */
    public void removerFilme(int id) throws FilmeNaoEncontradoException;

    /**
     * Lista todos os filmes que estão disponíveis.
     *
     * @return uma lista de Filme com todos aqueles que possuem seu status true.
     * */
    public List<Filme> listarFilmesDisponiveis();

    /**
     * Metodo que faz o aluguel da cópia de um filme que está em estoque
     *
     * @param id código de identificação do filme.
     * @throws FilmeNaoEncontradoException Se não existir um filme com o id designado.
     * */
    public void alugarFilme(int id) throws FilmeNaoEncontradoException;

    /**
     * Metodo que devolve a cópia de um filme.
     *
     * @param id código de identificação do filme.
     * @throws FilmeNaoEncontradoException Se não existir um filme com o id designado.
     * */
    public void devolverFilme(int id) throws FilmeNaoEncontradoException;
}
