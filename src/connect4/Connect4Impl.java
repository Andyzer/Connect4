package connect4;

import java.util.ArrayList;
import java.util.HashMap;


public class Connect4Impl implements Connect4, Connect4LocalBoard {
    private static final String NEW_PLAYERNAME = "newPlayer";
    HashMap<Connect4Piece, String> player = new HashMap<>();
    private Status status = Status.START_GAME;

    @Override
    public boolean set(Connect4Piece piece, Connect4BoardPosition position)
            throws StatusException, GameException, RowIsFullException {
        if (piece == null) {
            throw new StatusException("Can't play with air, dummy!");
        }
        if ((piece == Connect4Piece.BLACK) && this.status == Status.REDS_TURN) {
            throw new StatusException("Wait your turn, black!");
        }
        if ((piece == Connect4Piece.RED) && this.status == Status.BLACKS_TURN)
            throw new StatusException("Wait your turn, red!");
        return false;
    }


    public Connect4Piece pickPiece(String userName, Connect4Piece wantedPiece)
            throws GameException, StatusException {

        return wantedPiece;
    }

    private int checkWidth(int WIDTH) throws GameException {
        if(WIDTH < 0 || WIDTH > 6) {
            throw new GameException("Illegal move.");
        } return WIDTH;
    }

    private int checkHeight(int HEIGHT) throws GameException {
        if(HEIGHT < 0 || HEIGHT > 5) {
            throw new GameException("Illegal move.");
        } return HEIGHT;
    }

}
