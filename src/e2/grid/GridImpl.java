package e2.grid;

import e2.Pair;

import java.util.*;

public class GridImpl implements Grid {

    private final Map<Pair<Integer, Integer>, Cell> cells;
    private final int size;
    private final int numMines;

    public GridImpl(int size, int numMines, Random random) {
        this.size = size;
        this.numMines = numMines;
        this.cells = new LinkedHashMap<>();
        int minesToPlace = numMines;
        Set<Pair<Integer, Integer>> positions = new HashSet<>();
        if (numMines <= size * size) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    Pair<Integer, Integer> position = new Pair<>(i, j);
                    positions.add(position);
                }
            }
            List<Pair<Integer, Integer>> shuffledPositions = new ArrayList<>(positions);
            Collections.shuffle(shuffledPositions, random);
            for (Pair<Integer, Integer> position : shuffledPositions) {
                if (minesToPlace > 0) {
                    this.cells.put(position, new CellImpl(true));
                    minesToPlace--;
                } else {
                    this.cells.put(position, new CellImpl(false));
                }
            }
        } else {
            throw new IllegalArgumentException("Too many mines for the size of the grid");
        }

    }

    @Override
    public Cell getCellAtPosition(Pair<Integer, Integer> position) {
        return this.cells.get(position);
    }

    @Override
    public boolean hitButton(Pair<Integer, Integer> position) {
        Cell cellAtPosition = getCellAtPosition(position);
        boolean isCellAMine = cellAtPosition.isMine();
        if (!isCellAMine) {
            expandRecursively(position, cellAtPosition);
        }
        return isCellAMine;
    }

    private void expandRecursively(Pair<Integer, Integer> position, Cell cellAtPosition) {
        cellAtPosition.expand();
        Set<Cell> adjacentCells = this.getAdjacentCells(position);
        for (Cell adjacentCell : adjacentCells) {
            if (!adjacentCell.isMine() && !adjacentCell.isExpanded()) {
                adjacentCell.expand();
            }
        }
    }

    @Override
    public int getAdjacentMines(Pair<Integer, Integer> position) {
        int adjacentMines = 0;
        for (Cell adjacentCell : this.getAdjacentCells(position)) {
            if (adjacentCell.isMine()) {
                adjacentMines++;
            }
        }
        return adjacentMines;
    }

    @Override
    public Set<Cell> getAdjacentCells(Pair<Integer, Integer> position) {
        Set<Cell> adjacentCells = new HashSet<>();
        for (int i = (position.getX() - 1); i <= (position.getX() + 1); i++) {
            for (int j = (position.getY() - 1); j <= (position.getY() + 1); j++) {
                Pair<Integer, Integer> adjacentPosition = new Pair<>(i, j);
                if (isWithinGrid(adjacentPosition) && !adjacentPosition.equals(position)) {
                    adjacentCells.add(this.getCellAtPosition(adjacentPosition));
                }
            }
        }
        return adjacentCells;
    }

    @Override
    public void flagCell(Pair<Integer, Integer> position) {
        this.cells.get(position).flag();
    }

    @Override
    public boolean isVictory() {
        int expandedCells = (int) this.cells
                .values()
                .stream()
                .filter(Cell::isExpanded)
                .count();
        return expandedCells == (this.size * this.size) - this.numMines;
    }

    private boolean isWithinGrid(Pair<Integer, Integer> position) {
        return (position.getX() >= 0 && position.getY() >= 0) && (position.getX() < size && position.getY() < size);
    }
}
