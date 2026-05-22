package Exercicio_03_AmigoSecreto.Sistemas;

import Exercicio_03_AmigoSecreto.Exceptions.AmigoInexistenteException;
import Exercicio_03_AmigoSecreto.Exceptions.AmigoJaExisteException;
import Exercicio_03_AmigoSecreto.Exceptions.AmigoNaoSorteadoException;
import Exercicio_03_AmigoSecreto.Exceptions.NaoPossuiAmigoParaSortearException;
import Exercicio_03_AmigoSecreto.Modelos.Amigo;
import Exercicio_03_AmigoSecreto.Modelos.Mensagem;

import java.util.List;

public interface Sistema {
    public void cadastraAmigo(String nome, String emailAmigo) throws AmigoJaExisteException;
    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException;
    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima);
    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean ehAnonima);
    public List<Mensagem> pesquisaMensagensAnonimas();
    public List<Mensagem> pesquisaTodasAsMensagens();
    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException;
    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException;
    public void sortear() throws NaoPossuiAmigoParaSortearException, AmigoInexistenteException;
}
