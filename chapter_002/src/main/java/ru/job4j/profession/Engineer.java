package ru.job4j.profession;
/**
 *Реализация профессии инженер.
 *@author Oleg Zhieten
 *@since 2019
 *@version 2
 */
public class Engineer extends Profession {
    public void build(House house) {
        Engineer engineer = new Engineer();
        String nameEng = engineer.getName();
    }
}
/**
 * Вложеный класс дом.
 */
class House {
    public String name;
}