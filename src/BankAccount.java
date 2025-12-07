package model;

import annotations.Cache;

/**
 * Класс, представляющий банковский счет.
 * <p>Содержит информацию о номере счета и балансе, а также методы
 * для операций со счетом (пополнение, снятие).</p>
 *
 * <p>Класс помечен аннотацией {@link annotations.Cache} для указания
 * кэшируемых областей: "balance", "transactions", "account_info", "user_data".</p>
 *
 * @see annotations.Cache
 */
@Cache({"balance", "transactions", "account_info", "user_data"})
public class BankAccount {

    /** Номер банковского счета. Должен состоять из 10 цифр. */
    private String accountNumber;

    /** Текущий баланс на счете. */
    private double balance;

    /**
     * Создает банковский счет с номером "0000000000" и нулевым балансом.
     */
    public BankAccount() {
        this.accountNumber = "0000000000";
        this.balance = 0.0;
    }

    /**
     * Создает банковский счет с указанными номером и балансом.
     *
     * @param accountNumber номер счета
     * @param balance начальный баланс
     * @throws IllegalArgumentException если номер счета или баланс некорректны
     *
     * @see #setAccountNumber(String)
     * @see #setBalance(double)
     */
    public BankAccount(String accountNumber, double balance) {
        setAccountNumber(accountNumber);
        setBalance(balance);
    }

    /**
     * Возвращает номер банковского счета.
     *
     * @return номер счета
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Устанавливает номер банковского счета.
     * <p>Номер счета должен соответствовать следующим требованиям:
     * <ul>
     *   <li>Не может быть {@code null} или пустой строкой</li>
     *   <li>Должен состоять ровно из 10 цифр</li>
     *   <li>Пробелы в начале и конце обрезаются</li>
     * </ul>
     * </p>
     *
     * @param accountNumber номер счета для установки
     * @throws IllegalArgumentException если номер счета некорректен
     */
    public void setAccountNumber(String accountNumber) {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Номер счета не может быть пустым");
        }
        if (!accountNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Номер счета должен состоять из 10 цифр");
        }
        this.accountNumber = accountNumber.trim();
    }

    /**
     * Возвращает текущий баланс на счете.
     *
     * @return текущий баланс
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Устанавливает баланс на счете.
     *
     * @param balance новый баланс
     * @throws IllegalArgumentException если баланс отрицательный
     */
    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Баланс не может быть отрицательным");
        }
        this.balance = balance;
    }

    /**
     * Пополняет счет на указанную сумму.
     *
     * @param amount сумма для пополнения
     * @throws IllegalArgumentException если сумма не положительная
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма пополнения должна быть положительной");
        }
        this.balance += amount;
    }

    /**
     * Снимает деньги со счета.
     *
     * @param amount сумма для снятия
     * @throws IllegalArgumentException если:
     *         <ul>
     *           <li>сумма не положительная</li>
     *           <li>недостаточно средств на счете</li>
     *         </ul>
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма снятия должна быть положительной");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Недостаточно средств на счете");
        }
        this.balance -= amount;
    }

    /**
     * Проверяет возможность снятия указанной суммы со счета.
     *
     * @param amount сумма для проверки
     * @return {@code true} если сумма положительная и на счете достаточно средств,
     *         {@code false} в противном случае
     */
    public boolean canWithdraw(double amount) {
        return amount > 0 && amount <= balance;
    }

    /**
     * Возвращает строковое представление банковского счета.
     *
     * @return строку в формате "Счет: [номер], Баланс: [баланс] руб."
     */
    @Override
    public String toString() {
        return String.format("Счет: %s, Баланс: %.2f руб.", accountNumber, balance);
    }
}
