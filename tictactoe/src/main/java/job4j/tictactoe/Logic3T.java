package job4j.tictactoe;

import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }

    public boolean isWinnerX() {

        return isDiagonal(Figure3T::hasMarkX) || monoLine(Figure3T::hasMarkX);
    }

    public boolean isWinnerO() {
        return isDiagonal(Figure3T::hasMarkO) || monoLine(Figure3T::hasMarkO);
    }

    public boolean hasGap() {
        return canMove();
    }

    /**
     * Проверяем однородность диагоналей.
     * @param predicate признак однородности.
     * @return однородны или нет.
     */
    public boolean isDiagonal(Predicate<Figure3T> predicate) {
        return fillBy(predicate, 0,0, 1,1) || fillBy(predicate, 0,table.length - 1, 1,-1);
    }

    /**
     * Проверяем есть ли однородные поля по линиям.
     * @param predicate признак однородности.
     * @return однородны или нет.
     */
    public boolean monoLine(Predicate<Figure3T> predicate) {
        boolean result = false;
            for (int i = 0; i < table.length; i++) {
               if (fillBy(predicate, i, 0, 0, 1)) {
                   result = true;
                   break;
               }
                if (fillBy(predicate, 0, i, 1, 0)) {
                    result = true;
                    break;
                }
            }
        return result;
    }

    /**
     * Проверяем наличие свободных полей.
     * @return возможен ход или нет.
     */
    public boolean canMove() {
        boolean result = true;
        int count = 0;
        for (int i = 0; i <= table.length - 1; i++) {
            for (int j = 0; j <= table.length - 1; j++) {
                if (table[i][j].hasMarkX()) {
                    count++;
                }
                if (table[i][j].hasMarkO()) {
                    count++;
                }
            }
        }
        if (count == Math.pow(table.length, 2)) {
            result = false;
        }
        return result;
    }
}