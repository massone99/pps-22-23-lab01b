package e1;

import e1.board.Board;
import e1.board.BoardImpl;

public class LogicsImpl implements Logics {
    private final Board board;
    private final int boardSize;

    public LogicsImpl(int size) {
        this.board = new BoardImpl(size);
        this.boardSize = size;
    }

    public LogicsImpl(int size, Pair<Integer, Integer> knightPosition, Pair<Integer, Integer> pawnPosition) {
        this.board = new BoardImpl(size, knightPosition, pawnPosition);
        this.boardSize = size;
    }

    @Override
    public boolean hit(int row, int col) {
        checkPositionIsWithinBoundaries(row, col);
        return this.board.moveKnight(new Pair<>(row, col));
    }

    private void checkPositionIsWithinBoundaries(int row, int col) {
        if (row < 0 || col < 0 || row >= this.boardSize || col >= this.boardSize) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public boolean hasKnight(int row, int col) {
        return this.board.getKnightPosition().equals(new Pair<>(row, col));
    }

    @Override
    public boolean hasPawn(int row, int col) {
        return this.board.getPawnPosition().equals(new Pair<>(row, col));
    }
}
