package ru.job4j.loop;
/**
 *Сумма четных числе в диапазоне.
 *@author Oleg Zhieten
 *@since 2019
 *@version 1
 */
public class Counter {
    /**
     * Цикл суммы четных чисел.
     * @param start начало диапазона.
     * @param finish конец диапазона.
     * @return сумму четных чисел из диапазона.
     */
    public int add(int start, int finish) {
        int rst = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                rst += i;
            }
        }
        return rst;
    }
}