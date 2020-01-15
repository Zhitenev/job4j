package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Реализация чат бота с командами.
 */
public class Chat {
    private Scanner sc = new Scanner(System.in);
    private static String stopWord = "продолжить";
    private static Random random = new Random();
    public static void main(String[] args) {
        Chat chat = new Chat();
        String answer = "";
        System.out.println("Stat chatting");
        List<String> listWords = chat.loadWord();
        try (PrintWriter out = new PrintWriter(new FileOutputStream("/Users/ozh/Documents/job4j/chapter_006/data/chatLog.txt"))) {
        do {
            int getPosition = random.nextInt(listWords.size());
            answer = chat.ask();
            out.println(answer);
            if (!answer.equals("стоп") && !stopWord.equals("стоп") && !answer.equals("завершить")) {
                chat.typing(listWords.get(getPosition));
                out.println(listWords.get(getPosition));
            } else {
                stopWord = "стоп";
            }
            if (answer.equals("продолжить")) {
                stopWord = "продолжить";
                chat.typing(listWords.get(getPosition));
                out.println(listWords.get(getPosition));
            }
        } while (!answer.equals("завершить"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Загрузка базы слов для бота.
     * @return список слов.
     */
    private List<String> loadWord() {
        List<String> result = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader("/Users/ozh/Documents/job4j/chapter_006/data/list.txt"))) {
            String line;
            while ((line = read.readLine()) != null) {
                    result.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Получаем ответ пользователя.
     * @return ответ.
     */
    private String ask() {
        return sc.nextLine();
    }

    /**
     * Печатаем в чат.
     * @param word случайное слово.
     */
    private void typing(String word) {
        System.out.println(word);
    }
}