package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *CalculatorTest это учебный класс.
 *@author Oleg Zhieten
 *@since 2019
 *@version 1
 */
public class CalculatorTest  {
    /**
     * Test сложения.
     */
    @Test
    public void whenAddOnePlusOneThenTwo()  {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Test вычитание.
     */
    @Test
    public void whenAddOneSubtractThreeThenTwo()  {
        Calculator calc = new Calculator();
        calc.subtract(3D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    /**
     * Test умножение.
     */
    @Test
    public void whenAddOneMultipleThreeThenTwo()  {
        Calculator calc = new Calculator();
        calc.multiple(3D, 1D);
        double result = calc.getResult();
        double expected = 3D;
        assertThat(result, is(expected));
    }

    /**
     * Test деление.
     */
    @Test
    public void whenAddOneDivFourThenTwo()  {
        Calculator calc = new Calculator();
        calc.div(4D, 2D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
}