package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {

    private final int SIZE = 5;
    private Board board;

    @BeforeEach
    void setUp() {
        this.board = new BoardImpl(SIZE);
    }

    @Test
    void testBoardInit() {
        Pair<Integer, Integer> knightPos = this.board.getKnightPosition();
        assertNotNull(knightPos);
        Pair<Integer, Integer> pawnPos = this.board.getPawnPosition();
        assertNotNull(pawnPos);
    }

    @Test
    void testMovePieceToOccupiedPosition() {
        Pair<Integer, Integer> pawnPos = this.board.getPawnPosition();
        Pair<Integer, Integer> knightPos = this.board.getKnightPosition();
        this.board.setKnightPosition(pawnPos);
        assertEquals(knightPos, this.board.getKnightPosition());
    }
}
