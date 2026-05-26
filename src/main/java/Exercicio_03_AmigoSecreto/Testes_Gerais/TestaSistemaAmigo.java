package Exercicio_03_AmigoSecreto.Testes_Gerais;

import Exercicio_03_AmigoSecreto.Exceptions.AmigoInexistenteException;
import Exercicio_03_AmigoSecreto.Modelos.Amigo;
import Exercicio_03_AmigoSecreto.Modelos.Mensagem;
import Exercicio_03_AmigoSecreto.Sistemas.SistemaAmigo;

import java.util.List;

public class TestaSistemaAmigo {
    public static void main(String[] args){
        SistemaAmigo sistemaAmigo = new SistemaAmigo();
        sistemaAmigo.cadastraAmigo("José", "jose@amigo.secreto");
        sistemaAmigo.cadastraAmigo("Maria", "maria@amigo.secreto");

        try{
            sistemaAmigo.configuraAmigoSecretoDe("jose@amigo.secreto", "maria@amigo.secreto");
        } catch (AmigoInexistenteException e) {
            System.out.println("ERRO: "+e.getMessage());
        }

        try {
            sistemaAmigo.configuraAmigoSecretoDe("maria@amigo.secreto", "jose@amigo.secreto");
        } catch (AmigoInexistenteException e) {
            System.out.println("ERRO: "+e.getMessage());
        }

        sistemaAmigo.enviarMensagemParaAlguem("Olá José", "maria@amigo.secreto", "jose@amigo.secreto", true);
        sistemaAmigo.enviarMensagemParaTodos("Olá todo mundo", "maria@amigo.secreto", true);

        List<Mensagem> mensagensAnonimas = sistemaAmigo.pesquisaMensagensAnonimas();
        for (Mensagem m : mensagensAnonimas){
            System.out.println(m.getTextoCompletoAExibir());
        }

        try {
            Amigo amigo = sistemaAmigo.pesquisaAmigo("jose@amigo.secreto");
            if(amigo.getEmailAmigoSecreto().equals("maria@amigo.secreto")){
                System.out.println("OK");
            }
        } catch (AmigoInexistenteException e) {
            System.out.println(e.getMessage());
        }
    }
}
