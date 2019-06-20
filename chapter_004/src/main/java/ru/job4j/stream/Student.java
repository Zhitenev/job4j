package ru.job4j.stream;

/**
 * Реализация студентов с общим балом.
 */
public class Student {
    /**
     * Общий бал студента.
     */
    private int score;
    /**
     * Фамилия студента.
     */
    private String surName;

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
}
