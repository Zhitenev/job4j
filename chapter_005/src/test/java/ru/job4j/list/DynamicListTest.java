package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DynamicListTest {
    private DynamicList<Integer> dn = new DynamicList<>();
    @Before
    public void beforeTest() {
        for (int j = 0; j < 10; j++) {
            dn.add(j);
        }
    }

    @Test
    public void whenAddMoreThenTenElements() {
        dn.add(10);
        assertThat(dn.size(), is(11));
    }

    @Test
    public void whenAddMoreThenTwentyElements() {
        for (int j = 10; j < 20; j++) {
            dn.add(j);
        }
        dn.add(20);
        assertThat(dn.size(), is(21));
    }

    @Test
    public void whenAddMoreThenTenElementsGetNext() {
        dn.add(10);
        assertThat(dn.get(10), is(10));
    }

    @Test
    public void whenUseNextIterator() {
        Iterator iterator = dn.iterator();
        iterator.next();
        iterator.next();
        assertThat(iterator.next(), is(2));
    }

    @Test
    public void whenAddTenElementsUseIteratorWithHasNextFalse() {
        Iterator iterator = dn.iterator();
        for (int j = 0; j < 10; j++) {
            iterator.next();
        }
        assertThat(iterator.hasNext(), is(false));
    }

    @Test
    public void whenAddTenElementsUseIteratorWithHasNextTrue() {
        Iterator iterator = dn.iterator();
        for (int j = 0; j < 9; j++) {
            iterator.next();
        }
        assertThat(iterator.hasNext(), is(true));
    }
}
