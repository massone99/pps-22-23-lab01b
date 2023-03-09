package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LogicsTest {

    private Logics logic;
    private final Pair<Integer, Integer> pawnPosition = new Pair<>(2, 1);
    private final Pair<Integer, Integer> knightPosition = new Pair<>(0, 0);

    @BeforeEach
    void setUp() {
        int SIZE = 4;
        this.logic = new LogicsImpl(SIZE, knightPosition, pawnPosition);
    }

    @Test
    void testHit() {
        assertFalse(this.logic.hit(1, 2));
    }

    @Test
    void testHitPawn() {
        assertTrue(this.logic.hit(pawnPosition.getX(), pawnPosition.getY()));
    }

    @Test
    void testHitWithOutOfBoundPosition() {
        Pair<Integer, Integer> notAllowedMove = new Pair<>(-1, -1);
        assertThrows(IndexOutOfBoundsException.class, () -> this.logic.hit(notAllowedMove.getX(), notAllowedMove.getY()));
    }

    @Test
    void testHasKnight() {
        assertTrue(this.logic.hasKnight(knightPosition.getX(), knightPosition.getY()));
    }

    @Test
    void testHasPawn() {
        assertTrue(this.logic.hasPawn(pawnPosition.getX(), pawnPosition.getY()));
    }
}