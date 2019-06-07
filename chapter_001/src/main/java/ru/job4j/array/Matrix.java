package ru.job4j.array;
/**
 *Таблица умножения из двумерного массива.
 *@author Oleg Zhieten
 *@since 2019
 *@version 1
 */
public class Matrix {
    /**
     * Формирует двумерный массив в вииде таблици умножения.
     * @param size размер массива.
     * @return двумерный массив в виде таблицы умножения.
     */
    int[][] multiple(int size) {
        int[][] table = new int[size][size];
            for (int i = 1; i <= size; i++) {
                for (int j = 1; j <= size; j++) {
                    table[i - 1][j - 1] = i * j;
                }
            }
        return table;
    }
}
