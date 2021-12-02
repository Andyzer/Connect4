package connect4main;

public class CodeDump {

    /**

     Kommt aus Connect4Impl
     *
     @Override public boolean set(Connect4Piece piece, Connect4BoardPosition position)
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
     */

    /**
     *
     * Kommt aus Tests
     *
     * As of right now, I am not sure how this is supposed to turn out
     * Work in progress
     * will get back to it soon
     *
     @Test public void setConnect4() throws RowIsFullException, GameException, StatusException {
     }

     @Test public void notYourTurn() throws StatusException {
     try {
     setConnect4();
     } catch (Exception e) {
     }
     }

     @Test public void rowIsFull() throws RowIsFullException {
     try {
     setConnect4();
     } catch (Exception e) {

     }
     }

     @Test public void colorIsTaken() throws StatusException {
     try {

     } catch (Exception e) {

     }

     }
     */


    /**
     * Kommt aus Impl
     *
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
     */

    /**@Test(expected = PositionOutsideOfGamefieldException.class)
    public void setRowIsFull() throws PositionOutsideOfGamefieldException, StatusException, GameException, SymbolAlreadyTakenException, RowIsFull {
    Connect4Impl connect4 = (Connect4Impl) getConnect4AfterPick();

    Connect4LocalBoard localBoard = connect4.set(user1.getPiece(), new Connect4BoardPosition(0,0));
    Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(0,0)), user1.getPiece());
    connect4.set(user2.getPiece(), new Connect4BoardPosition(0,1));
    Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(0,1)), user2.getPiece());
    connect4.set(user1.getPiece(), new Connect4BoardPosition(0,2));
    Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(0,2)), user1.getPiece());
    connect4.set(user2.getPiece(), new Connect4BoardPosition(0,3));
    Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(0,3)), user2.getPiece());
    connect4.set(user1.getPiece(), new Connect4BoardPosition(0,4));
    Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(0,4)), user1.getPiece());
    connect4.set(user2.getPiece(), new Connect4BoardPosition(0,5));
    Assert.assertEquals(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(0,5)), user2.getPiece());
    connect4.set(user1.getPiece(), new Connect4BoardPosition(0,6)) ;
    }
     */

    /**
     *  private boolean winnig(int row, Connect4Piece piece) {
     *         int counter = 0;
     *         for (int i = 0; i < 6; i++) {
     *             if(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(i, row)) == piece) {
     *
     *             }
     *         }
     *         if (counter == 4) {
     *             return true;
     *         }
     *         return false;
     *     }
     *
     */

    /**
     * private boolean youWonColumn(int column, Connect4Piece piece) {
     *         int counter = 0;
     *         for (int i = 0; i < 7; i++) {
     *             if(localBoard.getConnect4BoardPosition(new Connect4BoardPosition(column, i)) == piece) {
     *                 counter++;
     *             }
     *         }
     *
     *         if (counter == 4) {
     *             return true;
     *         }
     *         return false;
     *     }
     *
     *     private boolean youWonDiagonallyLR() {
     *         return false;
     *     }
     *
     *     private boolean youWonDiagonallyRL() {
     *         return false;
     *     }
     */

}
