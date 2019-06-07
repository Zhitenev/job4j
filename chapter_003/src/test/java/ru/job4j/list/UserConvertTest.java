package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void when7ElementsThen9() {
        UserConvert conv = new UserConvert();
        List<User> users = new ArrayList<>();
        users.add(new User(1, "Oleg", "Novosibirsk"));
        users.add(new User(2, "Vadim", "Omsk"));
        HashMap<Integer, User> result = conv.process(users);
        HashMap<Integer, User> expect = new HashMap<>();
        expect.put(1, users.get(0));
        expect.put(2, users.get(1));
        assertThat(result, is(expect));
    }
}