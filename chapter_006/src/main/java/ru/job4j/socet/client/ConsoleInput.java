package ru.job4j.socet.client;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner sc = new Scanner(System.in);

    public String ask() {
         return sc.nextLine();
    }
}
