package ru.job4j.stream;

import java.util.Comparator;

/**
 * Реализация студентов с общим балом.
 */
public class Student implements Comparator<Student> {


    /**
     * Общий бал студента.
     */
    private int score;
    /**
     * Фамилия студента.
     */
    private String surName;

    public Student() {
        this.score = 1;
    }

    /**
     * Конструктор при создании студента задаем общий бал.
     * @param score общий бал студента.
     */
    public Student(int score) {
        this.score = score;
    }

    /**
     * Коструктор создания объекта с фамилией.
     * @param surName фамилия.
     * @param score общий бал.
     */
    public Student(String surName, int score) {
        this.surName = surName;
        this.score = score;
    }

    /**
     * Получаем общий бал.
     * @return общий бал.
     */
    public int getScore() {
        return score;
    }

    /**
     * Получить фамилию студента.
     * @return фамилия студента.
     */
    public String getSurName() {
        return surName;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int compare(Student o1, Student o2) {
        int result;
        if (o1 == null) {
            result = -1;
        } else if (o2 == null) {
            result = 1;
        } else {
            result = Integer.compare(o2.getScore(), o1.getScore());
        }
        return result;
    }
}
