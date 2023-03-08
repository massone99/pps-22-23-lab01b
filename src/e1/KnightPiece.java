package e1;

public class KnightPiece extends AbstractPiece {
    public KnightPiece(Pair<Integer, Integer> position) {
        super(position);
    }

    @Override
    boolean canMove(Pair<Integer, Integer> position) {
        int x = position.getX();
        int y = position.getY();
        return x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3;
    }
}
