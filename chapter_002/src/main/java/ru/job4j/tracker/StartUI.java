package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 *Реализация класса с основным модулем майн и иницализацией.
 *@author Oleg Zhieten
 *@since 2019
 *@version 2
 */
public class StartUI {
    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;
    /**
     *
     */
    private final Consumer<String> output;

    /**
     * Конструтор инициализирующий поля.
     *
     * @param input   ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, output);
        List<Integer> range = new ArrayList<>();
        menu.fillActions();
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            range.add(i);
        }
        int[] rangeInt = new int[range.size()];
        for (int j = 0; j < range.size(); j++) {
            rangeInt[j] = range.get(j);
        }
        do {
            menu.show();
            menu.select(input.ask("Выбирете:", rangeInt));
        } while (!"y".equals(this.input.ask("Выход?(y): ")));
    }

    /**
     * Запускт программы.
     *
     * @param args входные аргументы.
     */
    public static void main(String[] args) {
        new StartUI(
                new ValidateInput(
                        new ConsoleInput()
                ),
                new Tracker(),
                System.out::println
        ).init();
    }
}
