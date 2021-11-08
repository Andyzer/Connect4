package connect4;

public class CodeDump {

    /**

     Kommt aus Connect4Impl
     *
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
}
