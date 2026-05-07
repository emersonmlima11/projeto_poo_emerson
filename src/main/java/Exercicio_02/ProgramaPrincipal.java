package Exercicio_02;

import java.util.List;
import java.util.Scanner;

public class ProgramaPrincipal {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Locadora sistemaLoc = new Locadora();
        while (true){
            System.out.println("1 - Adicionar Filme\n2 - Remover Filme \n3- Alugar Filme \n4 - Devolver filme\n" +
                    "5 - Listar Filmes Disponíveis\n0 - Sair");
            System.out.print("Escolha: ");
            int escolha = Integer.parseInt(input.nextLine());

            if(escolha == 1){
                System.out.print("Título do Filme: ");
                String titulo = input.nextLine();
                System.out.print("Gênero do Filme: ");
                String genero = input.nextLine();
                System.out.print("Duração em minutos: ");
                int duracao = Integer.parseInt(input.nextLine());
                System.out.print("Quantidade de copias: ");
                int quantidade = Integer.parseInt(input.nextLine());
                sistemaLoc.adicionarFilme(titulo, genero, quantidade, duracao);

            } else if (escolha == 2) {
                System.out.print("ID do Filme que deseja remover: ");
                int id = Integer.parseInt(input.nextLine());
                try {
                    sistemaLoc.removerFilme(id);
                }catch (FilmeNaoEncontradoException e){
                    System.out.println("ERRO: "+ e.getMessage());
                }
            } else if (escolha == 3) {
                System.out.print("ID do Filme que deseja alugar: ");
                int id = Integer.parseInt(input.nextLine());
                try {
                    sistemaLoc.alugarFilme(id);
                }catch (FilmeNaoEncontradoException e){
                    System.out.println("ERRO: "+ e.getMessage());
                }
            } else if (escolha == 4) {
                System.out.print("ID do Filme que deseja devolver: ");
                int id = Integer.parseInt(input.nextLine());
                try {
                    sistemaLoc.devolverFilme(id);
                }catch (FilmeNaoEncontradoException e){
                    System.out.println("ERRO: "+ e.getMessage());
                }
            } else if (escolha == 5) {
                System.out.println("Lista de Filmes Disponíveis: ");
                List<Filme> filmes = sistemaLoc.listarFilmesDisponiveis();
                for(Filme f : filmes){
                    System.out.println("- "+f.toString());
                }
            } else if (escolha == 0) {
                System.out.println("Finalizando Programa");
                break;
            }
        }
    }
}
