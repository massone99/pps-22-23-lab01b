package e1;

public class PieceFactoryImpl implements PieceFactory {
    @Override
    public KnightPiece knight() {
        return new KnightPiece(new Pair<>(0,0));
    }

    @Override
    public PawnPiece pawn() {
        return new PawnPiece(new Pair<>(0,0));
    }
}
