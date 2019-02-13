package ru.job4j.loop;
/**
 *Факториал.
 *@author Oleg Zhieten
 *@since 2019
 *@version 1
 */
public class Factorial {
    /**
     * Расчет факториала.
     * @param n число для расчета факториала.
     * @return факториал.
     */
    public int calc(int n) {
        int rst = 1;
        for (int i = 0; i <= n; i++) {
            if (i != 0) {
                rst *= i;
            }
        }
        return rst;
    }
}