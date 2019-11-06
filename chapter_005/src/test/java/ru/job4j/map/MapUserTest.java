package ru.job4j.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapUserTest {
    @Test
    public void whenAddTwoUserInMapWithoutOverride() {
        MapUser userOne = new MapUser("One");
        MapUser userTwo = new MapUser("One");
        Map<User, Object> map = new HashMap<>();
        map.put(userOne, "UserOne");
        map.put(userTwo, "UserTwo");
        System.out.println(map);
    }
}
