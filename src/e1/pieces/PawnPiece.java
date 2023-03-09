package e1.pieces;

import e1.Pair;
import e1.pieces.AbstractPiece;

/**
 * A class modelling a Pawn.
 * For my purposes, it cannot be moved
 */
public class PawnPiece extends AbstractPiece {
    public PawnPiece(Pair<Integer, Integer> position) {
        super(position);
    }

    @Override
    public boolean canMove(Pair<Integer, Integer> position) {
        return false;
    }
}
