package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KnightPieceTest {

    private KnightPiece knightPiece;
    private PieceFactory pieceFactory;

    @BeforeEach
    void setUp() {
        this.pieceFactory = new PieceFactoryImpl();
        this.knightPiece = this.pieceFactory.knight();
    }

    @Test
    void canMove() {

    }

    @Test
    void testPosition() {
        assertEquals(new Pair<>(0,0), this.knightPiece.getPosition());
    }

    /*private List<Pair<Integer, Integer>> findAllowedMoves() {
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

    private boolean isMoveAllowed(int row, int col) {
        int x = row - this.knight.getX();
        int y = col - this.knight.getY();
        return x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3;
    }*/
}