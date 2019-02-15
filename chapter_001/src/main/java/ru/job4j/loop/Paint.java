package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 *Отрисовка пирамиды.
 *@author Oleg Zhieten
 *@since 2019
 *@version 1
 */
public class Paint {
    /**
     * Построение правой стороны треугольника используя лямды.
     * @param height высота треугольника.
     * @return псеводографическая фигура.
     */
    public String rightTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= column
        );
    }
    /**
     * Построение левой стороны треугольника используя лямды.
     * @param height высота треугольника.
     * @return псеводографическая фигура.
     */
    public String leftTrl(int height) {
        return this.loopBy(
                height,
                height,
                (row, column) -> row >= height - column - 1
        );
    }
    /**
     * Построение треугольника используя лямды.
     * @param height высота треугольника.
     * @return псеводографическая фигура.
     */
    public String pyramid(int height) {
        return this.loopBy(
                height,
                2 * height - 1,
                (row, column) -> row >= height - column - 1 && row + height - 1 >= column
        );
    }

    /**
     * Реальзация построния с использованием дженериков.
     * @param height высота построения.
     * @param widht ширина для передачи в лямды.
     * @param predict выполнение условий.
     * @return псефтографическая фигура.
     */
    private String loopBy(int height, int widht, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != widht; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}