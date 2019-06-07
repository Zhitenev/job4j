package ru.job4j.tracker.singleton;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleOneTest {
    /**
     * Тест Enum энегргичной загрузки.
     */
    @Test
    public void whenEnumEagerLoading() {
        TrackerSingleOne tracker = TrackerSingleOne.INSTANCE;
        TrackerSingleOne trackerTwo = TrackerSingleOne.INSTANCE;
        assertThat(tracker, is(trackerTwo));
    }
}
