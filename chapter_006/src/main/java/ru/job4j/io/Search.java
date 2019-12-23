package ru.job4j.io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Search {
    private static List<File> result = new ArrayList<>();
    List<File> files(String parent, List<String> exts) {

        File file = new File(parent);
        File[] list = file.listFiles();

        if (list != null && !file.isDirectory()) {

            throw new IllegalArgumentException(
                    "Cannot list content of "
                            + file.getPath()
                            + ": Not a directory");
        }

        for (File f : list) {
            if (f.isDirectory()) {
                files(f.getAbsolutePath(), exts);
            } else {
                for (String ext : exts) {
                    if (ext == null || f.getName().endsWith(ext)) {
                        result.add(f);
                    }
                }
            }
        }
        return result;
    }
}