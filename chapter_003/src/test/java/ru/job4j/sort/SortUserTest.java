package ru.job4j.sort;

import org.junit.Test;
import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void when7ElementsThen9() {
        SortUser sortLs = new SortUser();
        List<User> list = new ArrayList<>();
        list.add(new User(18, "Alex"));
        list.add(new User(20, "Ilya"));
        list.add(new User(17, "Roman"));
        Set<User> result = sortLs.sort(list);
        Set<User> expect = new TreeSet<>();
        expect.addAll(
                Arrays.asList(
                        new User(17, "Roman"),
                        new User(18, "Alex"),
                        new User(20, "Ilya")
                )
        );
        assertThat(result, is(expect));
    }
}