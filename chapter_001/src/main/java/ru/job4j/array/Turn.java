package ru.job4j.array;
/**
 *Перевернуть массив.
 *@author Oleg Zhieten
 *@since 2019
 *@version 1
 */
public class Turn {
    /**
     * Метод переворачивает массив.
     * При нечетных числах array.length / 2 делится со статком, но так как используем int остаток сгорает.
     * @param array входящий массив.
     * @return перевернутый массив.
     */
    public int[] back(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int tmp = array[array.length - i - 1];
            array[array.length - i - 1] = array [i];
            array[i] = tmp;
        }
        return array;
    }
}