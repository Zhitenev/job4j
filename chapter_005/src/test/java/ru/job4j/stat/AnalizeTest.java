package ru.job4j.stat;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class AnalizeTest {
    private List<Analize.User> previous = Arrays.asList(
            new Analize.User(1, "One"),
            new Analize.User(2, "Two"),
            new Analize.User(3, "Three"),
            new Analize.User(4, "Four"));
    private List<Analize.User> current = new ArrayList<>(previous);

    /**
     * Добавим 3х новых пользователей.
     */
    @Test
    public void whenAddThenThreeAdds() {
        Analize analize = new Analize();
        current.add(new Analize.User(5, "Five"));
        current.add(new Analize.User(6, "Six"));
        current.add(new Analize.User(7, "Seven"));
        Analize.Info info = analize.diff(previous, current);
        assertThat(info.getAdded(), is(3));
    }

    /**
     * Изменим 2 и 3 пользовтеля сохранив id.
     */
    @Test
    public void whenChangeThenTwoChanges() {
        current.set(0, new Analize.User(1, "FourOne"));
        current.set(1, new Analize.User(2, "FourTwo"));
        Analize analize = new Analize();
        Analize.Info info = analize.diff(previous, current);
        assertThat(info.getChanged(), is(2));
    }
    /**
     * Удалим 3 и 4 пользователя, предварительно произведем действия над колекцией.
     */
    @Test
    public void whenChangeThenAddThenRemoveThenTwoRemoved() {
        current.set(0, new Analize.User(1, "FourOne"));
        current.set(1, new Analize.User(2, "FourTwo"));
        current.add(new Analize.User(5, "Five"));
        current.add(new Analize.User(6, "Six"));
        current.add(new Analize.User(7, "Seven"));
        current.remove(2);
        current.remove(2);
        current.add(new Analize.User(8, "Eight"));
        Analize analize = new Analize();
        Analize.Info info = analize.diff(previous, current);
        assertThat(info.getDeleted(), is(2));
    }
}