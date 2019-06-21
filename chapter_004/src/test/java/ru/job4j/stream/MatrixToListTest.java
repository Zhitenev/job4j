package ru.job4j.stream;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тестирование класса MatrixToList.
 */
public class MatrixToListTest {
    /**
     * Получаем Лист из двумерного массива.
     */
    @Test
    public void whenCollect6Elem() {
        MatrixToList list = new MatrixToList();
        Integer[][] matrix = {
                {1, 2, 3},
                {2, 3, 5}
        };
        List<Integer> result = list.converToList(matrix);
        assertThat(result.size(), is(6));
    }
    /**
     * Получаем Лист из двумерного массива.
     */
    @Test
    public void whenCollect8Elem() {
        MatrixToList list = new MatrixToList();
        Integer[][] matrix = {
                {1, 2, 3, 4},
                {2, 3, 5, 6}
        };
        List<Integer> result = list.converToList(matrix);
        assertThat(result.size(), is(8));
    }
    /**
     * Получаем Лист из двумерного массива.
     */
    @Test
    public void whenCollect4Elem() {
        MatrixToList list = new MatrixToList();
        Integer[][] matrix = {
                {1, 2},
                {2, 3}
        };
        List<Integer> check = Arrays.asList(1, 2, 2, 3);
        List<Integer> result = list.converToList(matrix);
        assertThat(result, is(check));
    }
}