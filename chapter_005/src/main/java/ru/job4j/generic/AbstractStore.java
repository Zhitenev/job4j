package ru.job4j.generic;

public abstract class AbstractStore<E extends Base> implements Store<E> {
    private SimpleArray<E> baseStore = new SimpleArray<>(100);
    @Override
    public void add(E value) {
        baseStore.add(value);
    }

    @Override
    public boolean replace(String id, E value) {
        baseStore.set(getId(id), value);
        return true;
    }

    @Override
    public boolean delete(String id) {
        baseStore.remove(getId(id));
        return true;
    }

    @Override
    public E findById(String id) {
        return (E) baseStore.get(getId(id));
    }

    private int getId(String id) {
        int pos = 0;
        for (E c : baseStore) {
            if (c.getId().equals(id)) {
                pos++;
            }
        }
        return pos;
    }
}