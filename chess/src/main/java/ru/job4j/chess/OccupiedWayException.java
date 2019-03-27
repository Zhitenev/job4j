package ru.job4j.chess;
/**
 *Обработка свободного пути.
 *@author Oleg Zhieten
 *@since 2019
 *@version 2
 */
public class OccupiedWayException extends RuntimeException {
    public OccupiedWayException() {
        super("Ход невозможен, путь занят!");
    }
}