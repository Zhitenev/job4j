package ru.job4j.sort;

public class User implements Comparable<User> {
    private Integer age;
    private String name;


    public User(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getId() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(User u) {
        return this.age.compareTo(u.age);
    }
}