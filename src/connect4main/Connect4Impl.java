package connect4main;

import java.util.LinkedList;
import java.util.List;


public class Connect4Impl implements Connect4 {


    private final Connect4Player user1;
    private final Connect4Player user2;
    private Connect4LocalBoard localBoard;
    private int turn;

    public Connect4Impl(Connect4Player u1, Connect4Player u2) {
        user1 = u1;
        user2 = u2;
        localBoard = new Connect4LocalBoard();
        turn = 1;
    }


    public List<Connect4Player> getConnect4Player() {
        List<Connect4Player> playerList = new LinkedList<>();
        playerList.add(user1);
        playerList.add(user2);
        return playerList;
    }

    public Connect4LocalBoard getConnect4LocalBoard() {
        return localBoard;
    }

    @Override
    //TODO: change method header to set(Connect4Piece, int) (it's a maybe)
    public Connect4LocalBoard set(Connect4Piece piece, Connect4BoardPosition boardPosition)
            throws GameException, StatusException, PositionOutsideOfGamefieldException {

        if (boardPosition.getX() < 0 || boardPosition.getX() >= 7 || boardPosition.getY() < 0 || boardPosition.getY() >= 6) {
            throw new PositionOutsideOfGamefieldException();
        } else if (user1.getPiece() == null || user2.getPiece() == null) {
            throw new StatusException();
        }

        if (turn % 2 == 1 && piece == user2.getPiece() || turn % 2 == 0 && piece == user1.getPiece()) {
            throw new StatusException();
        }


        localBoard.setConnect4BoardPosition(boardPosition, piece);

        if (localBoard.isFull()) {
            throw new GameException();
        }

        turn += 1;
        return localBoard;

    }

    @Override
    public Connect4Piece checkWin() {
        Connect4Piece[][] localBoardArray = localBoard.getConnect4LocalBoard();
        final int HEIGHT = localBoardArray.length;
        final int WIDTH = localBoardArray[0].length;


        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                Connect4Piece player = localBoardArray[x][y];
                if (player == null)
                    continue;
                try {
                    if (player == localBoardArray[x][y + 1] &&
                            player == localBoardArray[x][y + 2] &&
                            player == localBoardArray[x][y + 3]) return player;

                    if (player == localBoardArray[x + 1][y] &&
                            player == localBoardArray[x + 2][y] &&
                            player == localBoardArray[x + 3][y]) return player;

                    if (player == localBoardArray[x + 1][y + 1] &&
                            player == localBoardArray[x + 2][y + 2] &&
                            player == localBoardArray[x + 3][y + 3]) return player;

                    if (player == localBoardArray[x + 1][y - 1] &&
                            player == localBoardArray[x + 2][y - 2] &&
                            player == localBoardArray[x + 3][y - 3]) return player;
                } catch (IndexOutOfBoundsException e) {
                    // ignore this
                }
            }
        }
        return null;
    }


}
