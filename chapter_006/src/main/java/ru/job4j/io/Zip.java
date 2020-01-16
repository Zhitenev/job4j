package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    private  List<File> result = new ArrayList<>();

    private List<File> seekBy(String parent, String exts) {

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
                    if (!fl.isDirectory()
                            && !fl.getName().endsWith(exts)) {
                        result.add(fl);
                    }
                    data.offer(fl);
                }
            }
        }
        return result;
    }

    void pack(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File source : sources) {
                zip.putNextEntry(new ZipEntry(source.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Args arg = new Args(args);
        new Zip().pack(new Zip().seekBy(arg.directory(), arg.exclude()), new File(arg.output()));
    }
}

class Args {
    private String[] args;

     Args(String[] arg) {
        this.args = arg;

    }

     String directory() {
        return this.args[1];
    }

     String exclude() {
        return this.args[3];
    }

     String output() {
        return this.args[5];
    }
}