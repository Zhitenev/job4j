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
        Account actOne = new Account(500, "10000001");
        Account actTwo = new Account(100, "10000002");
        bank.deleteUser(user);
        List<Account> result = bank.getUserAccounts("541");
        assertThat(result.isEmpty(), is(true));
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
        bank.addUser(userOne);
        bank.addUser(userTwo);
        bank.addAccountToUser("541", actOne);
        bank.addAccountToUser("769", actTwo);
        boolean result = bank.transferMoney("541", "10000001", "769", "10000003", 600);
        assertThat(result, is(false));
    }
}