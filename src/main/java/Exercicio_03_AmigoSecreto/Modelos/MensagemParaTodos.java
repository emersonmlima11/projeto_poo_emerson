package Exercicio_03_AmigoSecreto.Modelos;

public class MensagemParaTodos extends Mensagem {

    public MensagemParaTodos(String texto, String emailRemetente, boolean anonima){
        super(texto, emailRemetente, anonima);
    }

    @Override
    public String getTextoCompletoAExibir() {
        return "Mensagem de "+this.getEmailRemetente()+" para todos : "+this.getTexto();
    }
}
