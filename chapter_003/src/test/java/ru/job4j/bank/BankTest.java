package ru.job4j.bank;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankTest {
    /**
     * Проверяем добавление пользователя, добавление аккаунтов, удаление аккаунтов.
     */
    @Test
    public void whenAddUserThenAddAccountThenDeleteAccount() {
        Bank bank = new Bank();
        User user = new User("Ilya", "541");
        Account actOne = new Account(500, "10000001");
        Account actTwo = new Account(100, "10000002");
        bank.addUser(user);
        bank.addAccountToUser("541", actOne);
        bank.addAccountToUser("541", actTwo);
        bank.deleteAccountFromUser("541", actOne);
        List<Account> result = new ArrayList<>(
                Arrays.asList(
                        actTwo
                )
        );
        assertThat(result, is(bank.getUserAccounts("541")));
    }

    /**
     * Проверяем удаления пользователя.
     */
    @Test
    public void whenDeleteUser() {
        Bank bank = new Bank();
        User user = new User("Ilya", "541");
        bank.addUser(user);
        bank.deleteUser(user);
        boolean result = bank.getUserAccounts("541").isEmpty();
        assertThat(result, is(true));
    }

    /**
     * Проверяем удаления пользователя.
     */
    @Test
    public void whenDeleteUserFromTwo() {
        Bank bank = new Bank();
        User user = new User("Ilya", "541");
        User userTwo = new User("Oleg", "769");
        bank.addUser(user);
        bank.addUser(userTwo);
        bank.addAccountToUser("769", new Account(100, "10000002"));
        bank.deleteUser(user);
        boolean result = bank.getUserAccounts("769").isEmpty();
        assertThat(result, is(false));
    }

    /**
     * проверяем успешную транзакцию.
     */
    @Test
    public void whenTransferMoneyTrue() {
        Bank bank = new Bank();
        User userOne = new User("Ilya", "541");
        User userTwo = new User("Oleg", "769");
        Account actOne = new Account(500, "10000001");
        Account actTwo = new Account(100, "10000002");
        bank.addUser(userOne);
        bank.addUser(userTwo);
        bank.addAccountToUser("541", actOne);
        bank.addAccountToUser("769", actTwo);
        boolean result = bank.transferMoney("541", "10000001", "769", "10000002", 150);
        assertThat(result, is(true));
    }

    /**
     * Проверяем не успешную транзакцию, когда недостаточно средств.
     */
    @Test
    public void whenTransferMoneyFalse() {
        Bank bank = new Bank();
        User userOne = new User("Ilya", "541");
        User userTwo = new User("Oleg", "769");
        Account actOne = new Account(500, "10000001");
        Account actTwo = new Account(100, "10000002");
        bank.addUser(userOne);
        bank.addUser(userTwo);
        bank.addAccountToUser("541", actOne);
        bank.addAccountToUser("769", actTwo);
        boolean result = bank.transferMoney("541", "10000001", "769", "10000002", 600);
        assertThat(result, is(false));
    }

    /**
     * Проверяем неуспешную транзакцию когда неверные реквезиты.
     */
    @Test
    public void whenTransferMoneyFalseSecond() {
        Bank bank = new Bank();
        User userOne = new User("Ilya", "541");
        User userTwo = new User("Oleg", "769");
        Account actOne = new Account(500, "10000001");
        Account actTwo = new Account(100, "10000002");
        Account actThree = new Account(200, "10000003");
        bank.addUser(userOne);
        bank.addUser(userTwo);
        bank.addAccountToUser("541", actOne);
        bank.addAccountToUser("769", actTwo);
        bank.addAccountToUser("769", actThree);
        boolean result = bank.transferMoney("541", "10000001", "769", "10000003", 600);
        assertThat(result, is(false));
    }

    /**
     * проверяем успешную транзакцию.
     */
    @Test
    public void whenTransferMoneyTrueTwo() {
        Bank bank = new Bank();
        User userOne = new User("Ilya", "541");
        Account actOne = new Account(500, "10000001");
        Account actTwo = new Account(100, "10000002");
        bank.addUser(userOne);
        bank.addAccountToUser("541", actOne);
        bank.addAccountToUser("541", actTwo);
        boolean result = bank.transferMoney("541", "10000001", "541", "10000002", 150);
        assertThat(result, is(true));
    }

    /**
     * проверяем успешную транзакцию.
     */
    @Test
    public void whenDeleteAccount() {
        Bank bank = new Bank();
        User userOne = new User("Ilya", "541");
        Account actOne = new Account(500, "10000001");
        Account actTwo = new Account(100, "10000002");
        Account actThree = new Account(200, "10000003");
        bank.addUser(userOne);
        bank.addAccountToUser("541", actOne);
        bank.addAccountToUser("541", actTwo);
        bank.addAccountToUser("541", actThree);
        bank.deleteAccountFromUser("541", actTwo);
        int result = bank.getUserAccounts("541").size();
        assertThat(result, is(2));
    }

    /**
     * проверяем успешную транзакцию.
     */
    @Test
    public void whenDeleteAccountWhenTwoUsers() {
        Bank bank = new Bank();
        User userOne = new User("Ilya", "541");
        User userTwo = new User("Oleg", "769");
        Account actOne = new Account(500, "10000001");
        Account actTwo = new Account(100, "10000002");
        Account actThree = new Account(200, "10000003");
        bank.addUser(userOne);
        bank.addUser(userTwo);
        bank.addAccountToUser("769", actOne);
        bank.addAccountToUser("541", actOne);
        bank.addAccountToUser("541", actTwo);
        bank.addAccountToUser("541", actThree);
        bank.deleteAccountFromUser("541", actTwo);
        int result = bank.getUserAccounts("541").size();
        assertThat(result, is(2));
    }

}