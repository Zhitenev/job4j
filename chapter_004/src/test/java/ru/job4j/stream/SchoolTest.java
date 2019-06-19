package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тестирование класса scool.
 */
public class SchoolTest {
    /**
     * Тест диапазона от 70 и выше.
     */
    @Test
    public void whenCollect10a() {
        School school = new School();
        List<Student> students = new ArrayList<>();
        students.add(new Student(98));
        students.add(new Student(70));
        students.add(new Student(69));
        students.add(new Student(50));
        students.add(new Student(59));
        students.add(new Student(40));
        List<Student> result = school.collect(students, student -> student.getScore() >= 70);
        assertThat(result.size(), is(2));
    }
    /**
     * Тест диапазона от 50 до 70.
     */
    @Test
    public void whenCollect10b() {
        School school = new School();
        List<Student> students = new ArrayList<>();
        students.add(new Student(98));
        students.add(new Student(70));
        students.add(new Student(69));
        students.add(new Student(50));
        students.add(new Student(59));
        students.add(new Student(40));


        List<Student> result = school.collect(students, student -> 50 <= student.getScore() & student.getScore() < 70);
        assertThat(result.size(), is(3));
    }
    /**
     * Тест диапазона от 50 до 70.
     */
    @Test
    public void whenCollect10v() {
        School school = new School();
        List<Student> students = new ArrayList<>();
        students.add(new Student(98));
        students.add(new Student(70));
        students.add(new Student(69));
        students.add(new Student(50));
        students.add(new Student(59));
        students.add(new Student(40));


        List<Student> result = school.collect(students, student -> student.getScore() < 50);
        assertThat(result.size(), is(1));
    }
}
