package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Преобрзование матрицы в список.
 */
public class MatrixToList {
    /**
     * Конвертирует матрицу числе в список.
     * @param matrix входящяя матрица.
     * @return список элементов матрицы.
     */
    public List<Integer> converToList(Integer[][] matrix) {
        return Arrays.stream(matrix).flatMap(e -> Stream.of(e)).collect(Collectors.toList());
    }
}