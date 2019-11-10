package ru.job4j.set;

import ru.job4j.list.DynamicSimpleLinkedList;

import java.util.Iterator;

public class SimpleSet<E> implements Iterable<Object> {
    private DynamicSimpleLinkedList<E> simpleSet = new DynamicSimpleLinkedList<>();

    public void add(E value) {
        if (!contains(value)) {
            simpleSet.add(value);
        }
    }

    public int size() {
        return this.simpleSet.size();
    }

    private boolean contains(E value) {
        boolean check = false;
        for (Object e : simpleSet) {
            if (e.equals(value)) {
                check = true;
                break;
            }
        }
        return check;
    }

    @Override
    public Iterator<Object> iterator() {
        return simpleSet.iterator();
    }
}