public class Account {

    private String accountHolder;
    private int accountNum;
    private double balance;

    // ----- Setters -----
    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Invalid!");
        }
    }

    // ----- Getters -----
    public String getAccountHolder() {
        return accountHolder;
    }

    public int getAccountNum() {
        return accountNum;
    }

    public double getBalance() {
        return balance;
    }

    // ----- Empty Constructor -----
    public Account() {
        System.out.println("I am an empty constructor");
    }

    // ----- Parameterized Constructor -----
    public Account(String accountHolder, int accountNum, double balance) {
        System.out.println("I am a parameterized constructor");
        setAccountHolder(accountHolder);
        setAccountNum(accountNum);
        setBalance(balance);
    }

    // ----- Display -----
    public void showDetails() {
        System.out.println("Account Holder = " + accountHolder);
        System.out.println("Account Number = " + accountNum);
        System.out.println("Balance = " + balance);
    }

    // ----- Methods -----
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited successfully.");
        } else {
            System.out.println("Deposit failed.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= 500) {
            balance -= amount;
            System.out.println("Withdraw successfully.");
        } else {
            System.out.println("Withdraw failed.");
        }
    }

    public void transferMoney(Account receiver, double amount) {
        if (amount > 0 && balance >= amount) {
            this.balance -= amount;
        } else {
            System.out.println("Invalid input");
        }

        if (amount > 0) {
            receiver.balance += amount;
        } else {
            System.out.println("Invalid");
        }
    }
}
