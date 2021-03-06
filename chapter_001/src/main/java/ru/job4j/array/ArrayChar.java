package ru.job4j.array;
/**
 *Проверяет. что слово начинается с префикса.
 *@author Oleg Zhieten
 *@since 2019
 *@version 1
 */
public class ArrayChar {
    /**
     * Массив символов слова.
     */
    private char[] data;

    /**
     * Преобразование слова в массив символов.
     * @param line преобразуемое слово.
     */
    public ArrayChar(String line) {
        this.data = line.toCharArray();
    }

    /**
     * Проверяет. что слово начинается с префикса.
     * @param prefix префикс.
     * @return если слово начинается с префикса
     */
    public boolean startWith(String prefix) {
        boolean result = true;
        char[] value = prefix.toCharArray();
        for (int i = 0; i < value.length; i++) {
            if (value[i] != data[i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}