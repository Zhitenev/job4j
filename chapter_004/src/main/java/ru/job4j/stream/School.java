package ru.job4j.stream;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Класс реализации сортировки с помощью стрима.
 */
public class School {
    /**
     * Сортировка по общему балу.
     * @param students коллекция студентов для сортировки.
     * @param predict условия сортировки передаваемые стриму.
     * @return отфильтрованная коллекция.
     */
    public List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().filter(predict).collect(Collectors.toList());
    }
}
