package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;
/**
 *Class это учебный класс.
 *@author Oleg Zhieten
 *@since 2019
 *@version 1
 */
public class PointTest {
    /**
     * Test echo.
     */
    @Test
    public void whenDisToSecondPoint() {
        Point pointOne = new Point(0, 1);
        Point pointTwo = new Point(2, 5);
        Double result = pointOne.distanceTo(pointTwo);
        assertThat(result, closeTo(4.47D, 0.01));
    }
}
