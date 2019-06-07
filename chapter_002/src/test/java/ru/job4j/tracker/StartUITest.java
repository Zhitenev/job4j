package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 *Тестирование класса StartUI.
 *@author Oleg Zhieten
 *@since 2019
 *@version 2
 */

public class StartUITest {

    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    private static final String MENU = new StringBuilder()
            .append("0. Добавление новой заяки")
            .append(System.lineSeparator())
            .append("1. Показать все заявки")
            .append(System.lineSeparator())
            .append("2. Редактировать заявку")
            .append(System.lineSeparator())
            .append("3. Удалить заявку")
            .append(System.lineSeparator())
            .append("4. Найти заявку по ИД")
            .append(System.lineSeparator())
            .append("5. Найти завки по имени")
            .append(System.lineSeparator())
            .append("6. Выход")
            .append(System.lineSeparator())
            .toString();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }
    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    /**
     * Проверяем добавление заявки.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "n", "6", "y"});
        new StartUI(input, tracker, System.out::println).init();
        assertThat(tracker.findAll().get(0).getName(), is("test name"));
    }
    /**
     * Проверяем редактирование заявки.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "n", "6", "y"});
        new StartUI(input, tracker, System.out::println).init();
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }
    /**
     * Проверяем удаление заявки.
     */
    @Test
    public void whenDeleteThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Item itemTwo = tracker.add(new Item("test name 2", "desc 2"));
        Input input = new StubInput(new String[]{"3", item.getId(), "n", "6", "y"});
        new StartUI(input, tracker, System.out::println).init();
        assertThat(tracker.findAll().get(0).getName(), is(itemTwo.getName()));
    }
    /**
     * Проверяем поиск заявки по ИД.
     */
    @Test
    public void whenFindByIdThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"4", item.getId(), "n", "6", "y"});
        new StartUI(input, tracker, System.out::println).init();
        assertThat(new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(MENU)
                                .append("------------ Поиск заявки по ИД --------------")
                                .append(System.lineSeparator())
                                .append("--- ИД заявки : " + item.getId() + " --- Имя завки:test name --- Описание:desc")
                                .append(System.lineSeparator())
                                .append(MENU)
                                .toString()
                )
        );
    }
    /**
     * Проверяем показать все заявки.
     */
    @Test
    public void whenFindFindAllThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"1", "n", "6", "y"});
        new StartUI(input, tracker, System.out::println).init();
        assertThat(new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(MENU)
                                .append("--- ИД заявки : " + item.getId() + " --- Имя завки:test name --- Описание:desc")
                                .append(System.lineSeparator())
                                .append(MENU)
                                .toString()
                )
        );
    }
    /**
     * Проверяем поиск по имени.
     */
    @Test
    public void whenFindFindNameThenTrackerHasUpdatedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("test name", "desc"));
        Input input = new StubInput(new String[]{"5", "test name", "n", "6", "y"});
        new StartUI(input, tracker, System.out::println).init();
        assertThat(new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(MENU)
                                .append("------------ Поиск заявок по имени --------------")
                                .append(System.lineSeparator())
                                .append("------------ Найденые заявки --------------")
                                .append(System.lineSeparator())
                                .append("--- ИД заявки : " + item.getId() + " --- Имя завки:test name --- Описание:desc")
                                .append(System.lineSeparator())
                                .append(MENU)
                                .toString()
                )
        );
    }
}