package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс Пользователей.
 */
public class User {
    private String name;
    private String passport;

    /**
     * Коструктор инициализации пользователя.
     * @param name имя пользователя.
     * @param passport паспорт, для индетификации.
     */
    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    /**
     * Геттер получения паспорта.
     * @return номер паспорта.
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Перекрытие метода equals.
     * @param o объект для сравнения.
     * @return результат.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(name, user.name)
                && Objects.equals(passport, user.passport);
    }

    /**
     * Перекрытие hashCode.
     * @return копия объекта.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, passport);
    }
}