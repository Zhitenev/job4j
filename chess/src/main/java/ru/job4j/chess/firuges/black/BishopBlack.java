package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[Math.abs(source.x - dest.x)];
            try {
                if (!Cell.isDiagonal(source, dest)) {
                    throw new ImpossibleMoveException();
                } else {
                    int deltaX = (source.x - dest.x) / Math.abs(source.x - dest.x);
                    int deltaY = (source.y - dest.y) / Math.abs(source.y - dest.y);
                    for (int i = 1; i < steps.length + 1; i++) {
                        steps[i - 1] = Cell.getCell(source.x - deltaX * i, source.y - deltaY * i);
                    }
                }

            } catch (ImpossibleMoveException ime) {
                System.err.print(ime.fillInStackTrace());
            }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
