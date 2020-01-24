package ru.job4j.socet.server;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import com.google.common.base.Joiner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class ServerTest {
    private static final String LN = System.getProperty("line.separator");

    @Test
    public void whenExit() throws IOException {
        this.testServer("exit", "");
    }

    @Test
    public void whenHello() throws IOException {
        this.testServer(
                Joiner.on(LN).join(
                        "hello oracle",
                        "exit"
                ),
                Joiner.on(LN).join(
                        "Hello, dear friend. I'm oracle.",
                        LN
                )
        );
    }

    @Test
    public void whenUnsupported() throws IOException {
        testServer(
                Joiner.on(LN).join(
                        "Hi",
                        "exit"
                ),
                Joiner.on(LN).join(
                        "I don't understand",
                        LN
                )
        );
    }

    private void testServer(String input, String excepted) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(
                input.getBytes()
        );
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Server server = new Server(socket);
        server.init();
        assertThat(out.toString(), is(excepted));
    }
}
