package e2.grid;

public interface Cell {
    boolean isMine();

    boolean isExpanded();

    void expand();

    void flag();

    boolean isFlagged();
}
