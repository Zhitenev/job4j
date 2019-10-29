package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicList<T> implements Iterable<Object> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] objects = new Object[DEFAULT_CAPACITY];
    private int position = 0;

    void add(T value) {
            this.getMoreSize();
            this.objects[position++] = value;
    }

    T get(int index) {
        return (T) this.objects[index];
    }

    Integer size() {
        return this.position;
    }

    private void getMoreSize() {
        if (objects.length <= position) {
            this.objects = Arrays.copyOf(this.objects, this.position + DEFAULT_CAPACITY);
        }
    }

    /**
     * Реализация Iterable.
     * @return  возвращает итератор для массива с неопределенным типом данных.
     */
    @Override
    public Iterator<Object> iterator() {
        return new DynamicList.DynamicListIterator();
    }

    /**
     * Реализация итератора.
     */
    class DynamicListIterator implements Iterator<T> {
        /**
         * Переопределение метода hasNext.
         * @return возможно смещение или нет.
         */
        private int expectedModCount = 0;
        @Override
        public boolean hasNext() {
            return expectedModCount < position;
        }

        /**
         * Переопредиление метода next.
         * @return смещает коректку или выдает ошибку что не существует ячейки.
         */
        @Override
        public T next() {
            if (hasNext()) {
                if (expectedModCount >= position) {
                  throw new ConcurrentModificationException();
                }
                return (T) objects[expectedModCount++];
            }
            throw new NoSuchElementException();
        }
    }
}
