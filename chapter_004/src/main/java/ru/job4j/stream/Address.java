package ru.job4j.stream;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return home == address.home
                && apartment == address.apartment
                && Objects.equals(city, address.city)
                && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, home, apartment);
    }

    public String getCity() {
        return city;
    }
}