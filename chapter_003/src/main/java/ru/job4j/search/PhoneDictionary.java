package ru.job4j.search;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *Реализация класса телефонный справочник.
 *@author Oleg Zhieten
 *@since 2019
 *@version 3
 */
public class PhoneDictionary {
    private List<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {

        return this.persons.stream().filter(
                person -> (person.getAddress() + person.getName() + person.getPhone() + person.getSurname()).contains(key)
        ).collect(Collectors.toList());
    }
}
