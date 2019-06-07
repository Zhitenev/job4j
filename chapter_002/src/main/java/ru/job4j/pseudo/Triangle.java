package ru.job4j.pseudo;

/**
 *Формирование треугольника.
 *@author Oleg Zhieten
 *@since 2019
 *@version 2
 */
public class Triangle implements Shape {
    /**
     * Формирование треугольника.
     * @return возвращаем треугольник в псевдографике.
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("   +   ");
        pic.append("  + +  ");
        pic.append(" +   + ");
        pic.append("+++++++");
        return pic.toString();
    }
}