package ru.job4j.tracker.singleton;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleTwoTest {
    /**
     * Тест static field, Lazy loading.
     */
    @Test
    public void whenEnumEagerLoading() {
        TrackerSingleTwo tracker = TrackerSingleTwo.getInstance();
        TrackerSingleTwo trackerTwo = TrackerSingleTwo.getInstance();
        assertThat(tracker, is(trackerTwo));
    }
}
