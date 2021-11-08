package connect4;

/**
 * This class sets the playing field
 *
 */

public class Connect4LocalBoard {

    private Connect4Piece[][] localBoard;

    public void localBoard() { localBoard = new Connect4Piece[7][6]; }

    public Connect4Piece[][] getLocalBoard() { return localBoard; }

    public Connect4Piece getConnect4BoardPosition(Connect4BoardPosition p) { return localBoard[p.getX()][p.getY()] = Connect4Piece; }

    public void setConnect4BoardPosition(Connect4BoardPosition p, Connect4Piece s) {
        localBoard[p.getX()][p.getY()] = s;
    }


    public boolean isEmpty() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                if (localBoard[i][j] != null) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isFull() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 6; j++) {
                if (localBoard[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }


}
