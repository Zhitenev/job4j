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
        int pos = 0;
        NodeCycle<E> before = first;
        NodeCycle<E> after = first.next;
        for (int i = pos; i < size; i++) {
            for (int j = i + 1; j <= size; j++) {
                if (before.equals(after) & after != null) {
                    result = true;
                    break;
                } else {
                    if (after == null) {
                        break;
                    }
                    after = after.next;
                }
            }
            before = before.next;
            if (before == null) {
                break;
            }
            after = before.next;
            pos++;
        }
        return result;
    }
}