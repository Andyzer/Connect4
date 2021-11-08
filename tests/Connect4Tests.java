import connect4.*;

import org.junit.Test;
import org.junit.Assert;

import java.util.List;

/**
 *
 * I KNOW THIS IS BAD BUT BEAR WITH ME
 * I WILL GET IT FIXED UNTLI THE NEXT DEADLINE
 * PLEASE HAVE MERCY ON ME
 *
 */

public class Connect4Tests {
    public static final String user1 = "Player1";
    public static final String user2 = "Player2";


    private Connect4Impl getConnect4AfterPick() throws SymbolAlreadyTakenException, StatusException, GameException {
        Connect4Impl connect4 = new Connect4Impl(user1, user2);
        List<Connect4Player> playerList = connect4.getConnect4Player();
        Connect4Player user1 = playerList.get(0);
        Connect4Player user2= playerList.get(1);
        connect4.pick(user1, Connect4Piece.RED);
        connect4.pick(user2, Connect4Piece.BLACK);

        return connect4;
    }

    /*---- Everything Changed When the Test Nation Attacked ----*/

    @Test
    public void goodPick1() throws SymbolAlreadyTakenException, StatusException {
        Connect4Impl connect4 = new Connect4Impl(user1, user2);
        List<Connect4Player> playerList = connect4.getConnect4Player();
        Connect4Player user1 = playerList.get(0);
        Connect4Player user2 = playerList.get(1);

        Connect4Piece user1Piece = connect4.pick(user1, Connect4Piece.RED);
        Assert.assertEquals(Connect4Piece.RED, user1Piece);
        Connect4Piece user2Piece = connect4.pick(user2, Connect4Piece.BLACK);
        Assert.assertEquals(Connect4Piece.BLACK, user2Piece);

    }

    @Test
    public void goodPick2() throws SymbolAlreadyTakenException, StatusException {
        Connect4Impl connect4 = new Connect4Impl(user1, user2);
        List<Connect4Player> playerList = connect4.getConnect4Player();
        Connect4Player user1 = playerList.get(0);
        Connect4Player user2 = playerList.get(1);

        Connect4Piece user2Piece = connect4.pick(user1, Connect4Piece.RED);
        Assert.assertEquals(Connect4Piece.RED, user2Piece);
        Connect4Piece user1Piece = connect4.pick(user2, Connect4Piece.BLACK);
        Assert.assertEquals(Connect4Piece.BLACK, user1Piece);
    }

    @Test(expected = SymbolAlreadyTakenException.class)
    public void badPick1() throws SymbolAlreadyTakenException, StatusException {
        Connect4Impl connect4 = new Connect4Impl(user1, user2);
        List<Connect4Player> playerList = connect4.getConnect4Player();
        Connect4Player user1 = playerList.get(0);
        Connect4Player user2 = playerList.get(1);

        Connect4Piece user1Piece = connect4.pick(user1, Connect4Piece.RED);
        Assert.assertEquals(Connect4Piece.RED, user1Piece);
        connect4.pick(user2, Connect4Piece.RED);
    }

    @Test(expected = SymbolAlreadyTakenException.class)
    public void badPick2() throws SymbolAlreadyTakenException, StatusException {
        Connect4Impl connect4 = new Connect4Impl(user1, user2);
        List<Connect4Player> playerList = connect4.getConnect4Player();
        Connect4Player user1 = playerList.get(0);
        Connect4Player user2 = playerList.get(1);

        Connect4Piece user2Piece = connect4.pick(user2, Connect4Piece.BLACK);
        Assert.assertEquals(Connect4Piece.BLACK, user2Piece);
        connect4.pick(user1, Connect4Piece.BLACK);
    }

    @Test(expected = StatusException.class)
    public void badPick3() throws SymbolAlreadyTakenException, StatusException {
        Connect4Impl connect4 = new Connect4Impl(user1, user2);
        List<Connect4Player> playerList = connect4.getConnect4Player();
        Connect4Player user1 = playerList.get(0);

        connect4.pick(user1, Connect4Piece.RED);
        Assert.assertEquals(Connect4Piece.RED, user1.getPiece());
        connect4.pick(user1, Connect4Piece.RED);
    }

    @Test(expected = StatusException.class)
    public void badPick4() throws SymbolAlreadyTakenException, StatusException {
        Connect4Impl connect4 = new Connect4Impl(user1, user2);
        List<Connect4Player> playerList = connect4.getConnect4Player();
        Connect4Player user1 = playerList.get(0);

        connect4.pick(user1, Connect4Piece.RED);
        Assert.assertEquals(Connect4Piece.RED, user1.getPiece());
        connect4.pick(user1, Connect4Piece.RED);
    }


