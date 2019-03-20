package ru.job4j.tracker.singleton;
/**
 *Сингетрон  private static final class. Lazy loading.
 *@author Oleg Zhieten
 *@since 2019
 *@version 2
 */
public class TrackerSingleFour {
    private TrackerSingleFour() {
    }

    public static TrackerSingleFour getInstance() {
        return Holder.INSTANCE;
    }

    private static final class Holder {
        private static final TrackerSingleFour INSTANCE = new TrackerSingleFour();
    }
}
