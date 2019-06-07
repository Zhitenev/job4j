package ru.job4j.tracker.singleton;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleThreeTest {
    /**
     * Тест static final field. Eager loading.
     */
    @Test
    public void whenEnumEagerLoading() {
        TrackerSingleThree tracker = TrackerSingleThree.getInstance();
        TrackerSingleThree trackerTwo = TrackerSingleThree.getInstance();
        assertThat(tracker, is(trackerTwo));
    }
}
