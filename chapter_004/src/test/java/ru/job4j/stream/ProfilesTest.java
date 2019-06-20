package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Тестируем класс Profiles.
 */
public class ProfilesTest {
    /**
     * Тест получения списков адрессов когда их 2.
     */
    @Test
    public void whenCollect2Address() {
        Address addressOne = new Address("NSK", "Orange", 1, 2);
        Address addressTwo = new Address("MSK", "Red", 2, 2);
        Profile profileOne = new Profile(addressOne);
        Profile profileTwo = new Profile(addressTwo);
        List<Profile> profileList = new ArrayList<>();
        profileList.add(profileOne);
        profileList.add(profileTwo);
        Profiles profiles = new Profiles();
        List<Address> result = profiles.collect(profileList);
        assertThat(result.size(), is(2));
    }

    /**
     * Тест получения списков адрессов когда их 3.
     */
    @Test
    public void whenCollect3Address() {
        Profiles profiles = new Profiles();
        List<Profile> profileList = new ArrayList<>();
        Address addressOne = new Address("NSK", "Orange", 1, 2);
        Address addressTwo = new Address("MSK", "Red", 2, 2);
        Address addressThree = new Address("SPB", "Brown", 3, 3);
        Profile profileOne = new Profile(addressOne);
        Profile profileTwo = new Profile(addressTwo);
        Profile profileThree = new Profile(addressThree);
        profileList.add(profileOne);
        profileList.add(profileTwo);
        profileList.add(profileThree);
        List<Address> result = profiles.collect(profileList);
        assertThat(result.size(), is(3));
    }

    /**
     * Тест получения списков адрессов без повторов.
     */
    @Test
    public void whenCollectAddressesWithOutDouble() {
        Profiles profiles = new Profiles();
        List<Profile> profileList = new ArrayList<>();
        profileList.add(new Profile(new Address("NSK", "Orange", 1, 2)));
        profileList.add(new Profile(new Address("MSK", "Red", 2, 2)));
        profileList.add(new Profile(new Address("MSK", "Red", 2, 2)));
        profileList.add(new Profile(new Address("SPB", "Brown", 3, 3)));
        profileList.add(new Profile(new Address("ABK", "White", 2, 3)));
        List<Address> result = profiles.collect(profileList);
        assertThat(result.size(), is(4));
    }
    /**
     * Тест получения списков адрессов без повторов и отсортированные.
     */
    @Test
    public void whenCollectAddressesWithOutDoubleAndSorted() {
        Profiles profiles = new Profiles();
        List<Profile> profileList = new ArrayList<>();
        profileList.add(new Profile(new Address("NSK", "Orange", 1, 2)));
        profileList.add(new Profile(new Address("MSK", "Red", 2, 2)));
        profileList.add(new Profile(new Address("MSK", "Red", 2, 2)));
        profileList.add(new Profile(new Address("SPB", "Brown", 3, 3)));
        profileList.add(new Profile(new Address("ABK", "White", 2, 3)));
        List<Address> result = profiles.collect(profileList);
        assertThat(result.get(0).getCity(), is(profileList.get(4).getAddress().getCity()));
    }
}