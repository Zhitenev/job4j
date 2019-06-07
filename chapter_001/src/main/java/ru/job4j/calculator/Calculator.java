package ru.job4j.calculator;

/**
 *Class это учебный класс.
 *@author Oleg Zhieten
 *@since 2019
 *@version 1
 */
public class Calculator {
    /**
     * result - хранит значение.
     */
    private double result;

    /**
     * Сложение.
     * @param first первое значение.
     * @param second второе значение.
     */
    public void add(double first, double second) {
        this.result = first + second;
    }

    /**
     * Вычитание.
     * @param first первое значение.
     * @param second второе значение.
     */
    public void subtract(double first, double second) {
        this.result = first - second;
    }

    /**
     * Умножение.
     * @param first первое значение.
     * @param second второе значение.
     */
    public void multiple(double first, double second) {
        this.result = first * second;
    }

    /**
     * Деление.
     * @param first первое значение.
     * @param second второе значение.
     */
    public void div(double first, double second) {
        this.result = first / second;
    }

    /**
     * Получить результат.
     * @return - возвращаемый результат.
     */
    public double getResult() {
        return this.result;
    }
}