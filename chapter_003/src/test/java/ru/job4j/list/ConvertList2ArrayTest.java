package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                List.of(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when15ElementsThen4() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15),
                4
        );
        int[][] expect = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void whenConvertThen() {
        ConvertList2Array list = new ConvertList2Array();
        List<int[]> arrays = new ArrayList<>(
                List.of(
                        new int[]{1, 2},
                        new int[]{3, 4, 5, 6}
                )
        );
        List<Integer> result = list.convert(arrays);
        List<Integer> expect = List.of(1, 2, 3, 4, 5, 6);
        assertThat(result, is(expect));
    }

    @Test
    public void whenConvertThreeThen() {
        ConvertList2Array list = new ConvertList2Array();
        List<int[]> arrays = new ArrayList<>(
                List.of(
                        new int[]{1, 2},
                        new int[]{3, 4, 5, 6},
                        new int[]{7, 8, 9}
                )
        );
        List<Integer> result = list.convert(arrays);
        List<Integer> expect = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(result, is(expect));
    }
}