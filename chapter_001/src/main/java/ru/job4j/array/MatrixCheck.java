package ru.job4j.array;
/**
 *Проверка что марица заполнена по диагонали true or false.
 *@author Oleg Zhieten
 *@since 2019
 *@version 1
 */
public class MatrixCheck {
    /**
     * Проверка однородности по диоганали.
     * @param data матрица для проверки.
     * @return результат проверки.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        boolean lineOne = data[0][0];
        boolean lineTwo = data[0][data.length - 1];

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                if (i == j && lineOne != data[i][j] || i + j == data.length - 1 && lineTwo != data[i][j]) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }
}