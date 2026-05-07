package Exercicio_02;

import java.util.Objects;

public class Filme {
    private int codigo, duracao, quantidadeEmEstoque;
    private String titulo, genero;
    private boolean disponivel = true;

    public Filme(int codigo, String titulo, String genero, int quantidadeEmEstoque, int duracao){
        this.codigo = codigo;
        this.titulo = titulo;
        this.genero = genero;
        this.duracao = duracao;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public Filme(int codigo, String titulo, String genero, int duracao){
        this.codigo = codigo;
        this.titulo = titulo;
        this.genero = genero;
        this.duracao = duracao;
        this.quantidadeEmEstoque = 1;
    }

    public Filme(String titulo, String genero, int quantidadeEmEstoque, int duracao){
        this.titulo = titulo;
        this.genero = genero;
        this.duracao = duracao;
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public Filme(String titulo, String genero, int duracao){
        this.titulo = titulo;
        this.genero = genero;
        this.duracao = duracao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Filme filme = (Filme) o;

        return codigo == filme.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }

    public int getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public int getDuracao() {
        return duracao;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }

    public void alugar() throws FilmeIndisponivelException{
        if(this.quantidadeEmEstoque == 0){
            throw new FilmeIndisponivelException("Não há cópias disponíveis do Filme");
        }

        this.quantidadeEmEstoque -= 1;
    }

    public void devolver(){
        this.quantidadeEmEstoque++;
    }

    @Override
    public String toString() {
        return "Título: "+this.titulo
                +"; Genero: "+this.genero
                +"; Duraçao: "+this.duracao
                +"; Estoque: "+this.quantidadeEmEstoque;
    }
}
