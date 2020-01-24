package ru.job4j.socet.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static final int PORT = 5000;
    private static final String EXIT = "exit";
    private static final String HELLO = "hello oracle";
    private final Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }

    public static void main(String[] args) throws IOException {
        try (Socket socket = new ServerSocket(PORT).accept()) {
            new Server(socket).init();
        }
    }

    public void init() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);

        String line;

        do {
            System.out.println("Waiting command...");
            line = in.readLine();
            System.out.println(line);
            if (HELLO.equals(line)) {
                out.println("Hello, dear friend. I'm oracle.");
                out.println("");
            } else if (!(EXIT.equals(line))) {
                out.println("I don't understand");
                out.println("");
            }
        } while (!(EXIT.equals(line)));

    }
}