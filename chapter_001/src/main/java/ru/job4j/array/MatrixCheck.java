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
        for (int i = 0; i < data.length; i++) {
                if (data[0][0] != data[i][i] || data[0][data.length - 1] != data[data.length - 1 - i][i]) {
                    result = false;
                    break;
                }
            }
        return result;
    }
}