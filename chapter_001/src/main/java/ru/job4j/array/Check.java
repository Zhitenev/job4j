package ru.job4j.array;
/**
 *Проверить массив на однородность.
 *@author Oleg Zhieten
 *@since 2019
 *@version 1
 */
public class Check {
    /**
     * Проверка однородности массива.
     * @param data входной масив.
     * @return результат проверки на однородность.
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] != data[i + 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}