    @Test
    public void goodSet1() throws PositionOutsideOfGamefieldException, StatusException, RowIsFullException, GameException, SymbolAlreadyTakenException {
        Connect4Impl connect4 = getConnect4AfterPick();
        Assert.assertEquals(connect4.getLocalBoard().isEmpty());
        List<Connect4Player> playerList = connect4.getConnect4Player();
        Connect4Player user1 = playerList.get(0);
        Connect4Player user2 = playerList.get(1);

        Assert.assertNull(connect4.getLocalBoard().getConnect4BoardPosition(new Connect4BoardPosition(0, 0)));
        connect4.set(user1.getPiece(), new Connect4BoardPosition(0,0 ));
        Assert.assertEquals(connect4.getLocalBoard().getConnect4BoardPosition(0,0), user1.getPiece());

        Assert.assertNull(connect4.getLocalBoard().getConnect4BoardPosition(new Connect4BoardPosition(2,2)));
        connect4.set(user2.getPiece(), new Connect4BoardPosition(2,2));
        Assert.assertEquals(connect4.getLocalBoard().getConnect4BoardPosition(2,2), user2.getPiece());
    }
    @Test
    public void goodSet2() throws PositionOutsideOfGamefieldException, StatusException, RowIsFullException, GameException, SymbolAlreadyTakenException {
        Connect4Impl connect4 = getConnect4AfterPick();
        Assert.assertEquals(connect4.getLocalBoard().isEmpty());
        List<Connect4Player> playerList = connect4.getConnect4Player();
        Connect4Player user1 = playerList.get(0);
        Connect4Player user2 = playerList.get(1);

        Assert.assertNull(connect4.getLocalBoard().getConnect4BoardPosition(new Connect4BoardPosition(0, 0)));
        connect4.set(user1.getPiece(), new Connect4BoardPosition(0,0 ));
        Assert.assertEquals(connect4.getLocalBoard().getConnect4BoardPosition(0, 1), user1.getPiece());

        Assert.assertNull(connect4.getLocalBoard().getConnect4BoardPosition(new Connect4BoardPosition(2,2)));
        connect4.set(user2.getPiece(), new Connect4BoardPosition(2,2));
        Assert.assertEquals(connect4.getLocalBoard().getConnect4BoardPosition(2,2), user2.getPiece());

        Assert.assertNull(connect4.getLocalBoard().getConnect4BoardPosition(new Connect4BoardPosition(4, 2)));
        connect4.set(user1.getPiece(), new Connect4BoardPosition(4,2 ));
        Assert.assertEquals(connect4.getLocalBoard().getConnect4BoardPosition(4, 2), user1.getPiece());

        Assert.assertNull(connect4.getLocalBoard().getConnect4BoardPosition(new Connect4BoardPosition(5,3)));
        connect4.set(user2.getPiece(), new Connect4BoardPosition(5,3));
        Assert.assertEquals(connect4.getLocalBoard().getConnect4BoardPosition(5,3), user2.getPiece());
    }

    @Test(expected = RowIsFullException.class)
    public void setRowIsFull() throws PositionOutsideOfGamefieldException, StatusException, RowIsFullException, GameException, SymbolAlreadyTakenException {
        Connect4Impl connect4 = getConnect4AfterPick();
        List<Connect4Player> playerList = connect4.getConnect4Player();
        Connect4Player user1 = playerList.get(0);
        Connect4Player user2 = playerList.get(1);
        connect4.set(user1.getPiece(), new Connect4BoardPosition(7,0));
        Assert.assertEquals(connect4.getLocalBoard().getConnect4BoardPosition(7,0), user1.getPiece());
        connect4.set(user2.getPiece(), new Connect4BoardPosition(7,0));
    }

    @Test (expected = StatusException.class)
    public void setOutOfBounds() throws PositionOutsideOfGamefieldException, StatusException, GameException, SymbolAlreadyTakenException, RowIsFullException {
        Connect4Impl connect4 = getConnect4AfterPick();
        List<Connect4Player> playerList = connect4.getConnect4Player();
        Connect4Player user1 = playerList.get(0);
        Connect4Player user2 = playerList.get(1);
        connect4.set(user1.getPiece(), new Connect4BoardPosition(10, 0));
    }

    @Test (expected = StatusException.class)
    public void setWrongTurn1() throws PositionOutsideOfGamefieldException, StatusException, GameException, SymbolAlreadyTakenException, RowIsFullException {
        Connect4Impl connect4 = getConnect4AfterPick();
        List<Connect4Player> playerList = connect4.getConnect4Player();
        Connect4Player user1 = playerList.get(0);
        Connect4Player user2 = playerList.get(1);
        connect4.set(user2.getPiece(), new Connect4BoardPosition(1, 0));
    }

    @Test (expected = StatusException.class)
    public void setWrongTurn2() throws PositionOutsideOfGamefieldException, StatusException, GameException, SymbolAlreadyTakenException, RowIsFullException {
        Connect4Impl connect4 = getConnect4AfterPick();
        List<Connect4Player> playerList = connect4.getConnect4Player();
        Connect4Player user1 = playerList.get(0);
        Connect4Player user2 = playerList.get(1);
        connect4.set(user1.getPiece(), new Connect4BoardPosition(1, 0));
        Assert.assertEquals(connect4.getLocalBoard().getConnect4BoardPosition(new Connect4BoardPosition(1,0)));
        connect4.set(user1.getPiece(), new Connect4BoardPosition( 2,0));
    }

