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

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     * @param task задача
     */
    public void put(Task task) {
        var index = 0;
        for (var tmp : tasks) {
            index++;
            if (tmp.getPriority() > task.getPriority()) {
                index--;
                break;
            }
        }
        this.tasks.add(index, task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}