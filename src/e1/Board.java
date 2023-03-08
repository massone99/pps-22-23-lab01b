package e1;

/**
 * An interface for a chess board.
 * The board manages the pieces on it and their positions.
 */
public interface Board {

    Pair<Integer, Integer> getKnightPosition();

    Pair<Integer, Integer> getPawnPosition();

    boolean setKnightPosition(Pair<Integer, Integer> pos);

    boolean setPawnPosition(Pair<Integer, Integer> pos);

}
