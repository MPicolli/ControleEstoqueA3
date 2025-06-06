package exception;

public class QuantidadeMinimaException extends RuntimeException {

    public QuantidadeMinimaException(String message) {
        super(message);
    }

    public QuantidadeMinimaException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
