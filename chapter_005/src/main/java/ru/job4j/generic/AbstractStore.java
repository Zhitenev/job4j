package ru.job4j.generic;

public abstract class AbstractStore implements Store {
    private SimpleArray<Base> baseStore = new SimpleArray<>(10);
    @Override
    public void add(Base value) {
        baseStore.add(value);
    }

    @Override
    public boolean replace(String id, Base value) {
        baseStore.set(Integer.parseInt(id), value);
        return true;
    }

    @Override
    public boolean delete(String id) {
        baseStore.remove(Integer.parseInt(id));
        return true;
    }

    @Override
    public Base findById(String id) {
        return baseStore.get(Integer.parseInt(id));
    }
}