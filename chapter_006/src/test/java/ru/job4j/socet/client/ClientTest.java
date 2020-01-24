package ru.job4j.socet.client;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClientTest {
    private static final String LN = System.getProperty("line.separator");

    @Test
    public void whenExit() throws IOException {
        this.clientTest("exit", "exit" + LN);
    }

    private void clientTest(String input, String excepted) throws IOException {
        Socket socket = mock(Socket.class);
        Input inputTest = new StubInput(input);
        ByteArrayOutputStream out = new ByteArrayOutputStream(
        );
        ByteArrayInputStream in = new ByteArrayInputStream(
                inputTest.ask().getBytes()
        );
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
   //     Server server = new Server(socket);
        Client client = new Client(socket);
   //     server.init();
        client.init(inputTest);
        assertThat(out.toString(), is(excepted));
    }
}