package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Рализация итерации двумерного массива.
 *@author Oleg Zhieten
 *@since 2019
 *@version 2
 */
public class IteratorArr implements Iterator {
    private int[][] values;
    private int index = 0;
    private int nes = 0;

    public IteratorArr(int[][] values) {
        this.values = values;
    }

    /**
     * Проверка возможности следующей итерации.
     * @return вероятность сдвига.
     */
    @Override
    public boolean hasNext() {
        boolean result;
        if (this.values.length == 0) {
            result = false;
        } else if (nes == values.length - 1 & index == values[values.length - 1].length) {
            result = false;
        } else {
            result = values[nes].length >= index;
        }
        return result;
    }

    /**
     * Получаем элемент и переводим коретку.
     * @return следующий элемент.
     */
    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        } else if (!(values[nes].length > index)) {
            this.nes++;
            this.index = 0;
        }
        return values[nes][index++];
    }
}