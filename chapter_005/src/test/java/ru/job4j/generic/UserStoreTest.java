package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class UserStoreTest {
    @Test
    public void whenUseUserStore() {
        UserStore<User> userStore = new UserStore<>();
        User user = new User("1");
        User userTwo = new User("2");
        userStore.add(user);
        userStore.add(userTwo);
        User result = (User) userStore.findById("1");
        assertThat(result, is(userTwo));
    }

    @Test
    public void whenUseRoleStore() {
        RoleStore<Role> roleStore = new RoleStore<>();
        Role role = new Role("1");
        Role roleTwo = new Role("2");
        roleStore.add(role);
        roleStore.add(roleTwo);
        Role result = (Role) roleStore.findById("0");
        assertThat(result, is(role));
    }

    @Test
    public void whenUseRoleStoreReplace() {
        RoleStore<Role> roleStore = new RoleStore<>();
        Role role = new Role("1");
        Role roleTwo = new Role("2");
        Role roleThree = new Role("3");
        roleStore.add(role);
        roleStore.add(roleTwo);
        roleStore.add(roleThree);
        roleStore.replace("1", roleThree);
        Role result = (Role) roleStore.findById("1");
        assertThat(result, is(roleThree));
    }

    @Test
    public void whenUseUserStoreReplace() {
        UserStore<User> userStore = new UserStore<>();
        User user = new User("1");
        User userTwo = new User("2");
        User userThree = new User("3");
        userStore.add(user);
        userStore.add(userTwo);
        userStore.add(userThree);
        userStore.replace("1", userThree);
        User result = (User) userStore.findById("1");
        assertThat(result, is(userThree));
    }

    @Test
    public void whenUseRoleStoreDelete() {
        RoleStore<Role> roleStore = new RoleStore<>();
        Role role = new Role("1");
        Role roleTwo = new Role("2");
        Role roleThree = new Role("3");
        roleStore.add(role);
        roleStore.add(roleTwo);
        roleStore.add(roleThree);
        roleStore.delete("0");
        Role result = (Role) roleStore.findById("0");
        assertThat(result, is(roleTwo));
    }

    @Test
    public void whenUseUserStoreDelete() {
        UserStore<User> userStore = new UserStore<>();
        User user = new User("1");
        User userTwo = new User("2");
        User userThree = new User("3");
        userStore.add(user);
        userStore.add(userTwo);
        userStore.add(userThree);
        userStore.delete("1");
        User result = (User) userStore.findById("1");
        assertThat(result, is(userThree));
    }
}
