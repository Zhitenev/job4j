package ru.job4j.comparator;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class ListCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        List<Character> first = new ArrayList<>();
        List<Character> second = new ArrayList<>();
        for (char lf : left.toCharArray()) {
            first.add(lf);
        }
        for (char rg : right.toCharArray()) {
            second.add(rg);
        }
        int result = 0;
        int size = first.size() < second.size() ? first.size() : second.size();
            for (int i = 0; i < size; i++) {
                result = Character.compare(first.get(i), second.get(i));
                if (result != 0) {
                    break;
                }
            }
            if (result == 0 && first.size() != second.size()){
                result = -1;
            }
        return result;
    }
}