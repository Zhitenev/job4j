package ru.job4j.comparator;

import java.util.Comparator;

/**
 *Реализация класса Компаратор для строк.
 *@since 2019
 *@version 3
 */
public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int size = left.length() < right.length() ? left.length() : right.length();
            for (int i = 0; i < size; i++) {
                result = Character.compare(left.charAt(i), right.charAt(i));
                if (result != 0) {
                    break;
                }
            }
            if (result == 0 && left.length() != right.length()) {
                result = -1;
            }
        return result;
    }
}