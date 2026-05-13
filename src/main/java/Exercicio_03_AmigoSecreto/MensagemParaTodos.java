package Exercicio_03_AmigoSecreto;

public class MensagemParaTodos extends Mensagem{

    MensagemParaTodos(String texto, String emailRemetente, boolean anonima){
        super(texto, emailRemetente, anonima);
    }

    @Override
    public String getTextoCompletoAExibir() {
        return "Mensagem Para Todos";
    }
}
