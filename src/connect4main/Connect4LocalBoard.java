package connect4main;

/**
 * This class sets the playing field
 */

public class Connect4LocalBoard {

    private Connect4Piece[][] localBoard;

    public Connect4LocalBoard() {
        localBoard = new Connect4Piece[7][6];
    }

    public Connect4Piece[][] getConnect4LocalBoard() {
        return localBoard;
    }

    public Connect4Piece getConnect4BoardPosition(Connect4BoardPosition p) throws PositionOutsideOfGamefieldException {
        try {
            return localBoard[p.getX()][p.getY()];
        } catch (IndexOutOfBoundsException e) {
            throw new PositionOutsideOfGamefieldException();
        }
    }

    public void setConnect4BoardPosition(Connect4BoardPosition p, Connect4Piece s) throws PositionOutsideOfGamefieldException {

        try {
            localBoard[p.getX()][p.getY()] = s;
        } catch (IndexOutOfBoundsException e) {
            throw new PositionOutsideOfGamefieldException();
        }
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