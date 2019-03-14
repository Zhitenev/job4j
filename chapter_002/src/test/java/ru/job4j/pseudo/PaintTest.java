package ru.job4j.pseudo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 *Тестирование класса Paint.
 *@author Oleg Zhieten
 *@since 2019
 *@version 2
 */

public class PaintTest {
    // поле содержит дефолтный вывод в консоль.
    private final PrintStream stdout = System.out;
    // буфер для результата.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }
    /**
     * Тест отрисовки квадрата через draw.
     */
    @Test
    public void whenDrawSquare() {
        new Paint().draw(new Square());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("++++")
                                .append("+     +")
                                .append("+     +")
                                .append("++++")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

    /**
     * Тест отрисовки треугольника через draw.
     */
    @Test
    public void whenDrawTriangle() {
        new Paint().draw(new Triangle());
        assertThat(
                new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append("   +   ")
                                .append("  + +  ")
                                .append(" +   + ")
                                .append("+++++++")
                                .append(System.lineSeparator())
                                .toString()
                )
        );
    }

}