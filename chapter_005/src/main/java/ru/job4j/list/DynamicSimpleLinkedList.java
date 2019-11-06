package ru.job4j.list;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *  реализация Динамического связанного списка.
 * @param <E> Генерик.
 */
public class DynamicSimpleLinkedList<E> implements Iterable<Object> {
    private Node<E> objects;
    private int modCount = 0;
    /**
     * Добавить элемент.
     * @param data добавляемый элемент.
     */
    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.objects;
        this.objects = newLink;
        this.modCount++;
    }

    /**
     * Получить элемент.
     * @param index индекс получаемого элемента.
     * @return найденый элемент.
     */
    public E get(int index) {
        Node<E> result = this.objects;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.data;
    }

    public void delete() {
        Node<E> result = this.objects;
        this.objects.data = null;
        this.objects = result.next;
        modCount++;
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
        private Node<E> copyObj = objects;
        private int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return copyObj != null;
        }

        /**
         * Переопредиление метода next.
         * @return смещает коректку или выдает ошибку что не существует ячейки.
         */
        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E result = copyObj.data;
            copyObj = copyObj.next;
            return result;
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