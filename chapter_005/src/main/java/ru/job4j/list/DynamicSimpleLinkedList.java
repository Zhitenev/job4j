package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  реализация Динамического связанного списка.
 * @param <E> Генерик.
 */
public class DynamicSimpleLinkedList<E> implements Iterable<Object> {
    private int size;
    private Node<E> objects;

    public DynamicSimpleLinkedList() {
    }

    public DynamicSimpleLinkedList(int size) {
        this.size = size;
    }

    public DynamicSimpleLinkedList(Node<E> objects) {
        this.objects = objects;
    }

    /**
     * Добавить элемент.
     * @param data добавляемый элемент.
     */
    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.objects;
        this.objects = newLink;
        this.size++;
    }

    /**
     * Получить элемент.
     * @param index индекс получаемого элемента.
     * @return найденый элемент.
     */
    E get(int index) {
            Node<E> result = this.objects;
            for (int i = 0; i < index; i++) {
                result = result.next;
            }
        return result.data;
    }

    @Override
    public Iterator<Object> iterator() {
        return new DynamicSimpleLinkedList.SimpleLinkedListIterator();
    }

    class SimpleLinkedListIterator implements Iterator<E> {
        /**
         * Переопределение метода hasNext.
         * @return возможно смещение или нет.
         */
        private int expectedModCount = 0;
        @Override
        public boolean hasNext() {
            return expectedModCount < size;
        }

        /**
         * Переопредиление метода next.
         * @return смещает коректку или выдает ошибку что не существует ячейки.
         */
        @Override
        public E next() {
            if (hasNext()) {
                DynamicSimpleLinkedList<E> ds = new DynamicSimpleLinkedList<>(objects);
                if (expectedModCount >= size) {
                    throw new ConcurrentModificationException();
                }
                return ds.get(expectedModCount++);
            }
            throw new NoSuchElementException();
        }
    }

    private static class Node<E> {

        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }
}