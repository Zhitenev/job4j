package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Рализация работы с простым массивом и возможностью работы с разными типами данных.
 *@author Oleg Zhieten
 *@since 2019
 *@version 2
 */
public class SimpleArray<T> implements Iterable<T> {
    private Object[] objects;
    private int position = 0;

    /**
     * Конструктор создания массива заполненого неопередленным типом данных.
     * @param size размер массива.
     */
    SimpleArray(int size) {
        this.objects = new Object[size];
    }

    /**
     * Добавление элемента в массив.
     * @param value добавляемый элемент.
     */
    void add(T value) {
        this.objects[this.position++] = value;
    }

    /**
     * Замена элемента массива.
     * @param index индекс заменяемой ячейки.
     * @param value новое значение.
     */
    void set(int index, T value) {
        if (index < this.position) {
            this.objects[index] = value;
        }
    }

    /**
     * Получение элемента массива.
     * @param index индекс необходимого значения.
     * @return значение в данном индексе.
     */
    T get(int index) {
        return (T) this.objects[index];
    }

    /**
     * Удаление элемента массива со смещением.
     * @param index индекс удаляемого элемента.
     */
    void remove(int index) {
        if (index < this.position) {
            System.arraycopy(this.objects, index + 1, this.objects, index, this.objects.length - 1 - index);
        }
        this.objects[objects.length - 1] = null;
        this.position--;
    }

    /**
     * Реализация Iterable.
     * @return  возвращает итератор для массива с неопределенным типом данных.
     */
    @Override
     public Iterator<T> iterator() {
        return new SimpleArrayIterator();
    }

    /**
     * Реализация итератора.
     */
    class SimpleArrayIterator implements Iterator<T> {
        private int count = 0;
        /**
         * Переопределение метода hasNext.
         * @return возможно смещение или нет.
         */
        @Override
        public boolean hasNext() {
            return count < position;
        }

        /**
         * Переопредиление метода next.
         * @return смещает коректку или выдает ошибку что не существует ячейки.
         */
        @Override
        public T next() {
            if (hasNext()) {
                return (T) objects[this.count++];
            }
            throw new NoSuchElementException();
        }
    }
}

