package ru.job4j.tracker;

public interface Input {
    String ask(String ask);
    int ask(String ask, int[] range);
}