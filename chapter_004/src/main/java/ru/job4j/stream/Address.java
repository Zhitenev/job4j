package ru.job4j.stream;

/**
 * Класс полей для адресса.
 */
public class Address {
    private String city;
    private String street;
    private int home;
    private int apartment;

    /**
     * Конструктор создания адресса.
     * @param city город.
     * @param street улица.
     * @param home номер дома.
     * @param apartment номер квартиры.
     */
    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }
}