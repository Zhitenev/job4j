package ru.job4j.profession;
/**
 *Реализация наследования и профессий.
 *@author Oleg Zhieten
 *@since 2019
 *@version 2
 */

public class Profession {
    /**
     * name - хранилище имен.
     */
    public String name;
    /**
     * proffesion - хранилище профессий.
     */
    public String profession;

    /**
     * Возвращает имя.
     * @return возвращаемое имя.
     */
    public String getName() {
        return name;
    }
}