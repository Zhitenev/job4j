package ru.job4j.departments;
import java.util.*;
import java.util.stream.Collectors;

public class Departments {
    public static final class Org implements Comparable<Org> {
        private final List<String> deps;

        public Org(List<String> deps) {
            this.deps = deps;
        }

        @Override
        public int compareTo(Org o) {
            return this.deps.toString().compareTo(o.deps.toString());
        }

        @Override
        public String toString() {
            return deps.toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Org org = (Org) o;
            return Objects.equals(deps, org.deps);
        }

        @Override
        public int hashCode() {
            return Objects.hash(deps);
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

    /**
     * Вернем отсортированный массив.
     * @param orgs входящий массив.
     * @return отсротированный массив.
     */
    public List<Org> sortAsc(List<Org> orgs) {
        return orgs;
    }

    /**
     * Вернем реверсмассива.
     * @param orgs массив.
     * @return перевернутый массив.
     */
    public List<Org> sortDesc(List<Org> orgs) {
        return orgs.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }
}