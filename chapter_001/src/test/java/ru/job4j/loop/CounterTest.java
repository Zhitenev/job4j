package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Test класса Counter.
 *@author Oleg Zhieten
 *@since 2019
 *@version 1
 */
public class CounterTest {
    /**
     * Test суммы в диапазоне от 1 до 10.
     */
    @Test
    public void whenSumEvenNumbersFromOneToTenThenThirty() {
        Counter count = new Counter();
        int rst = count.add(1, 10);
        assertThat(rst, is(30));
    }
}