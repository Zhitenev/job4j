package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 *Реализация класса Меню трекера.
 *@author Oleg Zhieten
 *@since 2019
 *@version 2
 */
public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();
    /**
     *
     */
    private final Consumer<String> output;
    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem(0, "Добавление новой заяки"));
        this.actions.add(new ShowItem(1, "Показать все заявки"));
        this.actions.add(new EditItem(2, "Редактировать заявку"));
        this.actions.add(new DeleteItem(3, "Удалить заявку"));
        this.actions.add(new FindIdItem(4, "Найти заявку по ИД"));
        this.actions.add(new FindNameItem(5, "Найти завки по имени"));
        this.actions.add(new ExitProgram(6, "Выход"));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                output.accept(action.info());
            }
        }
    }

    private class ShowItem extends BaseAction {

        public ShowItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.findAll()) {
                output.accept(item.toString());
            }
        }
    }

    private class AddItem extends BaseAction {

        public AddItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            tracker.add(new Item(name, desc));
        }
    }

    private class EditItem extends BaseAction {

        public EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Редактирование заявки --------------");
            String id = input.ask("Введите ИД заявки");
            String name = input.ask("Введите новое имя заявки :");
            String desc = input.ask("Введите новое описание заявки :");
            Item item = new Item(name, desc);
            if (tracker.replace(id, item)) {
                output.accept("------------ Заявка успешкно отредактированна --------------");
            } else {
                output.accept("------------ Неверный ИД --------------");
            }
        }
    }

    private class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Удаление заявки --------------");
            String id = input.ask("Введите ИД заявки");

            if (tracker.delete(id)) {
                output.accept("------------ Заявка успешкно удалена --------------");
            } else {
                output.accept("------------ Неверный ИД --------------");
            }
        }
    }

    private class FindIdItem extends BaseAction {

        public FindIdItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {

            output.accept("------------ Поиск заявки по ИД --------------");
            String id = input.ask("Введите ИД заявки");
            Item item = tracker.findById(id);
            if (item != null) {
                output.accept(item.toString());
            } else {
                output.accept("------------ Неверный ИД --------------");
            }
        }
    }

    private class FindNameItem extends BaseAction {

        public FindNameItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            output.accept("------------ Поиск заявок по имени --------------");
            String name = input.ask("Введите имя заявки");
            List<Item> tmp = tracker.findByName(name);
            output.accept("------------ Найденые заявки --------------");
            for (Item item : tmp) {
                output.accept(item.toString());
            }
        }
    }

    private class ExitProgram extends BaseAction {

        public ExitProgram(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {

        }
    }
}