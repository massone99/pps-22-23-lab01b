package e1;

import java.util.*;

public class BoardImpl implements Board {
    private final Random random = new Random();
    private final PieceFactory pieceFactory;
    private KnightPiece knight;
    private PawnPiece pawn;
    private final int size;

    public BoardImpl(int size) {
        this.size = size;
        pieceFactory = new PieceFactoryImpl();
        addKnightToRandomPosition();
        addPawnToRandomPosition();
    }

    private void addKnightToRandomPosition() {
        Pair<Integer, Integer> randomEmptyPosition = this.getRandomEmptyPosition();
        this.knight = this.pieceFactory.knight(randomEmptyPosition);
    }

    private void addPawnToRandomPosition() {
        Pair<Integer, Integer> randomEmptyPosition = this.getRandomEmptyPosition();
        this.pawn = this.pieceFactory.pawn(randomEmptyPosition);
    }

    @Override
    public Pair<Integer, Integer> getKnightPosition() {
        return this.knight.getPosition();
    }

    @Override
    public Pair<Integer, Integer> getPawnPosition() {
        return this.pawn.getPosition();
    }

    @Override
    public boolean setKnightPosition(Pair<Integer, Integer> pos) {
        if (isPositionEmpty(pos)) {
            if (this.knight.canMove(pos)) {
                this.knight.setPosition(pos);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setPawnPosition(Pair<Integer, Integer> pos) {
        if (isPositionEmpty(pos)) {
            // IMPORTANT: the pawn cannot move in this context
            if (this.pawn.canMove(pos)) {
                this.pawn.setPosition(pos);
                return true;
            }
        }
        return false;
    }

    private boolean isPositionEmpty(Pair<Integer, Integer> pos) {
        if (this.knight != null && this.pawn != null) {
            return !(this.knight.getPosition().equals(pos) || this.pawn.getPosition().equals(pos));
        } else {
            return true;
        }
    }

    private Pair<Integer, Integer> getRandomEmptyPosition() {
        Pair<Integer, Integer> pos = new Pair<>(this.random.nextInt(size), this.random.nextInt(size));
        boolean isValid = isPositionEmpty(pos);
        return isValid ? pos : getRandomEmptyPosition();
    }
}
