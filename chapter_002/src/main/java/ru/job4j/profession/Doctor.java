package ru.job4j.profession;
/**
 *Реализация профессии доктор.
 *@author Oleg Zhieten
 *@since 2019
 *@version 2
 */
public class Doctor extends Profession {
    public Diagnose heal (Pacient pacient) {
        Doctor doc = new Doctor();
        String docName = doc.getName();
        Diagnose diagnose = new Diagnose();
        return diagnose;
    }
}
/**
 * Вложенный класс реализации пациента.
 */
class Pacient {
    public String name;
}
/**
 * Вложенный класс диагноз.
 */
class Diagnose {

}