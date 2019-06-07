package ru.job4j.profession;
/**
 *Реализация профессии учитель.
 *@author Oleg Zhieten
 *@since 2019
 *@version 2
 */
public class Teacher extends Profession {
    public void teach(Student student) {
        Teacher teacher = new Teacher();
        String nameTech = teacher.getName();
    }
}
/**
 * Вложенный класс студент.
 */
class Student {
    public String name;
}