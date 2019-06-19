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
     * Конструктор при создании студента задаем общий бал.
     * @param score общий бал студента.
     */
    public Student(int score) {
        this.score = score;
    }

    /**
     * Получаем общий бал.
     * @return общий бал.
     */
    public int getScore() {
        return score;
    }
}
