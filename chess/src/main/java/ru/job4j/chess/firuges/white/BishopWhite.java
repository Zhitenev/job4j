package ru.job4j.chess.firuges.white;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 *
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopWhite implements Figure {
    private final Cell position;

    public BishopWhite(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        Cell[] steps = new Cell[Math.abs(source.x - dest.x)];
        int deltaX  = (source.x - dest.x) / Math.abs(source.x - dest.x);
        int deltaY  = (source.y - dest.y) / Math.abs(source.y - dest.y);
        for (int i = 1; i < steps.length + 1; i++) {
            steps[i - 1] = Cell.getCell(source.x - deltaX * i, source.y - deltaY * i);
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopWhite(dest);
    }
}
