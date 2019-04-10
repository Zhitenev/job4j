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
     * Метод перевода средств.
     * @param destReq конечный счет.
     * @param amount сумма перевода.
     * @return корректно или нет.
     */
    public boolean transfer(Account destReq, double amount) {
        boolean result = false;
        if (amount > 0 && amount < this.value && destReq != null) {
            result = true;
            this.value -= amount;
            destReq.value += amount;
        }
        return result;
    }
}