package e1;

public class KnightPiece extends AbstractPiece {
    public KnightPiece(Pair<Integer, Integer> position) {
        super(position);
    }

    @Override
    boolean canMove(int x, int y) {
        return x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3;
    }
}
