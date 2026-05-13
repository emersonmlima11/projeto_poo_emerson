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
        List<Mensagem> mensagensAnonimas = new ArrayList<>();
        for(Mensagem m : mensagens){
            if(m.ehAnonima()){
                mensagensAnonimas.add(m);
            }
        }
        return mensagensAnonimas;
    }

    public List<Mensagem> pesquisarTodasAsMensagens(){
        return this.mensagens;
    }

    public void configurarAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException{
        for(Amigo a : amigos){
            if(a.getEmail().equals(emailDaPessoa)){
                a.setEmailAmigoSecreto(emailAmigoSorteado);
                return;
            }
        }

        throw new AmigoInexistenteException("O amigo não existe");
    }

    public String pesquisarAmiigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException{
        for(Amigo m: amigos){
            if(m.getEmail().equals(emailDaPessoa)){
                if (m.getEmailAmigoSecreto() == null){
                    throw new AmigoNaoSorteadoException("O amigo ainda não foi sorteado");
                }
                return m.getEmailAmigoSecreto();
            }
        }
        throw new AmigoInexistenteException("O amigo não existe");
    }
}
