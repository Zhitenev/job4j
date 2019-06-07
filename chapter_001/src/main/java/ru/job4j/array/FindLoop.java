package ru.job4j.array;
/**
 *Поиск в массиве.
 *@author Oleg Zhieten
 *@since 2019
 *@version 1
 */
public class FindLoop {
    /**
     * Поиск индекса элемента.
     * @param data массив данных.
     * @param el имя элемента.
     * @return индекс искомого элемента либо -1 в случае отсутствия элемента.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }

}