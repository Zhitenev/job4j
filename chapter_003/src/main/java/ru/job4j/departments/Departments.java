package ru.job4j.departments;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Departments {
    public static final class Org implements Comparable<Org> {
        private final List<String> deps;

        public Org(List<String> deps) {
            this.deps = deps;
        }

        @Override
        public int compareTo(Org o) {
            return this.compareTo(o);
        }

        @Override
        public String toString() {
            return deps.toString();
        }
    }

    /**
     * Конвертируем лист со строками в массивы.
     * sep - разделитель в строках.
     * @param deps конвертируемый лист массив.
     * @return Массив Орг.
     */
    public List<Org> convert(List<String> deps) {
        int j = 0;
        String sep = "/";
        List<Org> result = new ArrayList<>();
        for (String tmp : deps) {
            if (tmp.contains(sep)) {
                String[] strAr = tmp.split(sep);
                do {
                    List<String> orgList = new ArrayList<>();
                    for (int i = 0; i <= j; i++) {
                        orgList.add(strAr[i]);
                    }
                    result.add(new Org(orgList));
                    j++;
                } while (j < strAr.length);
            } else {
                result.add(new Org(Arrays.asList(tmp)));
            }

        }
        return result;
    }

    public List<Org> sortAsc(List<Org> orgs) {
        return orgs;
    }

    public List<Org> sortDesc(List<Org> orgs) {
        return orgs;
    }
}