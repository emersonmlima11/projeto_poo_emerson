package Exercicio_03_AmigoSecreto.Sistemas;

import Exercicio_03_AmigoSecreto.Exceptions.AmigoInexistenteException;
import Exercicio_03_AmigoSecreto.Exceptions.AmigoJaExisteException;
import Exercicio_03_AmigoSecreto.Exceptions.AmigoNaoSorteadoException;
import Exercicio_03_AmigoSecreto.Exceptions.NaoPossuiAmigoParaSortearException;
import Exercicio_03_AmigoSecreto.Modelos.Amigo;
import Exercicio_03_AmigoSecreto.Modelos.Mensagem;
import Exercicio_03_AmigoSecreto.Modelos.MensagemParaAlguem;
import Exercicio_03_AmigoSecreto.Modelos.MensagemParaTodos;

import java.util.*;

public class SistemaAmigoMap implements Sistema{
    private Map<String, Amigo> amigos;
    private Map<Integer, Mensagem> mensagens;
    public SistemaAmigoMap(){
        this.amigos = new HashMap<>();
        this.mensagens = new HashMap<>();
    }

    @Override
    public void cadastraAmigo(String nome, String emailAmigo) throws AmigoJaExisteException {
        if (amigos.containsKey(emailAmigo)){
            throw new AmigoJaExisteException("Amigo já cadastrado");
        }
        amigos.put(emailAmigo, new Amigo(nome, emailAmigo));
    }

    @Override
    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException {
        if(!amigos.containsKey(emailAmigo)){
            throw new AmigoInexistenteException("Amigo não encontrado");
        }

        return amigos.get(emailAmigo);
    }

    @Override
    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima) {
        Mensagem mpt = new MensagemParaTodos(texto, emailRemetente, ehAnonima);
        this.mensagens.put(mensagens.size()+1, mpt);
    }

    @Override
    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima) {
        Mensagem mpa = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima);
        this.mensagens.put(mensagens.size()+1, mpa);
    }

    @Override
    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> mensagensAnonimas = new ArrayList<>();
        for(Mensagem m : mensagens.values()){
            if(m.ehAnonima()){
                mensagensAnonimas.add(m);
            }
        }
        return mensagensAnonimas;
    }

    @Override
    public List<Mensagem> pesquisaTodasAsMensagens() {
        return new ArrayList<>(mensagens.values());
    }

    @Override
    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
        return this.amigos.get(emailDaPessoa).getEmailAmigoSecreto();
    }

    @Override
    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
        if(!amigos.containsKey(emailDaPessoa)){
            throw new AmigoInexistenteException("Amigo não encontrado");
        }

        this.amigos.get(emailDaPessoa).setEmailAmigoSecreto(emailAmigoSorteado);
    }

    @Override
    public void sortear() throws NaoPossuiAmigoParaSortearException, AmigoInexistenteException {
        if(this.amigos.size() < 2){
            throw new NaoPossuiAmigoParaSortearException("Não possui amigos suficientes para sortear");
        }

        List<Amigo> listaEmbaralhada = new ArrayList<>(this.amigos.values());
        Collections.shuffle(listaEmbaralhada);
        for(int i=0; i < listaEmbaralhada.size();i++){
            Amigo participante = listaEmbaralhada.get(i);
            int indiceAmigoSecreto = (i + 1) % listaEmbaralhada.size();
            Amigo amigoSecreto = listaEmbaralhada.get(indiceAmigoSecreto);
            configuraAmigoSecretoDe(participante.getEmail(), amigoSecreto.getEmail());
        }
    }
}
