package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ScoreSortTest {
    /**
     * Тест диапазона от 60 и выше.
     */
    @Test
    public void whenScoreFrom60() {
        ScoreSort ss = new ScoreSort();
        List<Student> students = new ArrayList<>();
        students.add(new Student(40));
        students.add(new Student(92));
        students.add(new Student(98));
        students.add(null);
        students.add(new Student(70));
        students.add(new Student(69));
        students.add(new Student(69));
        students.add(new Student(50));
        students.add(null);
        students.add(new Student(59));
        students.add(new Student(40));
        List<Student> result = ss.levelOf(students, 60);
        assertThat(result.size(), is(5));
        assertThat(result.get(0).getScore(), is(98));
        assertThat(result.get(1).getScore(), is(92));
        assertThat(result.get(2).getScore(), is(70));
        assertThat(result.get(3).getScore(), is(69));
        assertThat(result.get(4).getScore(), is(69));
    }
}
