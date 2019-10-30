package ru.job4j.generic;

public abstract class AbstractStore<E extends Base> implements Store<E> {
    private SimpleArray<E> baseStore = new SimpleArray<>(100);
    @Override
    public void add(E value) {
        baseStore.add(value);
    }

    @Override
    public boolean replace(String id, E value) {
        boolean result = false;
        int pos = getId(id);
        if (pos != -1) {
            baseStore.set(pos, value);
            result = true;
        }
        return result;
    }

    @Override
    public boolean delete(String id) {
        boolean result = false;
        int pos = getId(id);
        if (pos != -1) {
            baseStore.remove(pos);
            result = true;
        }
        return result;
    }

    @Override
    public E findById(String id) {
        E result = null;
        int pos = getId(id);
        if (pos != -1) {
            result = baseStore.get(pos);
        }
       return result;
    }

    private int getId(String id) {
        int pos = 0;
        int chek = -1;
        for (E c : baseStore) {
            if (c.getId().equals(id)) {
                chek++;
                break;
            }
            pos++;
        }
        return chek == -1 ? -1 : pos;
    }
}