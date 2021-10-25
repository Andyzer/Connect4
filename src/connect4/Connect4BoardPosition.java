package connect4;

public class Connect4BoardPosition {
    static final int WIDTH = 7;
    static final int HEIGHT = 6;

    public Connect4Piece[][] grid = new Connect4Piece[WIDTH][HEIGHT];

    int getWidth() {return WIDTH; }
    int getHeight() {return HEIGHT; }
}
