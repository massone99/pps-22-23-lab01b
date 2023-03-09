package e1.pieces;

import e1.Pair;
import e1.pieces.KnightPiece;
import e1.pieces.PawnPiece;

public interface PieceFactory {

    KnightPiece knight(Pair<Integer, Integer> pos);

    PawnPiece pawn(Pair<Integer, Integer> pos);
}
