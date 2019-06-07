package ru.job4j.tracker;
/**
 *Реализация класса ValidateInput.
 *@author Oleg Zhieten
 *@since 2019
 *@version 2
 */
public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    @Override
    public String ask(String question) {
        return this.input.ask(question);
    }

    @Override
    public int ask(String question, int[] range) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = input.ask(question, range);
                invalid = false;
            } catch (MenuOutException moe) {
                System.out.println("Выбирите пункт из меню.");
            } catch (NumberFormatException nfe) {
                System.out.println("Введите коректные данные.");
            }
        } while (invalid);
        return value;
    }
}