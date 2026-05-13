package Exercicio_03_AmigoSecreto;

import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo {
    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public SistemaAmigo(){
        this.mensagens = new ArrayList<>();
        this.amigos = new ArrayList<>();
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo){
        //TODO
    }

    public Amigo pesquisaAmigo(String emailAmigo){
        return new Amigo("", "");
        //TODO
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima){
        //TODO
    }

    public void enviarMensagemParaAlguem(String texto, String emailRmetente, String emailDestinatario,
                                         boolean ehAnonima){
        //TODO

    }

    public List<Mensagem> pesquisarrMensagensAnonimas(){
        return null;
        //TODO
    }

    public List<Mensagem> pesquisarTodasAsMensagens(){
        return null;
        //TODO
    }

    public void configurarAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado){
        //TODO
    }

    public String peesquisarAmiigoSecretoDe(String emailDaPessoa){
        return "";
        //TODO
    }
}
