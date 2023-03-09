package e1;

import e1.board.Board;
import e1.board.BoardImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        int SIZE = 5;
        this.board = new BoardImpl(SIZE, new Pair<>(0, 0), new Pair<>(2, 1));
    }

    @Test
    void testGetPosition() {
        Pair<Integer, Integer> knightPos = this.board.getKnightPosition();
        assertNotNull(knightPos);
        Pair<Integer, Integer> pawnPos = this.board.getPawnPosition();
        assertNotNull(pawnPos);
    }

    @Test
    void testMoveKnight() {
        Pair<Integer, Integer> knightPos = this.board.getKnightPosition();
        Pair<Integer, Integer> pawnPos = this.board.getPawnPosition();
        assertTrue(this.board.moveKnight(pawnPos));
    }
}
