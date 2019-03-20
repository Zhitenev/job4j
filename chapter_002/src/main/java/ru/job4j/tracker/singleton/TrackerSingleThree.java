package ru.job4j.tracker.singleton;
/**
 *Сингетрон  static final field. Eager loading.
 *@author Oleg Zhieten
 *@since 2019
 *@version 2
 */
public class TrackerSingleThree {
    private static final TrackerSingleThree INSTANCE = new TrackerSingleThree();

    private TrackerSingleThree() {
    }

    public static TrackerSingleThree getInstance() {
        return INSTANCE;
    }
}