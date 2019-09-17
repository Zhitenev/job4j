package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Класс конвертации итератора итераторов.
 */
public class Converter {
    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {
            Iterator<Integer> its = it.next();
            @Override
            public boolean hasNext() {
                if (!its.hasNext() && it.hasNext()) {
                    this.its = it.next();
                }
                return its.hasNext();
            }

            @Override
            public Integer next() {
                if (!hasNext()) {
                    throw  new NoSuchElementException();
                }
                return its.next();
            }
        };
    }
}