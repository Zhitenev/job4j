package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Test класса SortArray.
 *@author Oleg Zhieten
 *@since 2019
 *@version 1
 */
public class SortArraysTest {
    /**
     * Первый тест когда минимальный в средине а средний в начале.
     */
    @Test
    public void oneSortArrayFromSortArrays() {
        SortArrays arrays = new SortArrays();
        int[] firstArray = new int[] {3, 4, 5, 6};
        int[] secondArray = new int[] {-1, 0, 1, 2};
        int[] thirdArray = new int[] {7, 8, 9, 10};
        int[] result = arrays.oneSortArray(firstArray, secondArray, thirdArray);
        int[] expect = new int[]{-1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertThat(result, is(expect));
    }

    /**
     * Первый тест когда минимальный в средине а средний в начале.
     */
    @Test
    public void twoSortArrayFromSortArrays() {
        SortArrays arrays = new SortArrays();
        int[] firstArray = new int[] {7, 8};
        int[] secondArray = new int[] {9, 10, 11};
        int[] thirdArray = new int[] {1, 3, 4, 5};
        int[] result = arrays.oneSortArray(firstArray, secondArray, thirdArray);
        int[] expect = new int[]{1, 3, 4, 5, 7, 8, 9, 10, 11};
        assertThat(result, is(expect));
    }

    /**
     * Первый тест когда минимальный в конце а средний в начале.
     * А так же разные размеры и дубликаты.
     */
    @Test
    public void threeSortArrayFromSortArrays() {
        SortArrays arrays = new SortArrays();
        int[] firstArray = new int[] {7, 7, 8};
        int[] secondArray = new int[] {8, 9, 10, 11};
        int[] thirdArray = new int[] {0, 1, 3, 4, 5, 6};
        int[] result = arrays.oneSortArray(firstArray, secondArray, thirdArray);
        int[] expect = new int[]{0, 1, 3, 4, 5, 6, 7, 7, 8, 8, 9, 10, 11};
        assertThat(result, is(expect));
    }
}
