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

    public void cadastraAmigo(String emailDaPessoa, String emailAmigo){
        Amigo amigo = new Amigo(emailDaPessoa, emailAmigo);
        amigos.add(amigo);
    }

    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException{
        for(Amigo a : amigos){
            if(a.getEmail().equals(emailAmigo)){
                return a;
            }
        }

        throw new AmigoInexistenteException("Amigo não encontrado");
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima){
        Mensagem mpt = new MensagemParaTodos(texto, emailRemetente, ehAnonima);
        this.mensagens.add(mpt);
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima){
        Mensagem mpa = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima);
        this.mensagens.add(mpa);
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
