package ru.job4j.labmda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DiapasonTest {
    /**
     * Тест линеной.
     */
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = Diapason.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    /**
     * Тест квадратичной.
     */
    @Test
    public void whenSqFunctionThenSqResults() {
        List<Double> result = Diapason.diapason(5, 8, x -> 2 * Math.pow(x, 2) + 2 * x + 1);
        List<Double> expected = Arrays.asList(61D, 85D, 113D);
        assertThat(result, is(expected));
    }

    /**
     * Тест логорифмической.
     */
    @Test
    public void whenLogFunctionThenLogResults() {
        List<Double> result = Diapason.diapason(10, 14, x -> Math.log10(x));
        List<Double> expected = Arrays.asList(1D, 1.0413926851582251, 1.0791812460476249, 1.1139433523068367);
        assertThat(result, is(expected));
    }
}