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
     * @param ask информация о запросе.
     * @return данные от пользователя
     */
    public String ask(String ask) {
        System.out.print(ask);
        return sc.nextLine();
    }
}