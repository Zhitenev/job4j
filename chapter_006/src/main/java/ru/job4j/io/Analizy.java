package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

class Analizy {
    private final List<String> values = new ArrayList<>();

    void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            String line;
            int status = 0;
            while ((line = read.readLine()) != null) {
                String[] strArr = line.split(" ");
                if (!line.isEmpty()
                        && strArr.length == 2
                        && strArr[0].equals(String.valueOf(400)) || strArr[0].equals(String.valueOf(500))
                        && status < 400) {
                    values.add(strArr[1]);
                    status = Integer.parseInt(strArr[0]);
                } else if (!line.isEmpty() && strArr.length == 2 && status > Integer.parseInt(strArr[0])) {
                    values.add(strArr[1]);
                    status = Integer.parseInt(strArr[0]);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            for (int i = 0; i < values.size() - 1; i++) {
                out.println(values.get(i++) + ";" + values.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    List<String> load(String path) {
        List<String> out = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = read.readLine()) != null) {
                out.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out;
    }
}