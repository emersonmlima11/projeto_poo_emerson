package Exercicio_03_AmigoSecreto;

import java.util.Scanner;

public class TestaSistemaAmigoGUI {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        SistemaAmigo sistema = new SistemaAmigo();

        System.out.print("Quantos amigos participaram da bricadeira: ");
        int quantidade = Integer.parseInt(input.nextLine());

        for(int i = 0; i < quantidade; i++){
            System.out.println("Participante "+i+":");
            System.out.print("Nome: ");
            String nome = input.nextLine();
            System.out.println("Email: ");
            String email = input.nextLine();
            sistema.cadastraAmigo(nome, email);
        }

        try{
            sistema.sortear();
        } catch (AmigoInexistenteException | NaoPossuiAmigoParaSortearException e) {
            System.out.println("Erro: "+e.getMessage());
        }

        for(Amigo a : sistema.getAmigos()) {
            try {
                String amigoSecreto = sistema.pesquisaAmigoSecretoDe(a.getEmail());
                System.out.println("O amigo secreto de: "+a.getNome()+" é "+amigoSecreto);
            } catch (AmigoInexistenteException | AmigoNaoSorteadoException e) {
                System.out.println("Erro: "+e.getMessage());
            }
        }

        System.out.println("Vamos enviar uma mensagem");
        System.out.print("Quem quer mandar a mensagem: ");
        String nome = input.nextLine();
        System.out.print("Qual mensagem deseja enviar: ");
        String mensagem = input.nextLine();
        System.out.print("A mensagem é anonima[S/N]: ");
        String anonima = input.nextLine();
        boolean a = true;
        if(anonima.equals("N")){
            a = false;
        }
        System.out.print("Para todos[1] ou para Alguém[2]");
        int decisao = Integer.parseInt(input.nextLine());
        if(decisao == 1){
            sistema.enviarMensagemParaTodos(mensagem, nome, a);
        } else if (decisao == 2) {
            System.out.println("Para quem deseja enviar: ");
            String destinatario = input.nextLine();
            sistema.enviarMensagemParaAlguem(mensagem,nome,destinatario,a);
        }
    }
}
