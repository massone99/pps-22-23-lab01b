package e1;

public class LogicsImpl implements Logics {
    private final Board board;
    private final int size;

    public LogicsImpl(int size) {
        this.size = size;
        this.board = new BoardImpl(size);
    }

    @Override
    public boolean hit(int row, int col) {
        if (row < 0 || col < 0 || row >= this.size || col >= this.size) {
            throw new IndexOutOfBoundsException();
        }
        Pair<Integer, Integer> knightPosition = this.board.getKnightPosition();
        if (this.board.setKnightPosition(new Pair<>(row, col))) {
            return this.board.getPawnPosition().equals(knightPosition);
        }
        return false;
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
