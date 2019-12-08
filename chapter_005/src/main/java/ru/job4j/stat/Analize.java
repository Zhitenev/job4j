package ru.job4j.stat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Класс Analize для проверки изменения в колекции.
 */
public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        Set<User> prev = new HashSet<>(previous);
        int eqId = 0;
        for (User usrPrev: prev) {
            for (User usrCur : current) {
                if (usrPrev.id == usrCur.id
                        && !usrPrev.name.equals(usrCur.name)) {
                    info.change();
                }
                if (usrPrev.id == usrCur.id) {
                    eqId++;
                }
            }
        }
        info.setAdded(current.size() - eqId);
        info.setDeleted(previous.size() - eqId);
        return info;
    }

    public static class User {
        int id;
        String name;

        User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    static class Info {
        private int added = 0;
        private int changed = 0;
        private int deleted = 0;

        void change() {
            this.changed++;
        }

        void setDeleted(int deleted) {
            this.deleted = deleted;
        }

        void setAdded(int added) {
            this.added = added;
        }

        int getAdded() {
            return this.added;
        }

        int getChanged() {
            return this.changed;
        }

        int getDeleted() {
            return this.deleted;
        }
    }
}