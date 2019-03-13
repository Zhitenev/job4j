package ru.job4j.tracker;
/**
 *Реализация класса с основным модулем майн и иницализацией.
 *@author Oleg Zhieten
 *@since 2019
 *@version 2
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final String ADD = "0";
    /**
     * Константа меню для отображения всех заявок.
     */
    private static final String SHOWALL = "1";
    /**
     * Константа меню для отображения всех заявок.
     */
    private static final String EDIT = "2";
    /**
     * Константа меню для удаления заявоки.
     */
    private static final String DELETE = "3";
    /**
     * Константа меню для поиска заявоки по ид.
     */
    private static final String FINDID = "4";
    /**
     * Константа меню для поиска заявоки по ид.
     */
    private static final String FINDNAME = "5";
    /**
     * Константа для выхода из цикла.
     */
    private static final String EXIT = "6";
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
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                this.createItem();
            } else if (SHOWALL.equals(answer)) {
                this.showItem();
            } else if (EDIT.equals(answer)) {
                this.editItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FINDID.equals(answer)) {
                this.findIdItem();
            } else if (FINDNAME.equals(answer)) {
                this.findNameItem();
            } else if (EXIT.equals(answer)) {
                exit = true;
            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void showItem() {
        for (Item item: this.tracker.findAll()) {
            System.out.println("--- ИД заявки : " + item.getId() + " --- Имя завки:" + item.getName() + " --- Описание:" + item.getDecs());
        }
    }

    /**
     * Метод реализует редактирование заявки в хранилище.
     */
    private void editItem() {
        System.out.println("------------ Редактирование заявки --------------");
        String id = this.input.ask("Введите ИД заявки");
        String name = this.input.ask("Введите новое имя заявки :");
        String desc = this.input.ask("Введите новое описание заявки :");
        Item item = new Item(name, desc);
        if (this.tracker.replace(id, item)) {
            System.out.println("------------ Заявка успешкно отредактированна --------------");
        } else {
            System.out.println("------------ Неверный ИД --------------");
        }
    }

    /**
     * Метод реализует удаления заявки из хранилище.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите ИД заявки");

        if (this.tracker.delete(id)) {
            System.out.println("------------ Заявка успешкно удалена --------------");
        } else {
            System.out.println("------------ Неверный ИД --------------");
        }
    }

    /**
     * Метод реализует поиск заявки в хранилище по ИД.
     */
    private void findIdItem() {
        System.out.println("------------ Поиск заявки по ИД --------------");
        String id = this.input.ask("Введите ИД заявки");
        if (this.tracker.findById(id) != null) {
            Item item = this.tracker.findById(id);
            System.out.println("--- ИД заявки : " + item.getId() + " --- Имя завки:" + item.getName() + " --- Описание:" + item.getDecs());
        } else {
            System.out.println("------------ Неверный ИД --------------");
        }
    }

    /**
     * Метод реализует поиск заявок в хранилище по имени.
     */
    private void findNameItem() {
        System.out.println("------------ Поиск заявок по имени --------------");
        String name = this.input.ask("Введите имя заявки");
        Item[] tmp = this.tracker.findByName(name);
        System.out.println("------------ Найденые заявки --------------");
        for (Item item : tmp) {
            System.out.println("--- ИД заявки : " + item.getId() + " --- Имя завки:" + item.getName() + " --- Описание:" + item.getDecs());
        }

    }

    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Добавление новой заяки");
        System.out.println("1. Показать все заявки");
        System.out.println("2. Редактировать заявку");
        System.out.println("3. Удалить заявку");
        System.out.println("4. Найти заявку по ИД");
        System.out.println("5. Найти завки по имени");
        System.out.println("6. Выход");
    }

    /**
     * Запускт программы.
     * @param args входные аргументы.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}