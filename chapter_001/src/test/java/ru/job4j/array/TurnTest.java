package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Test класса Turn.
 *@author Oleg Zhieten
 *@since 2019
 *@version 1
 */
public class TurnTest {
    /**
     * Перевернем массив с четным количеством элементов.
     */
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turner = new Turn();
        int[] input = new int[] {4, 1, 6, 2};
        int[] result = turner.back(input);
        int[] expect = new int[] {2, 6, 1, 4};
        assertThat(result, is(expect));
    }
    /**
     * Перевернем массив с нечетным количеством элементов.
     */
    @Test
    public void whenTurnArrayWithSevenElements() {
        Turn turner = new Turn();
        int[] input = new int[] {4, 1, 6, 2, 3, 5, 7};
        int[] result = turner.back(input);
        int[] expect = new int[] {7, 5, 3, 2, 6, 1, 4};
        assertThat(result, is(expect));
    }
}