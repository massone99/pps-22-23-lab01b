package e1.board;

import e1.Pair;
import e1.pieces.KnightPiece;
import e1.pieces.PawnPiece;
import e1.pieces.PieceFactory;
import e1.pieces.PieceFactoryImpl;

import java.util.Random;

public class BoardImpl implements Board {
    private final Random random = new Random();
    private final PieceFactory pieceFactory;
    private final KnightPiece knight;
    private final PawnPiece pawn;
    private final int size;

    /**
     * This constructor assigns the knight and the pawn to random
     * empty positions
     *
     * @param size is size of the board
     */
    public BoardImpl(int size) {
        this.size = size;
        pieceFactory = new PieceFactoryImpl();
        this.knight = this.pieceFactory.knight(getRandomEmptyPosition());
        this.pawn = this.pieceFactory.pawn(getRandomEmptyPosition());
        System.out.println("Knight: " + this.knight.getPosition());
        System.out.println("Pawn: " + this.pawn.getPosition());
    }

    /**
     * This constructor assigns the knight and pawn to predetermined positions
     *
     * @param size           is the size of the board
     * @param knightPosition is the position of the knight
     * @param pawnPosition   is the position of the pawn
     */
    public BoardImpl(int size, Pair<Integer, Integer> knightPosition, Pair<Integer, Integer> pawnPosition) {
        this.size = size;
        pieceFactory = new PieceFactoryImpl();
        this.knight = this.pieceFactory.knight(knightPosition);
        this.pawn = this.pieceFactory.pawn(pawnPosition);
    }

    public Pair<Integer, Integer> getKnightPosition() {
        return this.knight.getPosition();
    }

    public Pair<Integer, Integer> getPawnPosition() {
        return this.pawn.getPosition();
    }

    @Override
    public boolean moveKnight(Pair<Integer, Integer> position) {
        if (this.knight.canMove(position)) {
            System.out.println("Knight: " + this.knight.getPosition());
            this.knight.setPosition(position);
            return this.pawn.getPosition().equals(position);
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
