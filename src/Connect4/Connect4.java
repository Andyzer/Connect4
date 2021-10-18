package Connect4;

public interface Connect4 {

    /**
     * set a piece on the board
     *
     * @param piece    to be placed on board
     * @param position where the piece is to be positioned
     * @return true if won,false otherwise
     * @throws GameException      postion outside board
     * @throws StatusException    not in status play
     * @throws RowIsFullException when the Row is full...
     */

    boolean set(Connect4Piece piece, Connect4BoardPosition position)
            throws StatusException, GameException, RowIsFullException;

}


