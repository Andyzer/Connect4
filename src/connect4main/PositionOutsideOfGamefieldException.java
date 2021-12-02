package connect4main;

public class PositionOutsideOfGamefieldException extends Exception {
    public PositionOutsideOfGamefieldException() { super(); }
    public PositionOutsideOfGamefieldException(String message) { super(message); }
    public PositionOutsideOfGamefieldException(String message, Throwable t) { super(message, t); }

}
