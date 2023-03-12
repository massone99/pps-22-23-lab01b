package e2.grid;

public class CellImpl implements Cell {
    private final boolean isMine;
    private boolean isExpanded;
    private boolean flag;

    public CellImpl(boolean isMine) {
        this.isMine = isMine;
        this.isExpanded = false;
        this.flag = false;
    }

    @Override
    public boolean isMine() {
        return isMine;
    }

    @Override
    public boolean isExpanded() {
        return this.isExpanded;
    }

    @Override
    public void expand() {
        this.isExpanded = true;
    }

    @Override
    public void flag() {
        this.flag = !this.flag;
    }

    @Override
    public boolean isFlagged() {
        return this.flag;
    }
}
