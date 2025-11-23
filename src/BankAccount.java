@Cache({"balance", "transactions", "account_info", "user_data"})
public class BankAccount {
    private String accountNumber;
    private double balance;

    public BankAccount() {
        this.accountNumber = "0000000000";
        this.balance = 0.0;
    }

    public BankAccount(String accountNumber, double balance) {
        setAccountNumber(accountNumber);
        setBalance(balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Номер счета не может быть пустым");
        }
        if (!accountNumber.matches("\\d{10}")) {
            throw new IllegalArgumentException("Номер счета должен состоять из 10 цифр");
        }
        this.accountNumber = accountNumber.trim();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Баланс не может быть отрицательным");
        }
        this.balance = balance;
    }

    //Пополнение счета
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма пополнения должна быть положительной");
        }
        this.balance += amount;
    }

    //Снятие денег со счета
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Сумма снятия должна быть положительной");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Недостаточно средств на счете");
        }
        this.balance -= amount;
    }

    //Проверка возможности снятия денег
    public boolean canWithdraw(double amount) {
        return amount > 0 && amount <= balance;
    }

    @Override
    public String toString() {
        return String.format("Счет: %s, Баланс: %.2f руб.", accountNumber, balance);
    }
}