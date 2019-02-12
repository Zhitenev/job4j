package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Test класса Max.
 *@author Oleg Zhieten
 *@since 2019
 *@version 1
 */
public class MaxTest {
    /**
     * Test нахождения максимума.
     */
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }

    /**
     * Test нахождения максимума из 3х.
     */
    @Test
    public void whenThreeUnitMaxLast() {
        Max maxim = new Max();
        int result = maxim.max(1, 2, 3);
        assertThat(result, is(3));
    }

    /**
     * Test нахождения максимума из 3х.
     */
    @Test
    public void whenThreeUnitMaxFirst() {
        Max maxim = new Max();
        int result = maxim.max(3, 2, 1);
        assertThat(result, is(3));
    }

    /**
     * Test нахождения максимума из 3х.
     */
    @Test
    public void whenThreeUnitMaxMidle() {
        Max maxim = new Max();
        int result = maxim.max(1, 3, 2);
        assertThat(result, is(3));
    }
}