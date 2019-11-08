package ru.job4j.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleSetTest {
    @Test
    public void whenAddInSimpleSet4Elem() {
        SimpleSet<String> simpleSet = new SimpleSet<>();
        simpleSet.add("first");
        simpleSet.add("first");
        simpleSet.add("second");
        simpleSet.add("third");
        assertThat(simpleSet.size(), is(3));
    }

    @Test
    public void whenAddInSimpleSet5ElemAndDoubleInMid() {
        SimpleSet<String> simpleSet = new SimpleSet<>();
        simpleSet.add("first");
        simpleSet.add("second");
        simpleSet.add("second");
        simpleSet.add("third");
        simpleSet.add("four");
        assertThat(simpleSet.size(), is(4));
    }

    @Test
    public void whenAddInSimpleSet5ElemAndDoubleInEnd() {
        SimpleSet<String> simpleSet = new SimpleSet<>();
        simpleSet.add("first");
        simpleSet.add("second");
        simpleSet.add("third");
        simpleSet.add("four");
        simpleSet.add("four");
        assertThat(simpleSet.size(), is(4));
    }

    @Test
    public void whenAddIntegerInSimpleSet5ElemAndDoubleInEnd() {
        SimpleSet<Integer> simpleSet = new SimpleSet<>();
        simpleSet.add(1);
        simpleSet.add(2);
        simpleSet.add(3);
        simpleSet.add(4);
        simpleSet.add(4);
        assertThat(simpleSet.size(), is(4));
    }

    @Test
    public void whenAddIntegerInSimpleSet5ElemAndUseIterator() {
        SimpleSet<Integer> simpleSet = new SimpleSet<>();
        simpleSet.add(1);
        simpleSet.add(2);
        simpleSet.add(3);
        simpleSet.add(4);
        simpleSet.add(4);
        Iterator iterator = simpleSet.iterator();
        assertThat(iterator.next(), is(4));
    }


    @Test
    public void whenAddIntegerInSimpleSet5ElemAndUseIteratorHasNext() {
        SimpleSet<Integer> simpleSet = new SimpleSet<>();
        simpleSet.add(1);
        simpleSet.add(2);
        Iterator iterator = simpleSet.iterator();
        iterator.next();
        iterator.next();
        assertThat(iterator.hasNext(), is(false));
    }
}
