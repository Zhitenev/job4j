package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.*;
/**
 *Test класса Triangle.
 *@author Oleg Zhieten
 *@since 2019
 *@version 1
 */
public class TriangleTest {
    /**
     * Test расчета площади треугольника.
     */
    @Test
    public void whenAreaSetThreePointsThenTriangleArea() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(2, 0);
        Triangle triangle = new Triangle(a, b, c);
        double result = triangle.area();
        double expected = 2D;
        assertThat(result, closeTo(expected, 0.1));
    }
}