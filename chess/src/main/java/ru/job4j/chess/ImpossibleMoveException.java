package ru.job4j.chess;
/**
 *обработка возможности хода.
 *@author Oleg Zhieten
 *@since 2019
 *@version 2
 */
public class ImpossibleMoveException extends RuntimeException {
    public ImpossibleMoveException() {
        super("Ход невозможен!");
    }
}