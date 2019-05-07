package ru.job4j.labmda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Diapason {
    /**
     * Строим значиения по функциям
     * @param start начало диапазона.
     * @param end конец диапазона.
     * @param func формула.
     * @return спиок значений.
     */
    static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> res = new ArrayList<>();
        for (int index = start; index != end; index++) {
            res.add(func.apply(Double.valueOf(index)));
        }
        return res;
    }
}