package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SearchTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenTestInListWithOutTxt() throws IOException {
        folder.newFile("myfile.csv");
        folder.newFile("myfile.txt");
        folder.newFolder("subfolder");
        folder.newFile("subfolder/myfile2.txt");
        folder.newFolder("subfolder", "subSubfolder");
        folder.newFile("subfolder/subSubfolder/myfile.java");
        Search search = new Search();
        List<String> ext = new ArrayList<>();
        ext.add(".csv");
        ext.add(".java");
        List<File> files = new ArrayList<>(search.files(folder.getRoot().getPath(), ext));
        assertThat(
                files.get(0).getName(),
                is("myfile.csv")
        );
    }

    @Test
    public void whenTestInListTxt() throws IOException {
        folder.newFile("myfile.txt");
        folder.newFolder("subfolder");
        folder.newFile("subfolder/myfile2.txt");
        folder.newFolder("subfolder", "subSubfolder");
        folder.newFile("subfolder/subSubfolder/myfile.java");
        Search search = new Search();
        List<String> ext = new ArrayList<>();
        ext.add(".txt");
        ext.add(".java");
        List<File> files = new ArrayList<>(search.files(folder.getRoot().getPath(), ext));
        assertThat(
                files.get(1).getName(),
                is("myfile2.txt")
        );
    }

    @Test
    public void whenTestInListJava() throws IOException {
        folder.newFile("myfile.txt");
        folder.newFolder("subfolder");
        folder.newFile("subfolder/myfile2.txt");
        folder.newFolder("subfolder", "subSubfolder");
        folder.newFile("subfolder/subSubfolder/myfile.java");
        Search search = new Search();
        List<String> ext = new ArrayList<>();
        ext.add(".txt");
        ext.add(".java");
        List<File> files = new ArrayList<>(search.files(folder.getRoot().getPath(), ext));
        assertThat(
                files.get(2).getName(),
                is("myfile.java")
        );
    }

    @Test
    public void whenTestInLisOnlyOne() throws IOException {
        folder.newFile("myfile.csv");
        folder.newFile("myfile.txt");
        folder.newFolder("subfolder");
        folder.newFile("subfolder/myfile2.txt");
        folder.newFolder("subfolder", "subSubfolder");
        folder.newFile("subfolder/subSubfolder/myfile.java");
        Search search = new Search();
        List<String> ext = new ArrayList<>();
        ext.add(".java");
        List<File> files = new ArrayList<>(search.files(folder.getRoot().getPath(), ext));
        assertThat(
                files.get(0).getName(),
                is("myfile.java")
        );
    }
}
