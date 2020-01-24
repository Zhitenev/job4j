package ru.job4j.socet.client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private static final int PORT = 5000;
    private static final String IP = "127.0.0.1";
    private static final String EXIT = "exit";
    private final Socket socket;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public static void main(String[] args) throws IOException {
        try (Socket socket = new Socket(InetAddress.getByName(IP), PORT)) {
            new Client(socket).init(new ConsoleInput());
        }
    }

    public void init(Input input) {
        try {

            BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);

            String line;

            do {
                line = input.ask();
                out.println(line);
                String outLine;
                if (!EXIT.equals(line)) {
                    while (!(outLine = in.readLine()).isEmpty()) {
                        System.out.println(outLine);
                    }
                }
            } while (!(EXIT.equals(line)));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}