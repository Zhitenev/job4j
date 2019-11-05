package ru.job4j.set;

import ru.job4j.list.DynamicSimpleLinkedList;

public class SimpleSet<E> {
    private DynamicSimpleLinkedList<E> simpleSet;

    SimpleSet() {
        this.simpleSet = new DynamicSimpleLinkedList<>();
    }

    public void add(E value) {
        boolean check = true;
        for (Object e : simpleSet) {
            if (e.equals(value)) {
                check = false;
                break;
            }
        }
        if (check) {
            simpleSet.add(value);
        }
    }

    int size() {
        int count = 0;
        for (Object e : simpleSet) {
            count++;
        }
        return count;
    }
}