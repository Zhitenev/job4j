package ru.job4j.stat;

import java.util.List;
/**
 * Класс Analize для проверки изменения в колекции.
 */
public class Analize {
    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info();
        int eqId = 0;
        for (int i = 0; i < previous.size(); i++) {
            for (int j = 0; j < current.size(); j++) {
                if (previous.get(i).id == current.get(j).id
                        && !previous.get(i).name.equals(current.get(j).name)) {
                    info.change();
                }
                if (previous.get(i).id == current.get(j).id) {
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