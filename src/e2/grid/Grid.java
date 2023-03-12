package e2.grid;

import e2.Pair;

import java.util.Set;

public interface Grid {

    Cell getCellAtPosition(Pair<Integer, Integer> position);

    /**
     * Manages the press of a button
     *
     * @param position of the button pressed
     * @return true if there is a mine in position
     * false otherwise
     */
    boolean hitButton(Pair<Integer, Integer> position);

    /**
     * Finds the number of adjacent mines
     *
     * @return number of adjacent mines
     */
    int getAdjacentMines(Pair<Integer, Integer> position);

    Set<Cell> getAdjacentCells(Pair<Integer, Integer> position);

    void flagCell(Pair<Integer, Integer> position);

    boolean isVictory();
}
