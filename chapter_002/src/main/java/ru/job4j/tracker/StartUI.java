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
    private static final Integer ADD = 0;
    /**
     * Константа меню для отображения всех заявок.
     */
    private static final Integer SHOWALL = 1;
    /**
     * Константа меню для отображения всех заявок.
     */
    private static final Integer EDIT = 2;
    /**
     * Константа меню для удаления заявоки.
     */
    private static final Integer DELETE = 3;
    /**
     * Константа меню для поиска заявоки по ид.
     */
    private static final Integer FINDID = 4;
    /**
     * Константа меню для поиска заявоки по ид.
     */
    private static final Integer FINDNAME = 5;
    /**
     * Константа для выхода из цикла.
     */
    private static final Integer EXIT = 6;
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
        menu.fillActions();
        do {
            menu.show();
            menu.select(Integer.valueOf(input.ask("Выбирете:")));
        } while (!"y".equals(this.input.ask("Выход?(y): ")));
    }

    /**
     * Запускт программы.
     * @param args входные аргументы.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }

    public static class AddItem implements UserAction {
        @Override
        public int key() {
            return ADD;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Добавление новой заявки --------------");
            String name = input.ask("Введите имя заявки :");
            String desc = input.ask("Введите описание заявки :");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ Новая заявка с getId : " + item.getId() + "-----------");
        }

        @Override
        public String info() {
            return "0. Добавление новой заяки";
        }
    }

    public static class ShowItem implements UserAction {
        @Override
        public int key() {
            return SHOWALL;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item: tracker.findAll()) {
                System.out.println("--- ИД заявки : " + item.getId() + " --- Имя завки:" + item.getName() + " --- Описание:" + item.getDesc());
            }
        }

        @Override
        public String info() {
            return "1. Показать все заявки";
        }
    }

    public static class EditItem implements UserAction {
        @Override
        public int key() {
            return EDIT;
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

        @Override
        public String info() {
            return "2. Редактировать заявку";
        }
    }

    public static class DeleteItem implements UserAction {
        @Override
        public int key() {
            return DELETE;
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

        @Override
        public String info() {
            return "3. Удалить заявку";
        }
    }

    public static class FindIdItem implements UserAction {
        @Override
        public int key() {
            return FINDID;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            Item item;
            System.out.println("------------ Поиск заявки по ИД --------------");
            String id = input.ask("Введите ИД заявки");
            if ((item = tracker.findById(id)) != null) {
                System.out.println("--- ИД заявки : " + item.getId() + " --- Имя завки:" + item.getName() + " --- Описание:" + item.getDesc());
            } else {
                System.out.println("------------ Неверный ИД --------------");
            }
        }

        @Override
        public String info() {
            return "4. Найти заявку по ИД";
        }
    }

    public static class FindNameItem implements UserAction {
        @Override
        public int key() {
            return FINDNAME;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявок по имени --------------");
            String name = input.ask("Введите имя заявки");
            Item[] tmp = tracker.findByName(name);
            System.out.println("------------ Найденые заявки --------------");
            for (Item item : tmp) {
                System.out.println("--- ИД заявки : " + item.getId() + " --- Имя завки:" + item.getName() + " --- Описание:" + item.getDesc());
            }
        }

        @Override
        public String info() {
            return "5. Найти завки по имени";
        }
    }

    public static class ExitProgram implements UserAction {
        @Override
        public int key() {
            return EXIT;
        }

        @Override
        public void execute(Input input, Tracker tracker) {

        }

        @Override
        public String info() {
            return "6. Выход";
        }
    }
}