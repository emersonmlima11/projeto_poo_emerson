package Exercicio_03_AmigoSecreto.Exceptions;

public class AmigoJaExisteException extends RuntimeException {
    public AmigoJaExisteException(String message) {
        super(message);
    }
}
