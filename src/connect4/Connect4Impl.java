package connect4;

import java.util.LinkedList;
import java.util.List;


public class Connect4Impl implements Connect4  {


    private Connect4Player user1;
    private Connect4Player user2;
    private Connect4LocalBoard localBoard;
    private int turn = 1;

    public Connect4Impl(String u1, String u2) {
        user1 = new Connect4Player(u1);
        user2 = new Connect4Player(u2);
        localBoard = new Connect4LocalBoard();
        turn = 1;
    }


    public List<Connect4Player> getConnect4Player() {
        List<Connect4Player> playerList = new LinkedList<>();
        playerList.add(user1);
        playerList.add(user2);
        return playerList;
    }

    public Connect4LocalBoard getLocalBoard() { return localBoard; }

    public Connect4Piece pick(Connect4Player player, Connect4Piece piece)
            throws StatusException, SymbolAlreadyTakenException {

        return piece;
    }

    @Override
    public boolean set(Connect4Piece s, Connect4BoardPosition p) throws RowIsFullException, GameException, StatusException, PositionOutsideOfGamefieldException {
        if (p.getX() < 0 || p.getX() > 6 || p.getY() < 0 || p.getY() > 7) {
            throw new PositionOutsideOfGamefieldException();
        } else if (user1.getPiece() == null || user2.getPiece() == null) {
            throw new StatusException();
        }
    return false;
    }

    private boolean youWon() {
        return false;
    }

    private boolean youWonColumn() {
        return false;
    }

    private boolean youWonDiagonallyLR() {
        return false;
    }

    private boolean youWonDiagonallyRL() {
        return false;
    }

}
