package ru.job4j.changecofe;
import java.util.Arrays;
 /**
 *Выдача сдачи кофемашиной.
 *@author Oleg Zhieten
 *@since 2019
 *@version 2
 */

public class CofeChange {
    /**
     * Выдать сдачу минимальным количеством монет.
     * @param value внесеная сумма.
     * @param price стоимость товара.
     * @return массив с оптимальным колличеством и номиналом монет.
     */

     int[] changes(int value, int price) {
         final int[] COINS = new int[] {10, 5, 2, 1};
         int change = value - price;
         int[] result = new int[change];
         int i = 0;
         for (int coin : COINS) {
             while (change >= coin) {
                 result[i++] = coin;
                 change = change - coin;
             }
         }
         return Arrays.copyOf(result, i);
     }
}