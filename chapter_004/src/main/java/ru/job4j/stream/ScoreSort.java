package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ScoreSort {
    List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .sorted(new Student())
                .flatMap(Stream::ofNullable)
                .takeWhile(student -> student.getScore() > bound)
                .collect(Collectors.toList());

    }
}
