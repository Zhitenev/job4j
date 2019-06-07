package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 *Test класса ArrayDuplicate.
 *@author Oleg Zhieten
 *@since 2019
 *@version 1
 */
public class ArrayDuplicateTest {
    /**
     * Тест с 5 элементами массива.
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] withDublecate = {"Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] withOutDublicate = arrayDuplicate.remove(withDublecate);
        String[] chk = {"Привет", "Мир", "Супер"};
        assertThat(withOutDublicate, is(chk));
    }
    /**
     * Тест с 6 элементами массива.
     */
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicateSecond() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] withDublecate = {"Привет", "Привет", "Мир", "Привет", "Супер", "Мир"};
        String[] withOutDublicate = arrayDuplicate.remove(withDublecate);
        String[] chk = {"Привет", "Мир", "Супер"};
        assertThat(withOutDublicate, is(chk));
    }
}