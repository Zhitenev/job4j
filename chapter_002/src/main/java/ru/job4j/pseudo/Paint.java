package ru.job4j.pseudo;

/**
 *Отрисовка объектов.
 *@author Oleg Zhieten
 *@since 2019
 *@version 2
 */
public class Paint {
    /**
     * Отрисовка фигур.
     * @param shape входные параметры интерфейса.
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }
}