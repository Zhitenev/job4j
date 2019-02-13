package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Test класса Factorial.
 *@author Oleg Zhieten
 *@since 2019
 *@version 1
 */
public class FactorialTest {
    /**
     * Факториал от 5.
     */
    @Test
    public void whenCalculateFactorialForFiveThenOneHundreedTwenty() {
        Factorial fact = new Factorial();
        int rst = fact.calc(5);
        assertThat(rst, is(120));
    }

    /**
     * Факториал от 0.
     */
    @Test
    public void whenCalculateFactorialForZeroThenOne() {
        Factorial fact = new Factorial();
        int rst = fact.calc(0);
        assertThat(rst, is(1));
    }
}