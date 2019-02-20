package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Test класса MatrixCheck.
 *@author Oleg Zhieten
 *@since 2019
 *@version 1
 */
public class MatrixCheckTest {
    /**
     * Тест 3х3 с реузьатом true.
     */
    @Test
    public void whenDataMonoByTrueThenTrue() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, true, true},
                {false, true, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
    /**
     * Тест 3х3 с реузьатом false.
     */
    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, true, false},
                {false, false, true},
                {true, false, true}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
    /**
     * Тест 2х2 с реузьатом true.
     */
    @Test
    public void whenDataMonoByTrueThenTrueSecon() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, false},
                {false, true},
        };
        boolean result = check.mono(input);
        assertThat(result, is(true));
    }
    /**
     * Тест 2х2 с реузьатом false.
     */
    @Test
    public void whenDataMonoByTrueThenTrueThird() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, false},
                {true, true},
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
    /**
     * Тест 4х4 с реузьатом true.
     */
    @Test
    public void whenDataMonoByTrueThenFour() {
        MatrixCheck check = new MatrixCheck();
        boolean[][] input = new boolean[][]{
                {true, true, true, true},
                {true, true, true, true},
                {true, true, true, true},
                {true, true, true, false}
        };
        boolean result = check.mono(input);
        assertThat(result, is(false));
    }
}