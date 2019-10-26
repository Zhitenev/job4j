package ru.job4j.list;

import org.junit.Before;
import org.junit.Test;
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
}
