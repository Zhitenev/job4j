package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Test класса FindLoop.
 *@author Oleg Zhieten
 *@since 2019
 *@version 1
 */
public class FindLoopTest {
    /**
     * Поиск по имени в массиве.
     */
    @Test
    public void whenArrayHasLengh5Then0() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }
    /**
     * Поиск по имени в массиве.
     */
    @Test
    public void whenArrayHasLengh7Then3() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3, 7, 4, 1};
        int value = 7;
        int result = find.indexOf(input, value);
        int expect = 3;
        assertThat(result, is(expect));
    }
    /**
     * Поиск по имени в массиве, когда элемент отсутствует и ожидаем -1.
     */
    @Test
    public void whenArrayHasLengh9ThenMinus1() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {5, 10, 3, 7, 4, 1};
        int value = 9;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }
}