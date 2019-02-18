package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Test класса Check.
 *@author Oleg Zhieten
 *@since 2019
 *@version 1
 */
public class CheckTest {
    /**
     * Тест когда массив однородный.
     */
    @Test
    public void whenDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }

    /**
     * Тест когда массив не однородный.
     */
    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, false, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    /**
     * Тест более длинного массива.
     */
    @Test
    public void whenDataNotMonoByTrueThenFalseSecond() {
        Check check = new Check();
        boolean[] input = new boolean[] {true, false, true, true, true, true, true};
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }

    /**
     * Тест когда массив не однородный.
     */
    @Test
    public void whenDataNotMonoByFalse() {
        Check check = new Check();
        boolean[] input = new boolean[] {false, false, false};
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
}