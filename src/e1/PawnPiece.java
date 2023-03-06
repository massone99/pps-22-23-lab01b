package e1;

/**
 * A class modelling a Pawn.
 * For my purposes, it cannot be moved
 */
public class PawnPiece extends AbstractPiece {
    public PawnPiece(Pair<Integer, Integer> position) {
        super(position);
    }

    @Override
    boolean canMove(int x, int y) {
        return false;
    }
}
