package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Test класса square    .
 *@author Oleg Zhieten
 *@since 2019
 *@version 1
 */
public class SquareTest {
    /**
     * Test массива рамером 3.
     */
    @Test
    public void whenBound3Then149() {
        int bound = 3;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[] {1, 4, 9};
        assertThat(rst, is(expect));
    }
    /**
     * Test массива рамером 8.
     */
    @Test
    public void whenBound8() {
        int bound = 8;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[] {1, 4, 9, 16, 25, 36, 49, 64};
        assertThat(rst, is(expect));
    }
}