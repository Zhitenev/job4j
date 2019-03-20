package ru.job4j.tracker.singleton;
/**
 *Сингетрон static field, Lazy loading.
 *@author Oleg Zhieten
 *@since 2019
 *@version 2
 */
public class TrackerSingleTwo {

        private static TrackerSingleTwo instance;

        private TrackerSingleTwo() {
        }

        public static TrackerSingleTwo getInstance() {
            if (instance == null) {
                instance = new TrackerSingleTwo();
            }
            return instance;
        }
}