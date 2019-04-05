package ru.job4j.sort;

import java.util.*;

/**
 *Реализация класса организовать сортировку User.
 *@author Oleg Zhieten
 *@since 2019
 *@version 3
 */
public class SortUser {
    public Set<User> sort(List<User> list) {
        Set<User> sortUser = new TreeSet<>();
        sortUser.addAll(list);
        return sortUser;
    }

    public List<User> sortNameLength(List<User> list) {
        list.sort(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int result = o1.getName().length() < o2.getName().length() ? -1 : 1;
                if (o1.getName().length() == o2.getName().length()) {
                    result = 0;
                }
                return result;
            }
        });
        return list;
    }

    public List<User> sortByAllFields(List<User> list) {
        list.sort(new Comparator<User>() {
                      @Override
                      public int compare(User o1, User o2) {
                          int result = o1.getName().compareTo(o2.getName());
                          if (o1.getName().equals(o2.getName())) {
                              result = o1.getAge().compareTo(o2.getAge());
                          }
                          return result;
                      }
                  }
        );

        return list;
    }
}