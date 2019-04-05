package ru.job4j.sort;

import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenSortSet() {
        SortUser sortLs = new SortUser();
        User userOne = new User(18, "Alexey");
        User userTwo = new User(20, "Ilya");
        User userThree = new User(17, "Roman");
        List<User> list = new ArrayList<>(
                Arrays.asList(
                        userOne,
                        userTwo,
                        userThree
                )
        );
        Set<User> result = sortLs.sort(list);
        Set<User> expect = new TreeSet<>(
                Arrays.asList(
                        userThree,
                        userOne,
                        userTwo
                )
        );
        assertThat(result, is(expect));
    }

    @Test
    public void whenElementsSortList() {
        SortUser sortLs = new SortUser();
        User userOne = new User(18, "Alexey");
        User userTwo = new User(20, "Ilya");
        User userThree = new User(17, "Roman");
        List<User> list = new ArrayList<>(
                Arrays.asList(
                        userOne,
                        userTwo,
                        userThree
                )
        );
        List<User> result = sortLs.sortNameLength(list);
        List<User> expect = new ArrayList<>(
                Arrays.asList(
                        userTwo,
                        userThree,
                        userOne
                )
        );
        assertThat(result, is(expect));
    }

    @Test
    public void whenElementsSorNameAndAge() {
        SortUser sortLs = new SortUser();
        User userOne = new User(25, "Сергей");
        User userTwo = new User(30, "Иван");
        User userThree = new User(20, "Сергей");
        User userFour = new User(25, "Иван");
        List<User> list = new ArrayList<>(
                Arrays.asList(
                        userOne,
                        userTwo,
                        userThree,
                        userFour
                )
        );
        List<User> result = sortLs.sortByAllFields(list);
        List<User> expect = new ArrayList<>(
                Arrays.asList(
                        userFour,
                        userTwo,
                        userThree,
                        userOne
                )
        );
        assertThat(result, is(expect));
    }
}