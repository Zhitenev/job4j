package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

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
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
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
     * @param args входные аргументы.
     */
    public static void main(String[] args) {
        new StartUI(
                new ValidateInput(
                        new ConsoleInput()
                ),
                new Tracker()
        ).init();
    }

    public static class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            tracker.add(new Item(name, desc));
        }
    }

    public static class ShowItem extends BaseAction {

        public ShowItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item: tracker.findAll()) {
                System.out.println(item);
            }
        }
    }

    public static class EditItem extends BaseAction {

        public EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Редактирование заявки --------------");
            String id = input.ask("Введите ИД заявки");
            String name = input.ask("Введите новое имя заявки :");
            String desc = input.ask("Введите новое описание заявки :");
            Item item = new Item(name, desc);
            if (tracker.replace(id, item)) {
                System.out.println("------------ Заявка успешкно отредактированна --------------");
            } else {
                System.out.println("------------ Неверный ИД --------------");
            }
        }
    }

    public static class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Удаление заявки --------------");
            String id = input.ask("Введите ИД заявки");

            if (tracker.delete(id)) {
                System.out.println("------------ Заявка успешкно удалена --------------");
            } else {
                System.out.println("------------ Неверный ИД --------------");
            }
        }
    }

    public static class FindIdItem extends BaseAction {

        public FindIdItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {

            System.out.println("------------ Поиск заявки по ИД --------------");
            String id = input.ask("Введите ИД заявки");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(item);
            } else {
                System.out.println("------------ Неверный ИД --------------");
            }
        }
    }

    public static class FindNameItem extends BaseAction {

        public FindNameItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявок по имени --------------");
            String name = input.ask("Введите имя заявки");
            Item[] tmp = tracker.findByName(name);
            System.out.println("------------ Найденые заявки --------------");
            for (Item item : tmp) {
                System.out.println(item);
            }
        }
    }

    public static class ExitProgram extends BaseAction {

        public ExitProgram(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {

        }
    }
}