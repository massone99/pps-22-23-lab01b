package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//TODO: extend tests
public class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        int SIZE = 5;
        this.board = new BoardImpl(SIZE);
    }

    @Test
    void testBoardInit() {
        Pair<Integer, Integer> knightPos = this.board.getKnightPosition();
        assertNotNull(knightPos);
        Pair<Integer, Integer> pawnPos = this.board.getPawnPosition();
        assertNotNull(pawnPos);
    }
}
