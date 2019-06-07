package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;
/**
 *Реализация класса конвертация ArrayList в двухмерный массив.
 *@author Oleg Zhieten
 *@since 2019
 *@version 3
 */
public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = (list.size() / rows) + 1;
        int r = 0;
        int c = 0;
        int[][] array = new int[rows][cells];
        for (Integer tmp : list) {
            if (r != rows + 1 && c != cells) {
                array[r][c++] = tmp;
            } else {
                c = 0;
                r++;
                array[r][c++] = tmp;
            }
        }
        return array;
    }

    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
            for (int[] lists : list) {
                for (int tmp : lists) {
                    result.add(tmp);
                }
            }
        return result;
    }
}