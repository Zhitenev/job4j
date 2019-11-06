package ru.job4j.map;

import java.util.Calendar;
import java.util.Objects;

public class User {
    public String name;
    public int children;
    public Calendar birthday;

    public User(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
