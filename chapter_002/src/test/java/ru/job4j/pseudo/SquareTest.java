package ru.job4j.pseudo;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Тестирование класса Tracker.
 *@author Oleg Zhieten
 *@since 2019
 *@version 2
 */
public class SquareTest {
    /**
     * Проверка формирования квадрата на прямую.
     */
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(
                square.draw(),
                is(
                        new StringBuilder()
                                .append("++++")
                                .append("+     +")
                                .append("+     +")
                                .append("++++")
                                .toString()
                )
        );
    }
}