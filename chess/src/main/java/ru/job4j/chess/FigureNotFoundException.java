package ru.job4j.chess;
/**
 *Проверка фигуры.
 *@author Oleg Zhieten
 *@since 2019
 *@version 2
 */
public class FigureNotFoundException extends RuntimeException {
    public FigureNotFoundException() {
        super("Фигура не найдена!");
    }
}