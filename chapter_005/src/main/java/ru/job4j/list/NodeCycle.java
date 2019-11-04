package ru.job4j.list;

public class NodeCycle<E> {
    E data;
    NodeCycle<E> next;
    private static int size = 0;

    NodeCycle(E data) {
        this.data = data;
        size++;
    }
    /**
     * Определение зацикленности в связаном списке.
     * @param first первый элемент списка.
     * @return результат проверки.
     */
    boolean hasCycle(NodeCycle<E> first) {
        boolean result = false;
        NodeCycle<E> after = first.next;
        for (int i = 1; i <= size; i++) {
            if (first.equals(after)) {
                result = true;
                break;
            } else if (i == size) {
                first = first.next;
                after = first.next.next;
                i = 0;
            }
            after = after.next;

            if (after == null) {
                break;
            }
        }
        return result;
    }
}