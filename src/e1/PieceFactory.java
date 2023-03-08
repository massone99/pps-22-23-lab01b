package e1;

public interface PieceFactory {

    KnightPiece knight(Pair<Integer, Integer> pos);

    PawnPiece pawn(Pair<Integer, Integer> pos);
}
