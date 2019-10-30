package ru.job4j.list;

public class SimpleStack<T> {
    private DynamicSimpleLinkedList<T> dsl = new DynamicSimpleLinkedList<>();
    private Integer position = 0;

    void push(T value) {
        dsl.add(value);
        position--;
    }

    T poll() {
        T result = dsl.get(position++);
        dsl.delete();
        return result;
    }
}