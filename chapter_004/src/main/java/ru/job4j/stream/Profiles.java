package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Получения списка адресов.
 */
public class Profiles {
    /**
     * Возвращает список адресов.
     * @param profiles список клиентов
     * @return список адресов.
     */
    List<Address> collect(List<Profile> profiles) {
        return profiles.stream().map(profile -> profile.getAddress())
                .sorted(Comparator.comparing(Address::getCity))
                .distinct()
                .collect(Collectors.toList());
    }
}