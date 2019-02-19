package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Test класса BubbleSort.
 *@author Oleg Zhieten
 *@since 2019
 *@version 1
 */
public class BubbleSortTest {
    /**
     * Тест сортировки пузырьком.
     */
    @Test
    public void whenArrayHave5Item() {
        BubbleSort bub = new BubbleSort();
        Integer[] unSortArray = {5, 1, 2, 7, 3};
        Integer[] rst = bub.sortByBubble(unSortArray);
        Integer[] sortArray = {1, 2, 3, 5, 7};
        assertThat(rst, is(sortArray));
    }
    /**
     * Тест сортировки пузырьком.
     */
    @Test
    public void whenArrayHave9Item() {
        BubbleSort bub = new BubbleSort();
        Integer[] unSortArray = {5, 1, 2, 7, 3, 0, 10, 8, 4};
        Integer[] rst = bub.sortByBubble(unSortArray);
        Integer[] sortArray = {0, 1, 2, 3, 4, 5, 7, 8, 10};
        assertThat(rst, is(sortArray));
    }
}