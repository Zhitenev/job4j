package ru.job4j.array;

import java.util.Arrays;
/**
 *Убирает дубликаты из массива.
 *@author Oleg Zhieten
 *@since 2019
 *@version 1
 */
public class ArrayDuplicate {
    public String[] remove(String[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length - count; j++) {
                if (array[i].equals(array[j])) {
                    String tmp = array[array.length - count - 1];
                    array[array.length - count - 1] = array[j];
                    array[j] = tmp;
                    count++;
                }
            }
        }
        return Arrays.copyOf(array, array.length - count);
    }
}