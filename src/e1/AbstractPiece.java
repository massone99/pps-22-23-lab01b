package e1;

public abstract class AbstractPiece {

    private Pair<Integer, Integer> position;

    public AbstractPiece(Pair<Integer, Integer> position) {
        this.position = position;
    }

    void move(Pair<Integer, Integer> position) {
        if (canMove(position)) {
            this.position = position;
        }
    }

    abstract boolean canMove(Pair<Integer, Integer> position);

    public Pair<Integer, Integer> getPosition() {
        return this.position;
    }

    public void setPosition(Pair<Integer, Integer> position) {
    	this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractPiece that)) return false;

        return position.equals(that.position);
    }

    @Override
    public int hashCode() {
        return position.hashCode();
    }
}
