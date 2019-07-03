package ru.job4j.sort;

import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenSortSet() {
        SortUser sortLs = new SortUser();
        List<User> list = List.of(
                new User(18, "Alexey"),
                new User(20, "Ilya"),
                new User(17, "Roman")
        );
        Set<User> result = sortLs.sort(list);
        Set<User> expect = Set.of(
                new User(17, "Roman"),
                new User(20, "Ilya"),
                new User(18, "Alexey")
        );
        assertThat(result, is(expect));
    }

    @Test
    public void whenElementsSortList() {
        SortUser sortLs = new SortUser();
        List<User> list = new ArrayList<>(
                List.of(
                        new User(18, "Alexey"),
                        new User(20, "Ilya"),
                        new User(17, "Roman")
                ));
        List<User> result = sortLs.sortNameLength(list);
        List<User> expect = List.of(
                new User(20, "Ilya"),
                new User(17, "Roman"),
                new User(18, "Alexey")
        );
        assertThat(result, is(expect));
    }

    @Test
    public void whenElementsSorNameAndAge() {
        SortUser sortLs = new SortUser();
        List<User> list = new ArrayList<>(
                List.of(
                        new User(25, "Сергей"),
                        new User(30, "Иван"),
                        new User(20, "Сергей"),
                        new User(25, "Иван")
                )
        );
        List<User> result = sortLs.sortByAllFields(list);
        List<User> expect = new ArrayList<>(
                List.of(
                        new User(25, "Иван"),
                        new User(30, "Иван"),
                        new User(20, "Сергей"),
                        new User(25, "Сергей")
                )
        );
        assertThat(result, is(expect));
    }
}