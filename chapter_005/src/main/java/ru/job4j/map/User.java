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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }
}
