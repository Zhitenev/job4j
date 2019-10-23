package ru.job4j.generic;

/**
 *  Реализация интерфеса Store c Generic.
 * @param <T> хранящийся Generic.
 */
public interface Store<T extends Base> {
    void add(T model);

    boolean replace(String id, T model);

    boolean delete(String id);

    T findById(String id);
}