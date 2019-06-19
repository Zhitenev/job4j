package ru.job4j.stream;

/**
 * Карточка клиента.
 */
public class Profile {
    /**
     * Адресс клиента.
     */
    private Address address;

    /**
     * Конструктор создания карточки с адресом.
     * @param address адресс клиента.
     */
    public Profile(Address address) {
        this.address = address;
    }

    /**
     * Геттер получения адреса.
     * @return адрес.
     */
    public Address getAddress() {
        return address;
    }
}