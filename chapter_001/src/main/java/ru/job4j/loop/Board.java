package ru.job4j.loop;
/**
 *Построение шахмотной доски.
 *@author Oleg Zhieten
 *@since 2019
 *@version 1
 */
public class Board {
    /**
     * Построение шахмотной доски произвольного размера.
     * @param width ширина.
     * @param height высота.
     * @return символьная доска.
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}