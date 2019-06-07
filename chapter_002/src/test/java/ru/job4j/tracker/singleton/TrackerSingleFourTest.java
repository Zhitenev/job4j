package ru.job4j.tracker.singleton;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleFourTest {
    /**
     * Тест private static final class, Lazy loading.
     */
    @Test
    public void whenEnumEagerLoading() {
        TrackerSingleFour tracker = TrackerSingleFour.getInstance();
        TrackerSingleFour trackerTwo = TrackerSingleFour.getInstance();
        assertThat(tracker, is(trackerTwo));
    }
}
