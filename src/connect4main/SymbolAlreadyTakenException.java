package connect4main;

public class SymbolAlreadyTakenException extends Exception {
    /**
     *
     */
    public SymbolAlreadyTakenException() {
        super();
    }

    public SymbolAlreadyTakenException(String message) {
        super(message);
    }

    public SymbolAlreadyTakenException(String message, Throwable t) {
        super(message, t);
    }
}
