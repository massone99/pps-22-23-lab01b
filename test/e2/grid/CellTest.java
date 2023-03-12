package e2.grid;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    private Cell cell;

    @BeforeEach
    void setUp() {
        boolean isMine = true;
        this.cell = new CellImpl(isMine);
    }

    @Test
    void testIsMine() {
        boolean result = cell.isMine();
        assertTrue(result);
    }

    @Test
    void testCellIsExpanded() {
        this.cell.expand();
        boolean isClicked = this.cell.isExpanded();
        assertTrue(isClicked);
    }

    @Test
    void testIsFlagged() {
        this.cell.flag();
        boolean isFlagged = this.cell.isFlagged();
        assertTrue(isFlagged);
    }
}