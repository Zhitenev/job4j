package ru.job4j.list;

/**
 * Реализация очереди на 2х стеках.
 * @param <T>
 */
public class SimpleQueue<T> {
    private SimpleStack<T> simpleOne = new SimpleStack<>();
    private SimpleStack<T> simpleTwo = new SimpleStack<>();
    private int position = 0;

    /**
     * Получаем значение предварительно перенеся данные из первого стека в нужном порядке.
     * @return очерель.
     */
    public T poll() {
        if (position != 0) {
            for (int i = 0; i < position; i++) {
                simpleTwo.push(simpleOne.poll());
            }
        }
        position = 0;
        return simpleTwo.poll();
    }

    public void push(T value) {
        simpleOne.push(value);
        position++;
    }
}