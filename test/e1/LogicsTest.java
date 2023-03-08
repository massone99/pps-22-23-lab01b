package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class LogicsTest {

    private final int SIZE = 4;

    private KnightPiece knight;
    private PawnPiece pawn;

    private Board board;

    private List<Pair<Integer, Integer>> allowedMoves;
    private Logics logic;

    @BeforeEach
    void setUp() {
        this.logic = new LogicsImpl(SIZE);
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
        Pair<Integer, Integer> pawnPos = this.board.getPawnPosition();
        assertTrue(this.logic.hit(pawnPos.getX(), pawnPos.getY()));
    }

    @Test
    void testHitWithOutOfBoundPosition() {
        Pair<Integer, Integer> notAllowedMove = new Pair<>(-1, -1);
        assertThrows(IndexOutOfBoundsException.class, () -> this.logic.hit(notAllowedMove.getX(), notAllowedMove.getY()));
    }

    @Test
    void testHasKnight() {
        Pair<Integer, Integer> knightPos = this.board.getKnightPosition();
        assertTrue(this.logic.hasKnight(knightPos.getX(), knightPos.getY()));
    }

    @Test
    void testHasPawn() {
        Pair<Integer, Integer> pawnPos = this.board.getPawnPosition();
        assertTrue(this.logic.hasPawn(pawnPos.getX(), pawnPos.getY()));
    }

    private boolean isMoveAllowed(int row, int col) {
        Pair<Integer, Integer> knightPos = this.board.getKnightPosition();
        int x = row - knightPos.getX();
        int y = col - knightPos.getY();
        return x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3;
    }

}