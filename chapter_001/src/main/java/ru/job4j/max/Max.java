package ru.job4j.max;
/**
 *Нахождение максимума.
 *@author Oleg Zhieten
 *@since 2019
 *@version 1
 */
public class Max {
    /**
     * Нахождение максимума.
     * @param first первый аргумент.
     * @param second второй аргумент.
     * @return возвращаемый параметр.
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }

    /**
     * Нахождение максимума из 3х.
     * @param first первый аргумент.
     * @param second второй аргумент.
     * @param third третий аргумент.
     * @return максимум из 3х.
     */
    public int max(int first, int second, int third) {
        return max(first, max(second, third));
    }
}