package Connect4;

public class RowIsFullException extends Exception {
    public RowIsFullException() {
        super();
    }

    public RowIsFullException(String message) {
        super(message);
    }

    public RowIsFullException(String message, Throwable t) {
        super(message, t);
    }
}
