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
            for (int i = 1; i < size / 2; i++) {
                if (first.equals(after)) {
                    result = true;
                    break;
                }
                if (after.next == null || after.next.next == null) {
                    break;
                }
                first = first.next;
                after = after.next.next;
            }
        return result;
    }
}