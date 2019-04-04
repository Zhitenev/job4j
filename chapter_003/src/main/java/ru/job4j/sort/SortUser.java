package ru.job4j.sort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
/**
 *Реализация класса организовать сортировку User.
 *@author Oleg Zhieten
 *@since 2019
 *@version 3
 */
public class SortUser {
    public Set<User> sort (List<User> list) {
        Set<User> sortUser = new TreeSet<>();
        sortUser.addAll(list);
        return sortUser;
    }
}