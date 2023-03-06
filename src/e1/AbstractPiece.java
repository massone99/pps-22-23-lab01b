package e1;

public abstract class AbstractPiece {

    Pair<Integer, Integer> position;

    public AbstractPiece(Pair<Integer, Integer> position) {
        this.position = position;
    }

    void move(int x, int y) {
        if (canMove(x, y)) {
            this.position = new Pair<>(x, y);
        }
    }

    abstract boolean canMove(int x, int y);

    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }
}
