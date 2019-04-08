package ru.job4j.bank;

import java.util.*;

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
        this.bank.putIfAbsent(user, new LinkedList<Account>());
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
        for (User usr : this.bank.keySet()) {
            if (usr.getPassport().equals(passport)) {
                this.bank.get(usr).add(account);
            }
        }
    }

    /**
     * Удалить один счёт пользователя.
     * @param passport паспотр.
     * @param account счет.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        this.bank.get(this.getUser(passport)).remove(account);
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
        boolean result = false;
        Integer srcIndex = this.getIndex(this.getUserAccounts(srcPassport), srcRequisite);
        Integer destIndex = this.getIndex(this.getUserAccounts(destPassport), dstRequisite);
        User srcUser = this.getUser(srcPassport);
        User destUser = this.getUser(destPassport);

        if (srcUser != null && destUser != null) {
            if (this.bank.get(srcUser).get(srcIndex).getValue() - amount >= 0) {
                this.bank.get(srcUser).get(srcIndex).setValue(
                        this.bank.get(srcUser).get(srcIndex).getValue() - amount
                );
                this.bank.get(destUser).get(destIndex).setValue(
                        this.bank.get(destUser).get(destIndex).getValue() + amount
                );
                result = true;
            }

        }
        return result;
    }

    /**
     * Метод получения индекса счета для трансфера.
     * @param accounts список реквизитов.
     * @param requisite необходимые реквизиты.
     * @return индетификатор счета в списке.
     */
    private Integer getIndex(List<Account> accounts, String requisite) {
        Integer result = 0;
        for (Account act : accounts) {
            if (act.getRequisites().equals(requisite)) {
                break;
            }
            result++;
        }
        return result;
    }

    /**
     * Получения пользователя по паспорту.
     * @param passport номер паспорта.
     * @return найденый пользователь.
     */
    private User getUser(String passport) {
        User result = null;
        for (User tmp : this.bank.keySet()) {
            if (tmp.getPassport().equals(passport)) {
                result = tmp;
            }
        }
        return result;
    }
}