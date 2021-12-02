package connect4main;

/**
 * Game starts, player one picks a color
 * Players alternate turns, starting with the first who picked
 * Game ends
 */

public enum Status {
    START_GAME,
    ONE_PICKED,
    REDS_TURN,
    BLACKS_TURN,
    GAME_OVER,
}
