package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import ru.job4j.tracker.StartUI.*;

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
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
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
        this.actions.add(new StartUI.DeleteItem(3, "Удалить заявку"));
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
                System.out.println(action.info());
            }
        }
    }
}