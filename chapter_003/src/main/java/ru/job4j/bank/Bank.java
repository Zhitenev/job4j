package ru.job4j.bank;

import java.util.*;
import java.util.stream.Collectors;

public class Bank {
    /**
     * Хранилище пользователей и их счетов.
     */
    private Map<User, List<Account>> bank = new HashMap<>();

    /**
     * Добавление пользователя без счета.
     * @param user пользователь.
     */
    public void addUser(User user) {
        this.bank.putIfAbsent(user, new LinkedList<>());
    }

    /**
     * Удаление пользователя со всеми счетами.
     * @param user пользователь.
     */
    public void deleteUser(User user) {
        if (user != null) {
            this.bank.remove(user);
        }
    }

    /**
     * Добавление счета пользователю.
     * @param passport паспорт пользователя.
     * @param account аккаунт.
     */
    public void addAccountToUser(String passport, Account account) {
        this.bank.keySet().stream()
                .filter(user -> user.getPassport().equals(passport))
                .map(user -> this.bank.get(user).add(account))
                .collect(Collectors.toList());
    }

    /**
     * Удалить один счёт пользователя.
     * @param passport паспотр.
     * @param account счет.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        User user = this.getUser(passport);
        if (user != null) {
            this.bank.get(user).remove(account);
        }
    }

    /**
     * Получить список аккаунтов пользователя.
     * @param passport паспорт пользователя.
     * @return счета пользователя.
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> list = new ArrayList<>();
        if (this.getUser(passport) != null) {
            list.addAll(this.bank.get(this.getUser(passport)));
        }
        return list;
    }

    /**
     * Перевод денежных средств.
     * @param srcPassport исходящий индетификатор.
     * @param srcRequisite исходящий счет.
     * @param destPassport входящий индетификатор.
     * @param dstRequisite входящий счет.
     * @param amount сумма перевода.
     * @return результат операции.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        final Account srcAccount = this.getAccount(srcPassport, srcRequisite);
        final Account dstAccount = this.getAccount(destPassport, dstRequisite);
        return srcAccount != null && dstAccount != null
                && srcAccount.transfer(dstAccount, amount);
    }

    /**
     * Метод получения индекса счета для трансфера.
     * @param passport индетификатор пользователя.
     * @param requisite необходимые реквизиты.
     * @return реквизиты.
     */
    private Account getAccount(String passport, String requisite) {
        return this.getUserAccounts(passport).stream()
                .filter(acc -> acc.getRequisites().equals(requisite))
                .findFirst()
                .orElse(null);

    }

    /**
     * Получения пользователя по паспорту.
     * @param passport номер паспорта.
     * @return найденый пользователь.
     */
    private User getUser(String passport) {
        return this.bank.keySet().stream()
                .filter(usr -> usr.getPassport().equals(passport))
                .findFirst()
                .orElse(null);
    }
}