package ru.job4j.condition;
/**
 *Класс создания точек в системе координат.
 *@author Oleg Zhieten
 *@since 2019
 *@version 1
 */
public class Point {
    /**
     * Точка в системе координат по X.
     */
    private int x;
    /**
     * очка в системе координат по Y.
     */
    private int y;

    /**
     * инициализируем точку.
     * @param x точка по X.
     * @param y точка по Y.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Расстояние между точками.
     * @param that точка с кооринатами до которой расчитываем расстояние.
     * @return расстояние между точками.
     */
    public double distanceTo(Point that) {
        return Math.sqrt(
                Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
        );
    }

    /**
     * Метод вызова функций класса.
     * @param args входящие аргументы.
     */
    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);
        // сделаем вызов метода
        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);

        double result = a.distanceTo(b);
        System.out.println("Расстояние между точками А и В : " + result);
    }
}