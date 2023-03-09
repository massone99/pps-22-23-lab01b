package e1;

import e1.pieces.KnightPiece;
import e1.pieces.PieceFactory;
import e1.pieces.PieceFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class KnightPieceTest {

    private KnightPiece knightPiece;
    private Pair<Integer, Integer> initialPosition;


    @BeforeEach
    void setUp() {
        initialPosition = new Pair<>(0, 0);
        PieceFactory pieceFactory = new PieceFactoryImpl();
        this.knightPiece = pieceFactory.knight(initialPosition);
    }

    @Test
    void testPosition() {
        assertEquals(initialPosition, this.knightPiece.getPosition());
    }

    @Test
    void testCanMove() {
        Pair<Integer, Integer> testPosition = new Pair<>(2, 1);
        assertEquals(isMoveAllowed(testPosition.getX(), testPosition.getY()),this.knightPiece.canMove(new Pair<>(testPosition.getX(), testPosition.getY())));
    }

    private boolean isMoveAllowed(int row, int col) {
        int x = row - this.knightPiece.getPosition().getX();
        int y = col - this.knightPiece.getPosition().getY();
        return x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3;
    }
}