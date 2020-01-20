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
    private String stopWord = "";
    private static final String STOP = "стоп";
    private static final String CONT = "продолжить";
    private static final String EXIT = "завершить";
    private static final String LOG_PATH = "./chapter_006/data/chatLog.txt";
    private static final String WORDS_BASE_PATH = "./chapter_006/data/list.txt";
    private Scanner sc = new Scanner(System.in);
    private Random random = new Random();

    public static void main(String[] args) {
        new Chat().init();
    }

    /**
     * Загрузка базы слов для бота.
     * @return список слов.
     */
    private List<String> loadWord() {
        List<String> result = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(WORDS_BASE_PATH))) {
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

    /**
     * записываем в логфайл.
     * @param word входящая информация.
     */
    private void writing(String word) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(LOG_PATH, true))) {
            out.println(word);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Инициализируем чат.
     */
    private void init() {
        Chat chat = new Chat();
        String answer = "";
        System.out.println("Stat chatting");
        List<String> listWords = chat.loadWord();
        do {
            int getPosition = random.nextInt(listWords.size());
            String word = listWords.get(getPosition);
            answer = chat.ask();
            chat.writing(answer);
            if (!STOP.equals(answer) && !STOP.equals(stopWord) && !EXIT.equals(answer)) {
                chat.typing(word);
                chat.writing(word);
            } else {
                stopWord = STOP;
            }
            if (CONT.equals(answer)) {
                stopWord = CONT;
                chat.typing(word);
                chat.writing(word);
            }
        } while (!EXIT.equals(answer));
    }
}