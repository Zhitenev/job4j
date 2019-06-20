package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тест класса Convert.
 */
public class ConvertTest {
    /**
     * Тест преобразования в карту.
     */
    @Test
    public void whenCollectToMap() {
        Convert convt = new Convert();
        List<Student> students = new ArrayList<>();
        students.add(new Student("Petrov", 70));
        students.add(new Student("Sidorov", 60));
        students.add(new Student("Belov", 50));
        Map<String, Student> result = convt.convert(students);
        assertThat(result.get("Petrov").getScore(), is(70));
    }

    /**
     * Тест преобразования в карту.
     */
    @Test
    public void whenCollectToMapTwo() {
        Convert convt = new Convert();
        List<Student> students = new ArrayList<>();
        students.add(new Student("Petrov", 70));
        students.add(new Student("Sidorov", 60));
        students.add(new Student("Belov", 50));
        Map<String, Student> result = convt.convert(students);
        assertThat(result.get("Sidorov").getScore(), is(60));
    }

    /**
     * Тест преобразования в карту.
     */
    @Test
    public void whenCollectToMapThree() {
        Convert convt = new Convert();
        List<Student> students = new ArrayList<>();
        students.add(new Student("Petrov", 70));
        students.add(new Student("Sidorov", 60));
        students.add(new Student("Belov", 50));
        Map<String, Student> result = convt.convert(students);
        assertThat(result.get("Belov").getScore(), is(50));
    }
    /**
     * Тест преобразования в карту с размером 3.
     */
    @Test
    public void whenCollectToMapWithSize3() {
        Convert convt = new Convert();
        List<Student> students = new ArrayList<>();
        students.add(new Student("Petrov", 70));
        students.add(new Student("Sidorov", 60));
        students.add(new Student("Belov", 50));
        Map<String, Student> result = convt.convert(students);
        assertThat(result.size(), is(3));
    }
}
