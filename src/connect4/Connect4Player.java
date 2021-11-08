package connect4;

public class Connect4Player {
    private Connect4Piece piece;
    private String name;

    public Connect4Player(String n, Connect4Piece p) {
        piece = p;
        name = n;
    }
    public Connect4Player(String n) {
        name = n;
    }

    public Connect4Piece getPiece() {
        return piece;
    }

    public void setPiece(Connect4Piece p) {
        piece = p;
    }

    public String getName() {
        return name;
    }
}