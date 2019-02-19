package ru.job4j.array;
/**
 *Сортировка массива пузырьком.
 *@author Oleg Zhieten
 *@since 2019
 *@version 1
 */
public class BubbleSort {
    /**
     * Сортировка массива пузырьком.
     * @param array неотсортированный массив.
     * @return отсортированный массив.
     */
    public Integer[] sortByBubble(Integer[] array) {
        int size = array.length - 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }
}