package ru.job4j.changecofe;

 /**
 *Выдача сдачи кофемашиной.
 *@author Oleg Zhieten
 *@since 2019
 *@version 2
 */

import java.util.Arrays;

public class CofeChange {
    /**
     * Выдать сдачу минимальным количеством монет.
     * @param value внесеная сумма.
     * @param price стоимость товара.
     * @return массив с оптимальным колличеством и номиналом монет.
     */
    int[] changes(int value, int price) {
        int change = value - price;
        int[] result = new int[change];
        int j = 0;
        for (int i = 0; i < value; i++) {
            if ((change - 10) >= 0 || (change - 10) == 1) {
                result[i] = 10;
                change = change - 10;
                j++;
            } else if ((change - 5) >= 0) {
                result[i] = 5;
                change = change - 5;
                j++;
            } else if ((change - 2) >= 0 & change != 1) {
                result[i] = 2;
                change = change - 2;
                j++;
            } else if ((change - 1) == 0) {
                result[i] = 1;
                j++;
                break;
            }
        }
        return Arrays.copyOf(result, j);
    }
}
