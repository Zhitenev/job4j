package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 *Тестирование класса ValidateInput.
 *@author Oleg Zhieten
 *@since 2019
 *@version 2
 */
public class ValidateInputTest {
    private final ByteArrayOutputStream mem = new ByteArrayOutputStream();
    private final PrintStream out = System.out;

    @Before
    public void loadMem() {
        System.setOut(new PrintStream(this.mem));
    }

    @After
    public void loadSys() {
        System.setOut(this.out);
    }

    /**
     * тест некоректных данных.
     */
    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"invalid", "1"})
        );
        input.ask("Выбирете:", new int[] {1});
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Введите коректные данные.%n")
                )
        );
    }

    /**
     * Тест выхода за пределы массива.
     */
    @Test
    public void whenOutBoundInput() {
        ValidateInput input = new ValidateInput(
                new StubInput(new String[] {"-1", "1"})
        );
        input.ask("Выбирете:", new int[] {1});
        assertThat(
                this.mem.toString(),
                is(
                        String.format("Выбирите пункт из меню.%n")
                )
        );
    }
}
