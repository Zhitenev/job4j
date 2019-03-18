package ru.job4j.tracker;

import java.util.Scanner;

/**
 *Реализация класса ввода пользовательских данных.
 *@author Oleg Zhieten
 *@since 2019
 *@version 2
 */
public class ConsoleInput implements Input {
    private Scanner sc = new Scanner(System.in);

    /**
     * Реализация интерфейса Input и опрос пользователя.
     * @param question информация о запросе.
     * @return данные от пользователя
     */
    public String ask(String question) {
        System.out.print(question);
        return sc.nextLine();
    }

    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Введите значение из меню.");
        }
    }
}