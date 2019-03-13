package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 *Реализация класса Tracker объекты для работы с хранилищем Items.
 *@author Oleg Zhieten
 *@since 2019
 *@version 2
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        item.setTime(System.currentTimeMillis());
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Удаление заявки по id.
     * @param id ид искомой заявки.
     * @return результат выполениея.
     */
    public boolean delete(String id) {
        boolean result = false;
        int i = 0;
        Item[] tmp = new Item[100];
        for (Item item: this.items) {
            if (id != null && id.equals(item.getId())) {
                System.arraycopy(this.items, i + 1 , tmp, 0, position);
                System.arraycopy(tmp, 0, this.items, i, position - 1);
                this.items[--position] = null;
                result = true;
                break;
            }
            i++;
        }
        return result;
    }

    /**
     * Изменение итема целиком.
     * @param id индетификатор итема.
     * @param item Заменяемый итем.
     * @return результат.
     */
    public boolean replace(String id, Item item) {
        boolean result = false;

        for (int i = 0; i < position; i++) {
            if (id != null && id.equals(this.items[i].getId())){
                item.setId(this.items[i].getId());
                item.setTime(this.items[i].getTime());
                this.items[i] = item;
                result = true;
                break;
            }
        }
        return result;
    }
    /**
     * Поиск Item по его ID.
     * @param id строка с генерированным уникальным индетификатором.
     * @return искомый элемент.
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item: this.items) {
            if (id != null && id.equals(item.getId())){
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Поиск элементов по имени заявки.
     * @param key имя заявки.
     * @return элементы с искомым именем.
     */
    public Item[] findByName(String key) {
        Item[] res = new Item[position];
        int j = 0;
        for (int i = 0; i < position; i++) {
            if (key != null && key.equals(this.items[i].getName())){
                res[j++] = this.items[i];
            }
        }

        return Arrays.copyOf(res, j);
    }

    /**
     * Возвращаем массив Итемов без пустых элементов.
     * @return Возвращаем не пустой массив.
     */
    public Item[] findAll() {
        int i = 0;
        for (Item item: this.items) {
            if (item == null) {
                break;
            }
            i++;
        }
        return Arrays.copyOf(this.items, i);
    }
    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random RN = new Random();
        return String.valueOf(System.currentTimeMillis() + RN.nextInt(100));
    }
}