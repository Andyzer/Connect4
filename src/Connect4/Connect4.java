package Connect4;

public interface Connect4 {

    /**
     * set a piece onthe board
     *
     * @param piece to be placed on board
     * @param position
     * @return true if won,false otherwise
     * @throws GameException postion outside board - or position not empty
     * @throws StatusException not in status play
     *
     */

    boolean set(Connect4Piece piece, Connect4BoardPosition position)
        throws StatusException, GameException;

}


