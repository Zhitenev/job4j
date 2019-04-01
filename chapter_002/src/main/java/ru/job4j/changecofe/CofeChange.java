package ru.job4j.changecofe;
/**
 *Выдача сдачи кофемашиной.
 */

import java.util.Arrays;

public class CofeChange {
    int[] changes(int value, int price) {
        int change = value - price;
        int[] result = new int[change];
        int j = 0;
        for (int i = 0; i < price; i++) {
            if ((change - 10) >= 6) {
                result[i] = 10;
                change = change - 10;
                j++;
            } else if ((change - 5) >= 3) {
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
    public static void main(String[] args) {
        CofeChange cofeChange = new CofeChange();
        int[] out = cofeChange.changes(73, 35);
        for (int tmp: out) {
            System.out.println(tmp);
        }
    }
}
