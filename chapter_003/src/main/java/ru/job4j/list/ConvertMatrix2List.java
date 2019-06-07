package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 *Реализация класса конвертация двумерного массива в ArrayList.
 *@author Oleg Zhieten
 *@since 2019
 *@version 3
 */

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] arrays : array) {
            for (Integer tmp : arrays) {
                list.add(tmp);
            }
        }
        return list;
    }
}