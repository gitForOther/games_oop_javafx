package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }

    @Override
    public Cell[] way(Cell dest) {
        if (!this.isDiagonal(this.position, dest)) {
            throw new ImpossibleMoveException(
                    String.format("Could not way by diagonal from %s to %s", position, dest));
        }
        int x = this.position.getX();
        int y = this.position.getY();
        int deltaX = dest.getX() - x;
        int deltaY = dest.getY() - y;
        int size = Math.abs(deltaX);
        Cell[] steps = new Cell[size];
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(deltaX < 0 ? --x : ++x, deltaY < 0 ? --y : ++y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        if (Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY())) {
            return true;
        }
        return false;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
