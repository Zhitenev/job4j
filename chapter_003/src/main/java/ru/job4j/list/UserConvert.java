package ru.job4j.list;

import java.util.HashMap;
import java.util.List;
/**
 *Реализация класса преобразования List в Map.
 *@author Oleg Zhieten
 *@since 2019
 *@version 3
 */

public class UserConvert {
    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> result = new HashMap<>();
            for (User tmp : list) {
                result.put(tmp.getId(), tmp);
            }
        return result;
    }
}