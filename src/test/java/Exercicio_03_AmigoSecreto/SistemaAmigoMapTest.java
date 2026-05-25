package Exercicio_03_AmigoSecreto;
import Exercicio_03_AmigoSecreto.Exceptions.AmigoInexistenteException;
import Exercicio_03_AmigoSecreto.Exceptions.AmigoJaExisteException;
import Exercicio_03_AmigoSecreto.Exceptions.AmigoNaoSorteadoException;
import Exercicio_03_AmigoSecreto.Modelos.Amigo;
import Exercicio_03_AmigoSecreto.Modelos.Mensagem;
import Exercicio_03_AmigoSecreto.Modelos.MensagemParaAlguem;
import Exercicio_03_AmigoSecreto.Sistemas.SistemaAmigo;
import Exercicio_03_AmigoSecreto.Sistemas.SistemaAmigoMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class SistemaAmigoMapTest {
    SistemaAmigoMap sistema;

    @BeforeEach
    void setUp()  {
        this.sistema = new SistemaAmigoMap();
    }

    @Test
    void testSistemaAmigo() {
        assertTrue(sistema.pesquisaTodasAsMensagens().isEmpty());
        assertThrows(AmigoInexistenteException.class,
                ()-> sistema.pesquisaAmigo("emerson@teste.com"));
    }

    @Test
    void testPesquisa(){
        try {
            sistema.pesquisaAmigo("emerson@teste.com");
            fail("Deveria falhar pois nao existe");
        } catch (AmigoInexistenteException e) {

        }
    }

    @Test
    void cadastraAmigo(){
        try {
            sistema.cadastraAmigo("Emerson", "emerson@teste.com");
            Amigo a = sistema.pesquisaAmigo("emerson@teste.com");
            assertEquals("Emerson", a.getNome());
            assertEquals("emerson@teste.com", a.getEmail());
        } catch (AmigoInexistenteException | AmigoJaExisteException e) {
            fail("Não era para gerar erro");
        }
    }

    @Test
    void testEnviarMensagemParaTodos() {
        assertTrue(sistema.pesquisaTodasAsMensagens().isEmpty());
        sistema.enviarMensagemParaTodos("texto", "emerson@teste.com", true);
        List<Mensagem> mensagensAchadas = sistema.pesquisaTodasAsMensagens();
        assertTrue(mensagensAchadas.size()==1);
        assertTrue(mensagensAchadas.get(0).getEmailRemetente().equals("emerson@teste.com"));
    }

    @Test
    void testEnviarMensagemParaAlguem() {
        assertTrue(sistema.pesquisaTodasAsMensagens().isEmpty());
        sistema.enviarMensagemParaAlguem("texto", "emerson@teste.com", "ewerton@teste.com", true);
        List<Mensagem> mensagensAchadas = sistema.pesquisaTodasAsMensagens();
        assertEquals(1, mensagensAchadas.size());
        assertTrue(mensagensAchadas.get(0) instanceof MensagemParaAlguem);
        assertTrue(mensagensAchadas.get(0).getTexto().equals("texto"));
    }

    @Test
    void testPesquisaMensagensAnonimas() {
        assertTrue(sistema.pesquisaTodasAsMensagens().isEmpty());
        sistema.enviarMensagemParaAlguem("texto 1", "emerson@teste.com", "ewertoon@teste.com", false);
        assertTrue(sistema.pesquisaMensagensAnonimas().isEmpty());
        sistema.enviarMensagemParaAlguem("texto 2", "emerson@teste.com", "ewertoon@teste.com", true);
        assertTrue(sistema.pesquisaMensagensAnonimas().size()==1);
    }

    @Test
    void testPesquisaTodasAsMensagens() {
        assertTrue(sistema.pesquisaTodasAsMensagens().isEmpty());
        sistema.enviarMensagemParaAlguem("texto 1", "emerson@teste.com", "ewertoon@teste.com", false);
        assertTrue(sistema.pesquisaTodasAsMensagens().size()==1);
        sistema.enviarMensagemParaAlguem("texto 2", "emerson@teste.com", "ewertoon@teste.com", true);
        assertTrue(sistema.pesquisaTodasAsMensagens().size()==2);
    }

    @Test
    void testPesquisaAmigoEConfiguraAmigoSecretoDe() {
        try {
            sistema.cadastraAmigo("Emerson", "emerson@teste.com");
            sistema.cadastraAmigo("Ana", "ana@dcx.ufpb.br");
            sistema.configuraAmigoSecretoDe("emerson@teste.com", "ana@dcx.ufpb.br");
            sistema.configuraAmigoSecretoDe("ana@dcx.ufpb.br", "emerson@teste.com");
            assertEquals("ana@dcx.ufpb.br", sistema.pesquisaAmigoSecretoDe("emerson@teste.com"));
            assertEquals("emerson@teste.com", sistema.pesquisaAmigoSecretoDe("ana@dcx.ufpb.br"));
        } catch (AmigoInexistenteException | AmigoJaExisteException | AmigoNaoSorteadoException e) {
            fail("Não deveria lançar exceção");
        }
    }


}
