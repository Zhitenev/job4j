package ru.job4j.bank;

/**
 * Класс счетов.
 */
public class Account {
    /**
     * остаток на счете.
     */
    private double value;
    /**
     * Реквизиты счета.
     */
    private String requisites;

    /**
     * Конструктор инициализации аккаунта.
     * @param value сумма на счете.
     * @param requisites реквизиты счета.
     */
    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    /**
     * Геттер получаения значения счета.
     * @return остаток на счете.
     */
    public double getValue() {
        return value;
    }

    /**
     * Геттер получения реквизитов счета.
     * @return реквизиты счета.
     */
    public String getRequisites() {
        return requisites;
    }

    /**
     * Сеттер для обновления остатка на счете.
     * @param value обновление остатока.
     */
    public void setValue(double value) {
        this.value = value;
    }
}