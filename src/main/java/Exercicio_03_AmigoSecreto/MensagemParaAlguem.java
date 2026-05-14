package Exercicio_03_AmigoSecreto;

public class MensagemParaAlguem extends Mensagem{
    private String emailDestinatario;

    MensagemParaAlguem(String texto,String emailRemetente, String emailDestinatario, boolean anonima){
        super(texto, emailRemetente, anonima);
        this.emailDestinatario = emailDestinatario;
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    @Override
    public String getTextoCompletoAExibir() {
        return "Mensagem de "+this.getEmailRemetente() +" para "+this.emailDestinatario+" : "+this.getTexto();
    }
}
