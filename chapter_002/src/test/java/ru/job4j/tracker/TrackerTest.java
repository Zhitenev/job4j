package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 *Тестирование класса Tracker.
 *@author Oleg Zhieten
 *@since 2019
 *@version 2
 */

public class TrackerTest {
    /**
     * Тест добавления заявки.
     */
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1","testDescription",created);
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    /**
     * Тест удаления заявки.
     */
    @Test
    public void whenDeleteItemFromTracker() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1","testDescription",created);
        Item itemTwo = new Item("test2","testDescription2",created);
        Item itemThree = new Item("test3","testDescription3",created);
        tracker.add(item);
        tracker.add(itemTwo);
        tracker.add(itemThree);
        tracker.delete(itemTwo.getId());
        assertThat(tracker.findAll()[tracker.findAll().length - 1].getName(), is("test3"));
    }

    /**
     * Тест изменения заявки.
     */
    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1","testDescription",123L);
        tracker.add(previous);
        Item next = new Item("test2","testDescription2",1234L);
        next.setId(previous.getId());
        tracker.replace(previous.getId(), next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    /**
     * Тест удаления заявки.
     */
    @Test
    public void whenDeleteItemFromTrackerTwo() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1","testDescription",created);
        Item itemTwo = new Item("test2","testDescription2",created);
        Item itemThree = new Item("test3","testDescription3",created);
        Item itemFour = new Item("test4","testDescription4",created);
        tracker.add(item);
        tracker.add(itemTwo);
        tracker.add(itemThree);
        tracker.add(itemFour);
        tracker.delete(itemThree.getId());
        assertThat(tracker.findAll()[tracker.findAll().length - 1].getName(), is("test4"));
    }

    /**
     * Тест удаления заявки.
     */
    @Test
    public void whenDeleteItemFromTrackerThree() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1","testDescription",created);
        Item itemTwo = new Item("test2","testDescription2",created);
        Item itemThree = new Item("test3","testDescription3",created);
        Item itemFour = new Item("test4","testDescription4",created);
        tracker.add(item);
        tracker.add(itemTwo);
        tracker.add(itemThree);
        tracker.add(itemFour);
        tracker.delete(item.getId());
        assertThat(tracker.findAll()[0].getName(), is("test2"));
    }

    /**
     * Тест удаления заявки.
     */
    @Test
    public void whenDeleteItemFromTrackerFour() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1","testDescription",created);
        Item itemTwo = new Item("test2","testDescription2",created);
        Item itemThree = new Item("test3","testDescription3",created);
        Item itemFour = new Item("test4","testDescription4",created);
        tracker.add(item);
        tracker.add(itemTwo);
        tracker.add(itemThree);
        tracker.add(itemFour);
        tracker.delete(itemFour.getId());
        assertThat(tracker.findAll()[tracker.findAll().length - 1].getName(), is("test3"));
    }

    /**
     * Тест получение всех имеющихся заявок.
     */
    @Test
    public void whenFindAllItemFromTracker() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1","testDescription",created);
        Item itemTwo = new Item("test2","testDescription2",created);
        Item itemThree = new Item("test3","testDescription3",created);
        Item itemFour = new Item("test4","testDescription4",created);
        tracker.add(item);
        tracker.add(itemTwo);
        tracker.add(itemThree);
        tracker.add(itemFour);
        assertThat(tracker.findAll().length, is(4));
    }

    /**
     * Тест получение по имени имеющихся заявок.
     */
    @Test
    public void whenFindByNameItemFromTracker() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1","testDescription",created);
        Item itemTwo = new Item("test2","testDescription2",created);
        Item itemThree = new Item("test1","testDescription3",created);
        Item itemFour = new Item("test4","testDescription4",created);
        tracker.add(item);
        tracker.add(itemTwo);
        tracker.add(itemThree);
        tracker.add(itemFour);
        assertThat(tracker.findByName("test1").length, is(2));
    }

    /**
     * Тест получение по ид имеющихся заявок.
     */
    @Test
    public void whenFindByIdItemFromTracker() {
        Tracker tracker = new Tracker();
        long created = System.currentTimeMillis();
        Item item = new Item("test1","testDescription",created);
        Item itemTwo = new Item("test2","testDescription2",created);
        Item itemThree = new Item("test1","testDescription3",created);
        Item itemFour = new Item("test4","testDescription4",created);
        tracker.add(item);
        tracker.add(itemTwo);
        tracker.add(itemThree);
        tracker.add(itemFour);
        assertThat(tracker.findById(itemTwo.getId()).getName(), is("test2"));
    }
}
