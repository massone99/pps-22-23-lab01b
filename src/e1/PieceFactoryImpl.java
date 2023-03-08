package e1;

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
