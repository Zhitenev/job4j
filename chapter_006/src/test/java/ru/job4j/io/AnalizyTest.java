package ru.job4j.io;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizyTest {

    @Test
    public void whenAnalizyWithTwoDownTimeFirstLine() {
        Analizy analizy = new Analizy();
        String path = "./data/";
        analizy.unavailable(path + "server.lgs", path + "unavailable.csv");
        List<String> check = analizy.load(path + "unavailable.csv");
        assertThat(
                check.get(0),
                is("10:58:01;10:59:01")
        );
    }

    @Test
    public void whenAnalizyWithTwoDownTimeSecondLine() {
        Analizy analizy = new Analizy();
        String path = "./data/";
        analizy.unavailable(path + "server.lgs", path + "unavailable.csv");
        List<String> check = analizy.load(path + "unavailable.csv");
        assertThat(
                check.get(1),
                is("11:01:02;11:02:02")
        );
    }
}