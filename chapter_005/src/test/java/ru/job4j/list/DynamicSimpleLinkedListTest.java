package ru.job4j.list;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DynamicSimpleLinkedListTest {

    @Test
    public void whenAddInDynamicLinkedList2Elem() {
        DynamicSimpleLinkedList<String> dsl = new DynamicSimpleLinkedList<>();
        dsl.add("first");
        dsl.add("second");
        assertThat(dsl.get(1), is("first"));
        assertThat(dsl.get(0), is("second"));
    }

    @Test
    public void whenAddInDynamicLinkedList5Elem() {
        DynamicSimpleLinkedList<Integer> dsl = new DynamicSimpleLinkedList<>();
        dsl.add(1);
        dsl.add(2);
        dsl.add(3);
        dsl.add(4);
        dsl.add(5);
        assertThat(dsl.get(0), is(5));
        assertThat(dsl.get(4), is(1));
    }

    @Test
    public void whenAddInDynamicLinkedList3ElemAndUseIterator() {
        DynamicSimpleLinkedList<Integer> dsl = new DynamicSimpleLinkedList<>();
        dsl.add(1);
        dsl.add(2);
        dsl.add(3);
        Iterator iterator = dsl.iterator();
        iterator.next();
        iterator.next();
        assertThat(iterator.next(), is(1));
        assertThat(dsl.get(0), is(3));
    }

    @Test
    public void whenAddInDynamicLinkedList3ElemAndUseIteratorHasNextFalse() {
        DynamicSimpleLinkedList<Integer> dsl = new DynamicSimpleLinkedList<>();
        dsl.add(1);
        dsl.add(2);
        dsl.add(3);
        Iterator iterator = dsl.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
        assertThat(iterator.hasNext(), is(false));
    }
}
