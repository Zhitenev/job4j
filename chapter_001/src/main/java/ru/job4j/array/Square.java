package ru.job4j.array;
/**
 *Заполняем массив числами возведеными в квадрат.
 *@author Oleg Zhieten
 *@since 2019
 *@version 1
 */
public class Square {
    /**
     * Заполнение массива числами возведеными в квадрат.
     * @param bound размер массива.
     * @return заполненый массив.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
       for (int i = 1; i <= bound; i++) {
           rst[i - 1] = i * i;
       }
        return rst;
    }
}