package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class LogicsTest {

    private final int SIZE = 4;
    private Pair<Integer, Integer> knight = new Pair<>(1, 1);
    private Pair<Integer, Integer> pawn = new Pair<>(3, 0);

    private List<Pair<Integer, Integer>> allowedMoves;
    private Logics logic;

    @BeforeEach
    void setUp() {
        this.logic = new LogicsImpl(SIZE, knight, pawn);
        this.allowedMoves = findAllowedMoves();
    }

    @Test
    void testHit() {
        Random rand = new Random();
        // Take a random allowed move
        Pair<Integer, Integer> move = allowedMoves.get(rand.nextInt(this.allowedMoves.size()));
        assertFalse(this.logic.hit(move.getX(), move.getY()));
    }

    @Test
    void testHitPawn() {
        assertTrue(this.logic.hit(this.pawn.getX(), this.pawn.getY()));
    }

    @Test
    void testHitWithOutOfBoundPosition() {
        Pair<Integer, Integer> notAllowedMove = new Pair<>(-1, -1);
        assertThrows(IndexOutOfBoundsException.class,
                () -> this.logic.hit(notAllowedMove.getX(), notAllowedMove.getY()));
    }

    @Test
    void testHasKnight() {
        assertTrue(this.logic.hasKnight(this.knight.getX(), this.knight.getY()));
    }

    @Test
    void testHasPawn() {
        assertTrue(this.logic.hasPawn(this.pawn.getX(), this.pawn.getY()));
    }

    private boolean isMoveAllowed(int row, int col) {
        int x = row - this.knight.getX();
        int y = col - this.knight.getY();
        return x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3;
    }

    private List<Pair<Integer, Integer>> findAllowedMoves() {
        List<Pair<Integer, Integer>> allowedMoves = new ArrayList<>();
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (isMoveAllowed(row, col)) {
                    allowedMoves.add(new Pair<>(row, col));
                }
            }
        }
        return allowedMoves;
    }
}