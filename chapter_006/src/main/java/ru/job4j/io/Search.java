package ru.job4j.io;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Search {
    private  List<File> result = new ArrayList<>();
    List<File> files(String parent, List<String> exts) {

        File file = new File(parent);
        File[] list = file.listFiles();

        if (list != null && !file.isDirectory()) {

            throw new IllegalArgumentException(
                    "Cannot list content of "
                            + file.getPath()
                            + ": Not a directory");
        }

        Queue<File> data = new LinkedList<>();
        data.offer(file);
        while (!data.isEmpty()) {
            File elem = data.poll();
            if (elem.isDirectory()) {
                for (File fl : elem.listFiles()) {
                    for (String ext : exts) {
                        if (!fl.isDirectory()
                                && ext == null || fl.getName().endsWith(ext)) {
                            result.add(fl);
                        }
                    }
                    data.offer(fl);
                }
            }
        }
        return result;
    }
}