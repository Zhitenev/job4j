package ru.job4j.set;

import ru.job4j.list.DynamicSimpleLinkedList;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleSet<E> implements Iterable<Object> {
    private DynamicSimpleLinkedList<E> simpleSet = new DynamicSimpleLinkedList<>();
    private int count = 0;

    public void add(E value) {
        if (contains(value)) {
            simpleSet.add(value);
            count++;
        }
    }

    public int size() {
        return this.count;
    }

    private boolean contains(E value) {
        boolean check = true;
        for (Object e : simpleSet) {
            if (e.equals(value)) {
                check = false;
                break;
            }
        }
        return check;
    }

    @Override
    public Iterator<Object> iterator() {
        return new SimpleSet.SimpleSetIterator();
    }

    class SimpleSetIterator implements Iterator<E> {
        private DynamicSimpleLinkedList copyObj = simpleSet;
        private int expectedModCount = count;
        private int position = 1;

        @Override
        public boolean hasNext() {
            if (expectedModCount != count) {
                throw new ConcurrentModificationException();
            }
            return position <= count;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return (E) copyObj.get(count - position++);
        }
    }
}