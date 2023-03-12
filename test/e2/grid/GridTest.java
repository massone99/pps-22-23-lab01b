package e2.grid;

import e2.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {

    private Grid grid;
    private final int SIZE = 5;
    private final int numMines = 10;

    @BeforeEach
    void setUp() {
        final Random random = new Random(123);
        this.grid = new GridImpl(SIZE, numMines, random);
    }

    @Test
    void testGetCell() {
        Cell cell = grid.getCellAtPosition(new Pair<>(0, 0));
        assertNotNull(cell);
    }

    @Test
    void testNumMinesIsCorrect() {
        int foundMines = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (this.grid.getCellAtPosition(new Pair<>(i, j)).isMine()) {
                    foundMines++;
                }
            }
        }
        assertEquals(numMines, foundMines);
    }

    @Test
    void testGetAdjacentCells() {
        Pair<Integer, Integer> testPosition = new Pair<>(0,0);
        final int numAdjacentCells = 3;
        assertEquals(numAdjacentCells, this.grid.getAdjacentCells(testPosition).size());
    }

    @Test
    void testCellsAroundExpandedAreExpanded() {
        Pair<Integer, Integer> testPosition = new Pair<>(0,0);
        this.grid.hitButton(testPosition);
        for (Cell cell : this.grid.getAdjacentCells(testPosition)) {
            if (!cell.isMine()) {
                assertTrue(cell.isExpanded());
            } else {
                assertFalse(cell.isExpanded());
            }
        }
    }

    @Test
    void testAdjacentMines() {
        Pair<Integer, Integer> testPosition = new Pair<>(1, 1);
        final int numAdjacentCells = 2;
        assertEquals(numAdjacentCells, this.grid.getAdjacentMines(testPosition));
    }

    @Test
    void testFlagCell() {
        Pair<Integer, Integer> testPosition = new Pair<>(1, 1);
        this.grid.flagCell(testPosition);
        assertTrue(this.grid.getCellAtPosition(testPosition).isFlagged());
        this.grid.flagCell(testPosition);
        assertFalse(this.grid.getCellAtPosition(testPosition).isFlagged());
    }

    @Test
    void testIsVictory () {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                Pair<Integer, Integer> testPosition = new Pair<>(i, j);
                if (!(this.grid.getCellAtPosition(testPosition).isMine())) {
                    this.grid.hitButton(testPosition);
                }
            }
        }
        assertTrue(this.grid.isVictory());
    }
}