public class AccountMain {
    public static void main(String[] args) {

        Account a1 = new Account();     // empty constructor

        a1.setAccountHolder("Steve");
        a1.setAccountNum(101);
        a1.setBalance(1500);

        System.out.println("A1 Name: " + a1.getAccountHolder());
        System.out.println("A1 Account Number: " + a1.getAccountNum());
        System.out.println("A1 Balance: " + a1.getBalance());

        // using methods
        a1.deposit(-500);
        a1.deposit(500);
        System.out.println("Updated A1 Balance: " + a1.getBalance());

        a1.withdraw(2000);
        System.out.println("Updated A1 Balance: " + a1.getBalance());

        // WARNING: a2 used before declaration → FIXED in Java version
        Account a2 = new Account("Peter", 102, 2500);
        a2.showDetails();

        a2.deposit(-500);
        a2.deposit(500);
        System.out.println("Updated A2 Balance: " + a2.getBalance());

        a2.withdraw(2000);
        System.out.println("Updated A2 Balance: " + a2.getBalance());

        // Transfer
        a1.transferMoney(a2, 50000);
        System.out.println("After transfer:");
        System.out.println("Updated A1 Balance: " + a1.getBalance());
        System.out.println("Updated A2 Balance: " + a2.getBalance());
    }
}
