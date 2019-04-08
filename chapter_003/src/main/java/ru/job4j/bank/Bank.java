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
        this.bank.putIfAbsent(user, new ArrayList<>());
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
        for (User tmp : bank.keySet()) {
            if (tmp.getPassport().equals(passport)) {
                this.bank.put(tmp, Arrays.asList(account));
            }
        }
    }

    /**
     * Удалить один счёт пользователя.
     * @param passport паспотр.
     * @param account счет.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        for (User tmp : this.bank.keySet()) {
            if (tmp.getPassport().equals(passport)) {
                this.bank.get(tmp).remove(account);
            }
        }
    }

    /**
     * Получить список аккаунтов пользователя.
     * @param passport паспорт пользователя.
     * @return счета пользователя.
     */
    public List<Account> getUserAccounts(String passport) {
        List<Account> list = new ArrayList<>();
        for (User tmp : bank.keySet()) {
            if (tmp.getPassport().equals(passport)) {
                list.addAll(this.bank.get(tmp));
            }
        }
        return  list;
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
        User srcUser = null;
        User destUser = null;
        int srcIndex = 0;
        int destIndex = 0;
        //найдем пользователей по индетификатору.
        for (User users : this.bank.keySet()) {
            if (users.getPassport().equals(srcPassport)) {
                srcUser = users;
            }
            if (users.getPassport().equals(destPassport)) {
                destUser = users;
            }
        }
        //если пользователи найдены.
        if (srcUser != null && destUser != null) {
            //определим счет отправления.
            for (Account act : this.bank.get(srcUser)) {
                if (act.getRequisites().equals(srcRequisite)) {
                    break;
                }
                srcIndex++;
            }
            //определим счет получателя.
            for (Account act : this.bank.get(destUser)) {
                if (act.getRequisites().equals(dstRequisite)) {
                    break;
                }
                destIndex++;
            }
            //если достаточно средств списываем и зачисляем на счет получателя.
            if (this.bank.get(srcUser).get(srcIndex) != null && this.bank.get(srcUser).get(srcIndex).getValue() - amount > 0) {
                //проверяем счет зачисления.
                if (this.bank.get(srcUser).get(srcIndex) != null) {
                    this.bank.get(srcUser).get(srcIndex).setValue(this.bank.get(srcUser).get(srcIndex).getValue() - amount);
                    this.bank.get(destUser).get(destIndex).setValue(this.bank.get(destUser).get(destIndex).getValue() + amount);
                    result = true;
                }
            }
        }
        return result;
    }
}
