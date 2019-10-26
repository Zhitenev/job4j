package ru.job4j.list;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynamicList<T> implements Iterable<Object> {
    private static final int DEFAULT_CAPACITY = 10;
    private static int modCount = 0;
    private Object[] objects = new Object[DEFAULT_CAPACITY];
    private int index = 0;

    void add(T value) {
            this.getMoreSize();
            this.objects[index++] = value;
    }

    T get(int index) {
        return (T) this.objects[index];
    }

    Integer size() {
        return this.index;
    }

    private void getMoreSize() {
        if (objects.length >= index) {
            this.objects = Arrays.copyOf(this.objects, this.index + DEFAULT_CAPACITY);
            modCount++;
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
        private int expectedModCount = modCount;
        @Override
        public boolean hasNext() {
            boolean result;
            if (objects.length == 0) {
                result = false;
            } else {
                result = objects.length > index;
            }
            return result;
        }

        /**
         * Переопредиление метода next.
         * @return смещает коректку или выдает ошибку что не существует ячейки.
         */
        @Override
        public T next() {
            if (hasNext()) {
                if (expectedModCount != modCount) {
                  throw new ConcurrentModificationException();
                }
                return (T) objects[index++];
            }
            throw new NoSuchElementException();
        }
    }
}
