package Exercicio_03_AmigoSecreto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SistemaAmigo {
    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public SistemaAmigo(){
        this.mensagens = new ArrayList<>();
        this.amigos = new ArrayList<>();
    }

    public List<Amigo> getAmigos() {
        return amigos;
    }

    public List<Mensagem> getMensagens() {
        return mensagens;
    }

    public void cadastraAmigo(String nome, String emailAmigo) throws AmigoJaExisteException{
        Amigo amigo = new Amigo(nome, emailAmigo);
        if(amigos.contains(amigo)){
           throw new AmigoJaExisteException("Amigo já cadastrado");
        }
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

    public List<Mensagem> pesquisaMensagensAnonimas(){
        List<Mensagem> mensagensAnonimas = new ArrayList<>();
        for(Mensagem m : mensagens){
            if(m.ehAnonima()){
                mensagensAnonimas.add(m);
            }
        }
        return mensagensAnonimas;
    }

    public List<Mensagem> pesquisaTodasAsMensagens(){
        return this.mensagens;
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException{
        for(Amigo a : amigos){
            if(a.getEmail().equals(emailDaPessoa)){
                a.setEmailAmigoSecreto(emailAmigoSorteado);
                return;
            }
        }

        throw new AmigoInexistenteException("O amigo não existe");
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException{
        for(Amigo m: amigos){
            if(m.getEmail().equals(emailDaPessoa)){
                if (m.getEmailAmigoSecreto() == null){
                    throw new AmigoNaoSorteadoException("O amigo ainda não foi sorteado");
                }
                return pesquisaAmigo(m.getEmailAmigoSecreto()).getEmail();
            }
        }
        throw new AmigoInexistenteException("O amigo não existe");
    }

    public void sortear() throws NaoPossuiAmigoParaSortearException, AmigoInexistenteException {
        if(this.amigos.size() < 2){
            throw new NaoPossuiAmigoParaSortearException("Não possui amigos suficientes para sortear");
        }

        List<Amigo> listaEmbaralhada = new ArrayList<>(this.amigos);
        Collections.shuffle(listaEmbaralhada);

        for(int i=0; i < listaEmbaralhada.size();i++){
            Amigo participante = listaEmbaralhada.get(i);
            int indiceAmigoSecreto = (i + 1) % listaEmbaralhada.size();
            Amigo amigoSecreto = listaEmbaralhada.get(indiceAmigoSecreto);
            configuraAmigoSecretoDe(participante.getEmail(), amigoSecreto.getEmail());
        }
    }
}
