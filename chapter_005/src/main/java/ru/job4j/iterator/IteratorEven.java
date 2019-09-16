package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Рализация итерации массива по четным числам.
 *@author Oleg Zhieten
 *@since 2019
 *@version 2
 */
public class IteratorEven implements Iterator {

    private int[] values;
    private int index = 0;

    public IteratorEven(int[] values) {
        this.values = values;
    }

    /**
     * Проверка возможности следующей итерации.
     * @return вероятность сдвига.
     */
    @Override
    public boolean hasNext() {
        boolean result = false;
        for (int i = index; i < values.length; i++) {
            if (values[i] % 2 == 0) {
                this.index = i;
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Получаем элемент и переводим коретку.
     * @return следующий элемент.
     */
    @Override
    public Object next() {
        if (hasNext()) {
            return values[index++];
        }
        throw new NoSuchElementException();
    }

    /**
     * Метод remove без реализации.
     */
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}