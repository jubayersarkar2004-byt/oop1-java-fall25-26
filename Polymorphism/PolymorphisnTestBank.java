package Polymorphism;
//Create a Java program for a Bank system with the following requirements:
//Create a class BankAccount
//Overload a method calculateInterest()
//Use constructor overloading
//Create a subclass SavingsAccount
//Override calculateInterest()
//Demonstrate polymorphic behavior using a parent reference

class BankAccount {
    double balance;
    double rate;

    // Constructor Overloading
    BankAccount() {
        balance = 0;
        rate = 0.0;
    }
                                                //more that 2 constructor is constructor overloading 
    BankAccount(double balance) {
        this.balance = balance;                        //constructor overloading 
        rate = 3.0;                                           // ||
    }                                                           // Method overloading

    BankAccount(double balance, double rate) {
        this.balance = balance;
        this.rate = rate;    
    }

    // Method Overloading
    double calculateInterest() {
        return balance * rate / 100;
    }

    double calculateInterest(int years) {
        return balance * rate * years / 100;
    }
}

class SavingsAccount extends BankAccount {

    SavingsAccount(double balance) {
        super(balance);
        rate = 5.0;
    }

    // Method Overriding
    @Override
     
    double calculateInterest() {
        return balance * rate / 100;
    }
}

public class PolymorphisnTestBank {
    public static void main(String[] args) {

        // Polymorphic Behavior
        BankAccount account;

        account = new SavingsAccount(10000);
        System.out.println("Interest: " + account.calculateInterest());

        System.out.println("Interest for 2 years: " + 
                           account.calculateInterest(2));
    }
} 
