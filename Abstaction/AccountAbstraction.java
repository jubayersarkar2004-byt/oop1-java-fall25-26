package Abstaction;

//Design an abstract class Account that includes:

//accountHolderName

//A constructor to initialize the name

//An abstract method calculateInterest()

//A concrete method showAccount()

//Create a subclass SavingsAccount where:

//Interest is calculated based on balance and rate

abstract class Account {

    String accountHolderName;

    //constructor
    public Account(String name){

        this.accountHolderName = name;
    }
    public String getAccountHolderName(){
        return accountHolderName;
    }

    //abstruct method
    public abstract double calculateInterest();

    // regular method
    void showAccount(){};
}

class SavingsAccount extends Account {
 
    double balance;
    double rate;

    public SavingsAccount(String accountHolderName , double balance , double rate){
       
        super(accountHolderName);
        this.balance = balance;
        this.rate = rate;

    }
    
    @Override
    public double calculateInterest(){

        return (balance * rate)/100;
    }

    @Override
    void showAccount(){

        System.out.println("Account Holder:" + super.getAccountHolderName());
        System.out.println("Your current balance:" + balance);
        System.out.println("Interest:" + calculateInterest());
        System.out.println("Interest Rate:" + rate + "%");

    }

}
public class AccountAbstraction {

    public static void main(String[] args) {

        Account a1 = new SavingsAccount("Sarkar,Jubayer", 500000, 2.5);
        a1.showAccount();

        Account a2 = new SavingsAccount("Abdullah", 150000, 0.5);
        a2.showAccount();

        
    }
    
}
