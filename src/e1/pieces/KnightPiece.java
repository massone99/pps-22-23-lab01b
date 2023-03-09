package e1.pieces;

import e1.Pair;

public class KnightPiece extends AbstractPiece {
    public KnightPiece(Pair<Integer, Integer> position) {
        super(position);
    }

    @Override
    public boolean canMove(Pair<Integer, Integer> position) {
        int x = position.getX() - this.getPosition().getX();
        int y = position.getY() - this.getPosition().getY();
        return x != 0 && y != 0 && Math.abs(x) + Math.abs(y) == 3;
    }
}
