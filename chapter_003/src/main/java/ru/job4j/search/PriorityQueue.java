package ru.job4j.search;

import java.util.LinkedList;

/**
 *Реализация класса Организации очереди приоритетов в связоном линкедлисте.
 *@author Oleg Zhieten
 *@since 2019
 *@version 3
 */
public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();
    private Integer position = 0;
    private Integer priority = 0;

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        int index = 0;
        if (position != 0 && task.getPriority() < tasks.get(position - 1).getPriority()) {
            if (this.tasks.get(priority).getPriority() < task.getPriority()) {
                index = priority++;
            } else {
                index = priority;
            }
        } else {
            index = position++;
        }
        this.tasks.add(index, task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}