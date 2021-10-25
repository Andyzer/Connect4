package connect4;

public interface Connect4 {

    /**
     * WARNING THE FOLLOWING PROGRAM IS A TRAVESTY
     * MISTAKES SHALL BE RECTIFIED UNTIL MEILENSTEIN 3
     *
     * Connect4 is a turn based game, players pick a color
     * and take turns one after the other
     * The game grid is 7x6 slots
     * The players choose a row and the slots get filled
     * Bottom to Top, first player to pick a color begins
     *
     *
     * The winner is the first player that gets four pieces in a row
     * Horizontally, vertically or diagonaly wins.
     *
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


