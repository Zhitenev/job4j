package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Преобразование листа в карту.
 */
public class Convert {
    /**
     * Преобразование листа в карту.
     * @param students список студентов.
     * @return карта студентов.
     */
    public Map<String, Student> convert(List<Student> students) {
        return students.stream().distinct().collect(
                Collectors.toMap(
                        student -> student.getSurName(),
                        student -> student
                )
        );
    }
}