package e1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceFactoryTest {

    private PieceFactory pieceFactory;

    @BeforeEach
    void setUp() {
        this.pieceFactory = new PieceFactoryImpl();
    }

    @Test
    void testCreateKnight() {
        AbstractPiece knight = this.pieceFactory.knight(new Pair<>(0,0));
        assertNotNull(knight);
    }


    @Test
    void testCreatePawn() {
        AbstractPiece pawn = this.pieceFactory.pawn(new Pair<>(0,0));
        assertNotNull(pawn);
    }
}