package ru.job4j.pseudo;

/**
 *Формирование квадрата.
 *@author Oleg Zhieten
 *@since 2019
 *@version 2
 */
public class Square implements Shape {
    /**
     * Формирование квадрата.
     * @return возвращаем квадрат в псевдо графике.
     */
        @Override
        public String draw() {
            StringBuilder pic = new StringBuilder();
            pic.append("++++");
            pic.append("+     +");
            pic.append("+     +");
            pic.append("++++");
            return pic.toString();
        }
}
