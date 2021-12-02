import connect4main.*;

import org.junit.Test;
import org.junit.Assert;

import java.security.spec.ECField;

/**
 * I KNOW THIS IS BAD BUT BEAR WITH ME
 * I WILL GET IT FIXED
 * PLEASE HAVE MERCY ON ME
 */

public class Connect4Tests {

    private final Connect4Player user1 = new Connect4Player("Player1", Connect4Piece.RED);
    private final Connect4Player user2 = new Connect4Player("Player2", Connect4Piece.BLACK);


    /*---- Everything Changed When the Test Nation Attacked ----*/





    @Test
    public void goodSet1() throws PositionOutsideOfGamefieldException, StatusException, GameException, SymbolAlreadyTakenException {
        Connect4 connect4 = new Connect4Impl(user1, user2);

        Connect4LocalBoard localBoard = connect4.set(user1.getPiece(), new Connect4BoardPosition(0, 0));
        Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(0, 0)), user1.getPiece());

        localBoard = connect4.set(user2.getPiece(), new Connect4BoardPosition(0, 3));
        Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(0, 3)), user2.getPiece());
    }

    @Test
    public void goodSet2() throws PositionOutsideOfGamefieldException, StatusException, GameException, SymbolAlreadyTakenException {
        Connect4Impl connect4 = new Connect4Impl(user1, user2);

        Connect4LocalBoard localBoard = connect4.set(user1.getPiece(), new Connect4BoardPosition(0, 0));
        Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(0, 0)), user1.getPiece());

        localBoard = connect4.set(user2.getPiece(), new Connect4BoardPosition(0, 1));
        Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(0, 1)), user2.getPiece());

        localBoard = connect4.set(user1.getPiece(), new Connect4BoardPosition(1, 0));
        Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(1, 0)), user1.getPiece());

        localBoard = connect4.set(user2.getPiece(), new Connect4BoardPosition(0, 2));
        Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(0, 2)), user2.getPiece());

    }


    @Test(expected = PositionOutsideOfGamefieldException.class)
    public void setOutOfBounds() throws PositionOutsideOfGamefieldException, StatusException, GameException {
        Connect4Impl connect4 = new Connect4Impl(user1, user2);

        connect4.set(user1.getPiece(), new Connect4BoardPosition(10, 0));
    }

    @Test(expected = StatusException.class)
    public void setWrongTurn1() throws PositionOutsideOfGamefieldException, StatusException, GameException {
        Connect4Impl connect4 = new Connect4Impl(user1, user2);

        connect4.set(user2.getPiece(), new Connect4BoardPosition(1, 2));
    }

    @Test(expected = StatusException.class)
    public void setWrongTurn2() throws PositionOutsideOfGamefieldException, StatusException, GameException {
        Connect4Impl connect4 = new Connect4Impl(user1, user2);

        Connect4LocalBoard localBoard = connect4.set(user1.getPiece(), new Connect4BoardPosition(0, 0));
        Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(0, 0)), user1.getPiece());
        connect4.set(user1.getPiece(), new Connect4BoardPosition(1, 0));
    }

    @Test(expected = StatusException.class)
    public void setWrongTurn3() throws PositionOutsideOfGamefieldException, StatusException, GameException {
        Connect4Impl connect4 = new Connect4Impl(user1, user2);

        Connect4LocalBoard localBoard = connect4.set(user1.getPiece(), new Connect4BoardPosition(0, 0));
        Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(0, 0)), user1.getPiece());
        localBoard = connect4.set(user2.getPiece(), new Connect4BoardPosition(1, 1));
        Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(1, 1)), user2.getPiece());
        connect4.set(user2.getPiece(), new Connect4BoardPosition(1, 2));
    }


    @Test
    public void setWinVertical() throws PositionOutsideOfGamefieldException, StatusException, GameException {
        Connect4Impl connect4 = new Connect4Impl(user1, user2);

        Connect4LocalBoard localBoard = connect4.set(user1.getPiece(), new Connect4BoardPosition(0, 0));
        Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(0, 0)), user1.getPiece());
        localBoard = connect4.set(user2.getPiece(), new Connect4BoardPosition(1, 0));
        Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(1, 0)), user2.getPiece());

        localBoard = connect4.set(user1.getPiece(), new Connect4BoardPosition(0, 1));
        Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(0, 1)), user1.getPiece());
        localBoard = connect4.set(user2.getPiece(), new Connect4BoardPosition(1, 1));
        Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(1, 1)), user2.getPiece());

        localBoard = connect4.set(user1.getPiece(), new Connect4BoardPosition(0, 2));
        Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(0, 2)), user1.getPiece());
        localBoard = connect4.set(user2.getPiece(), new Connect4BoardPosition(1, 2));
        Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(1, 2)), user2.getPiece());

        localBoard = connect4.set(user1.getPiece(), new Connect4BoardPosition(0, 3));
        Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(0, 3)), user1.getPiece());

        Assert.assertEquals(connect4.checkWin(), user1.getPiece());
    }

    @Test
    public void setWinHorizontal() throws PositionOutsideOfGamefieldException, StatusException, GameException {
        Connect4Impl connect4 = new Connect4Impl(user1, user2);

        Connect4LocalBoard localBoard = connect4.set(user1.getPiece(), new Connect4BoardPosition(0, 0));
        Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(0, 0)), user1.getPiece());
        localBoard = connect4.set(user2.getPiece(), new Connect4BoardPosition(0, 1));
        Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(0, 1)), user2.getPiece());

        localBoard = connect4.set(user1.getPiece(), new Connect4BoardPosition(1, 0));
        Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(1, 0)), user1.getPiece());
        localBoard = connect4.set(user2.getPiece(), new Connect4BoardPosition(1, 1));
        Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(1, 1)), user2.getPiece());

        localBoard = connect4.set(user1.getPiece(), new Connect4BoardPosition(2, 0));
        Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(2, 0)), user1.getPiece());
        localBoard = connect4.set(user2.getPiece(), new Connect4BoardPosition(2, 1));
        Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(2, 1)), user2.getPiece());

        localBoard = connect4.set(user1.getPiece(), new Connect4BoardPosition(3, 0));
        Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(3, 0)), user1.getPiece());

        Assert.assertEquals(connect4.checkWin(), user1.getPiece());

    }

    @Test
    public void setWinDiagonallyRL() throws StatusException, PositionOutsideOfGamefieldException, GameException {

           Connect4Impl connect4 = new Connect4Impl(user1, user2);

           Connect4LocalBoard localBoard = connect4.set(user1.getPiece(), new Connect4BoardPosition(0, 0));
           Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(0, 0)), user1.getPiece());
           localBoard = connect4.set(user2.getPiece(), new Connect4BoardPosition(0, 1));
           Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(0, 1)), user2.getPiece()); // 1. Runde

           localBoard = connect4.set(user1.getPiece(), new Connect4BoardPosition(1, 1));
           Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(1, 1)), user1.getPiece());
           localBoard = connect4.set(user2.getPiece(), new Connect4BoardPosition(2, 0));
           Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(2, 0)), user2.getPiece()); // 2. Runde

           localBoard = connect4.set(user1.getPiece(), new Connect4BoardPosition(2, 1));
           Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(2, 1)), user1.getPiece());
           localBoard = connect4.set(user2.getPiece(), new Connect4BoardPosition(0, 1));
           Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(0, 1)), user2.getPiece()); // 3. Runde

           localBoard = connect4.set(user1.getPiece(), new Connect4BoardPosition(2, 2));
           Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(2, 2)), user1.getPiece());
           localBoard = connect4.set(user2.getPiece(), new Connect4BoardPosition(3, 0));
           Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(3, 0)), user2.getPiece()); // 4. Runde

           localBoard = connect4.set(user1.getPiece(), new Connect4BoardPosition(3, 1));
           Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(3, 1)), user1.getPiece());
           localBoard = connect4.set(user2.getPiece(), new Connect4BoardPosition(3, 2));
           Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(3, 2)), user2.getPiece()); // 3. Runde

           localBoard = connect4.set(user1.getPiece(), new Connect4BoardPosition(3, 3));
           Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(3, 3)), user1.getPiece()); // U1 Gewonnen

           Assert.assertEquals(connect4.checkWin(), user1.getPiece());
        }

    @Test
    public void setWinDiagonallyLR() throws  GameException, PositionOutsideOfGamefieldException, StatusException {
        Connect4Impl connect4 = new Connect4Impl(user1, user2);

        Connect4LocalBoard localBoard = connect4.set(user1.getPiece(), new Connect4BoardPosition(6, 0));
        Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(6, 0)), user1.getPiece());
        localBoard = connect4.set(user2.getPiece(), new Connect4BoardPosition(5, 0));
        Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(5, 0)), user2.getPiece()); // 1. Runde

        localBoard = connect4.set(user1.getPiece(), new Connect4BoardPosition(5, 1));
        Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(5, 1)), user1.getPiece());
        localBoard = connect4.set(user2.getPiece(), new Connect4BoardPosition(4, 0));
        Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(4, 0)), user2.getPiece()); // 2. Runde

        localBoard = connect4.set(user1.getPiece(), new Connect4BoardPosition(4, 1));
        Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(4, 1)), user1.getPiece());
        localBoard = connect4.set(user2.getPiece(), new Connect4BoardPosition(6, 1));
        Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(6, 1)), user2.getPiece()); // 3. Runde

        localBoard = connect4.set(user1.getPiece(), new Connect4BoardPosition(4, 2));
        Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(4, 2)), user1.getPiece());
        localBoard = connect4.set(user2.getPiece(), new Connect4BoardPosition(3, 0));
        Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(3, 0)), user2.getPiece()); // 4. Runde

        localBoard = connect4.set(user1.getPiece(), new Connect4BoardPosition(3, 1));
        Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(3, 1)), user1.getPiece());
        localBoard = connect4.set(user2.getPiece(), new Connect4BoardPosition(3, 2));
        Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(3, 2)), user2.getPiece()); // 3. Runde

        localBoard = connect4.set(user1.getPiece(), new Connect4BoardPosition(3, 3));
        Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(3, 3)), user1.getPiece()); // U1 Gewonnen

        Assert.assertEquals(connect4.checkWin(), user1.getPiece());
    }

}



