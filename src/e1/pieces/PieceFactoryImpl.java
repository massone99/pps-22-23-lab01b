package e1.pieces;

import e1.Pair;
import e1.pieces.KnightPiece;
import e1.pieces.PawnPiece;
import e1.pieces.PieceFactory;

public class PieceFactoryImpl implements PieceFactory {
    @Override
    public KnightPiece knight(Pair<Integer, Integer> pos) {
        return new KnightPiece(pos);
    }

    @Override
    public PawnPiece pawn(Pair<Integer, Integer> pos) {
        return new PawnPiece(pos);
    }
}
