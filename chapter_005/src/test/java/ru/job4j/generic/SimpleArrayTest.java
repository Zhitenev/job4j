package ru.job4j.generic;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
/**
 * Тестирование класса simpleArray.
 *@author Oleg Zhieten
 *@since 2019
 *@version 2
 */
public class SimpleArrayTest {
    @Test
    public void whenAddInSimpleArrayWithGenericString() {
            SimpleArray<String> simpleArray = new SimpleArray<>(5);
            simpleArray.add("a");
            simpleArray.add("b");
            simpleArray.add("c");
            String result = simpleArray.get(0) + simpleArray.get(1) + simpleArray.get(2);
            assertThat(result, is("abc"));
    }

    @Test
    public void whenAddInSimpleArrayWithGenericInteger() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        Integer result = simpleArray.get(0) + simpleArray.get(1) + simpleArray.get(2);
        assertThat(result, is(6));
    }

    @Test
    public void whenSetInSimpleArrayWithGenericString() {
        SimpleArray<String> simpleArray = new SimpleArray<>(5);
        simpleArray.add("a");
        simpleArray.add("b");
        simpleArray.add("c");
        simpleArray.set(1, "d");
        String result = simpleArray.get(1);
        assertThat(result, is("d"));
    }

    @Test
    public void whenSetInSimpleArrayWithGenericInteger() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.set(1, 5);
        Integer result = simpleArray.get(1);
        assertThat(result, is(5));
    }

    @Test
    public void whenRemoveInSimpleArrayWithGenericString() {
        SimpleArray<String> simpleArray = new SimpleArray<>(5);
        simpleArray.add("a");
        simpleArray.add("b");
        simpleArray.add("c");
        simpleArray.remove(1);
        String result = simpleArray.get(1);
        assertThat(result, is("c"));
    }

    @Test
    public void whenRemoveInSimpleArrayWithGenericInteger() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.remove(1);
        Integer result = simpleArray.get(1);
        assertThat(result, is(3));
    }

    @Test
    public void whenIterableSimpleArrayHasNextTrue() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(5);
        var result = simpleArray.iterator().hasNext();
        assertThat(result, is(true));
    }

    @Test
    public void whenIterableSimpleArrayHasNextFalse() {
        SimpleArray<String> simpleArray = new SimpleArray<>(2);
        simpleArray.add("1");
        simpleArray.add("2");
        var result = simpleArray.iterator().hasNext();
        assertThat(result, is(false));
    }

    @Test
    public void whenIterableSimpleArrayNextWithString() {
        SimpleArray<String> simpleArray = new SimpleArray<>(3);
        simpleArray.add("1");
        simpleArray.iterator().next();
        simpleArray.add("2");
        var result = simpleArray.get(2);
        assertThat(result, is("2"));
    }

    @Test
    public void whenIterableSimpleArrayNextWithInteger() {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(3);
        simpleArray.add(10);
        simpleArray.iterator().next();
        simpleArray.add(12);
        var result = simpleArray.get(2);
        assertThat(result, is(12));
    }

    @Test(expected = NoSuchElementException.class)
    public void invocationOfNextMethodShouldThrowNoSuchElementException() {
        SimpleArray<String> simpleArray = new SimpleArray<>(0);
        simpleArray.iterator().next();
    }
}
