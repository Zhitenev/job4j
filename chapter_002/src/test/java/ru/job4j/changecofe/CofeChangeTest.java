package ru.job4j.changecofe;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 *Тестирование класса CofeChange.
 *@author Oleg Zhieten
 *@since 2019
 *@version 2
 */

public class CofeChangeTest {
    /**
     * Тест.
     */
    @Test
    public void whenValue100Price35() {
        CofeChange cofeChange = new CofeChange();
        int[] out = cofeChange.changes(73, 35);
        int[] result = {10, 10, 10, 5, 2, 1};
        assertThat(out, is(result));
    }

    /**
     * Тест.
     */
    @Test
    public void whenValue50Price35() {
        CofeChange cofeChange = new CofeChange();
        int[] out = cofeChange.changes(50, 35);
        int[] result = {10, 5};
        assertThat(out, is(result));
    }

    /**
     * Тест.
     */
    @Test
    public void whenValue66Price35() {
        CofeChange cofeChange = new CofeChange();
        int[] out = cofeChange.changes(66, 35);
        int[] result = {10, 10, 10, 1};
        assertThat(out, is(result));
    }

    /**
     * Тест.
     */
    @Test
    public void whenValue74Price35() {
        CofeChange cofeChange = new CofeChange();
        int[] out = cofeChange.changes(74, 35);
        int[] result = {10, 10, 10, 5, 2, 2};
        assertThat(out, is(result));
    }

    /**
     * Тест.
     */
    @Test
    public void whenValue41Price35() {
        CofeChange cofeChange = new CofeChange();
        int[] out = cofeChange.changes(41, 35);
        int[] result = {5, 1};
        assertThat(out, is(result));
    }

    /**
     * Тест.
     */
    @Test
    public void whenValue51Price35() {
        CofeChange cofeChange = new CofeChange();
        int[] out = cofeChange.changes(51, 35);
        int[] result = {10, 5, 1};
        assertThat(out, is(result));
    }


    /**
     * Тест.
     */
    @Test
    public void whenValue51Price27() {
        CofeChange cofeChange = new CofeChange();
        int[] out = cofeChange.changes(51, 27);
        int[] result = {10, 10, 2, 2};
        assertThat(out, is(result));
    }

    /**
     * Тест.
     */
    @Test
    public void whenValue51Price41() {
        CofeChange cofeChange = new CofeChange();
        int[] out = cofeChange.changes(51, 41);
        int[] result = {10};
        assertThat(out, is(result));
    }

    /**
     * Тест.
     */
    @Test
    public void whenValue51Price42() {
        CofeChange cofeChange = new CofeChange();
        int[] out = cofeChange.changes(51, 42);
        int[] result = {5, 2, 2};
        assertThat(out, is(result));
    }

    /**
     * Тест.
     */
    @Test
    public void whenValue51Price43() {
        CofeChange cofeChange = new CofeChange();
        int[] out = cofeChange.changes(51, 43);
        int[] result = {5, 2, 1};
        assertThat(out, is(result));
    }

    /**
     * Тест.
     */
    @Test
    public void whenValue58Price40() {
        CofeChange cofeChange = new CofeChange();
        int[] out = cofeChange.changes(58, 40);
        int[] result = {10, 5, 2, 1};
        assertThat(out, is(result));
    }
}