    @Test (expected = StatusException.class)
    public void setWrongTurn3() throws PositionOutsideOfGamefieldException, StatusException, GameException, SymbolAlreadyTakenException, RowIsFullException {
        Connect4Impl connect4 = getConnect4AfterPick();
        List<Connect4Player> playerList = connect4.getConnect4Player();
        Connect4Player user1 = playerList.get(0);
        Connect4Player user2 = playerList.get(1);
        connect4.set(user1.getPiece(), new Connect4BoardPosition(1, 0));
        Assert.assertEquals(connect4.getLocalBoard().getConnect4BoardPosition(new Connect4BoardPosition(1,0)));
        connect4.set(user2.getPiece(), new Connect4BoardPosition( 2,0));
        Assert.assertEquals(connect4.getLocalBoard().getConnect4BoardPosition(new Connect4BoardPosition(2,0)));
        connect4.set(user2.getPiece(), new Connect4BoardPosition( 3,0));
    }

    @Test(expected = StatusException.class)
    public void setNotPickedYet() throws PositionOutsideOfGamefieldException, StatusException, GameException, SymbolAlreadyTakenException, RowIsFullException {
        Connect4Impl connect4 = getConnect4AfterPick();
        List<Connect4Player> playerList = connect4.getConnect4Player();
        Connect4Player user1 = playerList.get(0);
        Connect4Player user2 = playerList.get(1);
        connect4.set(user1.getPiece(), new Connect4BoardPosition(0,0 ));
    }


    @Test
    public void setWinVertical() throws RowIsFullException, SymbolAlreadyTakenException, StatusException, GameException {
        Connect4Impl connect4 = getConnect4AfterPick();
        List<Connect4Player> playerList = connect4.getConnect4Player();
        Connect4Player user1 = playerList.get(0);
        Connect4Player user2 = playerList.get(1);
        Assert.assertTrue(user1.getPiece(), !new Connect4BoardPosition(0, 0));
        Assert.assertFalse(user2.getPiece(), new Connect4BoardPosition(1,0));
        Assert.assertFalse(user1.getPiece(), new Connect4BoardPosition(0,1));
        Assert.assertFalse(user2.getPiece(), new Connect4BoardPosition(1,1));
        Assert.assertFalse(user1.getPiece(), new Connect4BoardPosition(0,2));
        Assert.assertFalse(user2.getPiece(), new Connect4BoardPosition(1,2));
        Assert.assertTrue( user1.getPiece(), new Connect4BoardPosition(0,3));
    }

    @Test
    public void setWinDiagonallyRL() throws RowIsFullException, SymbolAlreadyTakenException, StatusException, GameException {
        Connect4Impl connect4 = getConnect4AfterPick();
        List<Connect4Player> playerList = connect4.getConnect4Player();
        Connect4Player user1 = playerList.get(0);
        Connect4Player user2 = playerList.get(1);
        Assert.assertFalse(user1.getPiece(), new Connect4BoardPosition(0,3));
        Assert.assertFalse(user2.getPiece(), new Connect4BoardPosition(1,1));
        Assert.assertFalse(user1.getPiece(), new Connect4BoardPosition(1,2));
        Assert.assertFalse(user2.getPiece(), new Connect4BoardPosition(4,2));
        Assert.assertFalse(user1.getPiece(), new Connect4BoardPosition(2,1));
        Assert.assertFalse(user2.getPiece(), new Connect4BoardPosition(1,3));
        Assert.assertTrue( user1.getPiece(), new Connect4BoardPosition(3,0));
    }
    @Test
    public void setWinDiagonallyLR() throws RowIsFullException, SymbolAlreadyTakenException, StatusException, GameException {
        Connect4Impl connect4 = getConnect4AfterPick();
        List<Connect4Player> playerList = connect4.getConnect4Player();
        Connect4Player user1 = playerList.get(0);
        Connect4Player user2 = playerList.get(1);
        Assert.assertFalse(user1.getPiece(), new Connect4BoardPosition(0,0));
        Assert.assertFalse(user2.getPiece(), new Connect4BoardPosition(1,5));
        Assert.assertFalse(user1.getPiece(), new Connect4BoardPosition(1,1));
        Assert.assertFalse(user2.getPiece(), new Connect4BoardPosition(1,2));
        Assert.assertFalse(user1.getPiece(), new Connect4BoardPosition(2,2));
        Assert.assertFalse(user2.getPiece(), new Connect4BoardPosition(1,3));
        Assert.assertTrue( user1.getPiece(), new Connect4BoardPosition(3,3));
    }

    @Test(expected = GameException.class)
    public void setTie() throws RowIsFullException, StatusException, SymbolAlreadyTakenException, GameException {
        Connect4Impl connect4 = getConnect4AfterPick();
        List<Connect4Player> playerList = connect4.getConnect4Player();
        Connect4Player user1 = playerList.get(0);
        Connect4Player user2 = playerList.get(1);
        /**
         * please imagine I played out a whole game to a tie
         * the whole 42 moves typed out individually...
         * also imagine the test working please
         */
    }

 }



