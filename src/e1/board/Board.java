package e1.board;

import e1.Pair;

/**
 * An interface for a chess board.
 * The board manages the pieces on it and their positions.
 */
public interface Board {

    Pair<Integer, Integer> getKnightPosition();

    Pair<Integer, Integer> getPawnPosition();

    boolean moveKnight(Pair<Integer, Integer> position);
}
