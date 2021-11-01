package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import java.util.Arrays;

import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void currentPosition() {
        Cell expected = Cell.C8;
        BishopBlack bishopBlack = new BishopBlack(expected);
        Cell actual = bishopBlack.position();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void copyBishop() {
        Cell expected = Cell.C8;
        BishopBlack bishopBlack = new BishopBlack(expected);
        Figure figure = bishopBlack.copy(Cell.E6);
        Assert.assertEquals(figure.position(), Cell.E6);
    }

    @Test
    public void wayOk() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C3);
        Cell[] expected = new Cell[]{Cell.B2, Cell.A1};
        Cell[] actual = bishopBlack.way(Cell.A1);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void wayNoOk() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C3);
        Cell[] actual = bishopBlack.way(Cell.A2);
    }
}