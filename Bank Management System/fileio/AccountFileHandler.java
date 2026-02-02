package fileio;

import entity.Account;
import java.io.*;
import java.util.ArrayList;


  // Handles reading and writing Account objects to a text file
public class AccountFileHandler {
    private static final String FILE_PATH = "fileio/account.txt";

    public static void addAccount(Account acc) throws IOException {
        File file = new File(FILE_PATH);
        if (file.getParentFile() != null) {
            file.getParentFile().mkdirs();
        }
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write(acc.toFileString() + "\n");
        }
    }

    // Retrieves all accounts from the file
    public static ArrayList<Account> getAllAccounts() throws IOException {
        ArrayList<Account> accounts = new ArrayList<>();
        File file = new File(FILE_PATH);
        if (!file.exists()) return accounts;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                Account acc = Account.fromFileString(line);
                if (acc != null) accounts.add(acc);
            }
        }
        return accounts;
    }

       // Updates the balance of a specific account
    public static void updateBalance(String accNo, double amount, boolean isDeposit) throws IOException {
        ArrayList<Account> accounts = getAllAccounts();
        boolean found = false;
        
        for (int i = 0; i < accounts.size(); i++) {
            Account acc = accounts.get(i);
            if (acc.getAccountNo().equalsIgnoreCase(accNo)) {
                double newBal = isDeposit ? acc.getBalance() + amount : acc.getBalance() - amount;
                if (!isDeposit && newBal < 0) throw new IOException("Insufficient Funds");
                
                // Must use all parameters to preserve details (age, address, email, etc.)
                accounts.set(i, new Account(
                    acc.getAccountNo(), acc.getName(), newBal, acc.getAge(), acc.getAddress(), acc.getEmail(), 
                    acc.getPhone(), acc.getAccType(), acc.getSalary(), acc.getCreditScore(), acc.hasCriminalRecord()
                ));
                found = true;
                break;
            }
        }
        if (!found) throw new IOException("Account not found: " + accNo);
        saveAll(accounts);
    }

    // Deletes an account by account number
    public static void deleteAccount(String accNo) throws IOException {
        ArrayList<Account> accounts = getAllAccounts();
        boolean removed = accounts.removeIf(acc -> acc.getAccountNo().equalsIgnoreCase(accNo));
        if (removed) {
            saveAll(accounts);
        }
    }

       // Saves the entire list of accounts back to the file
    private static void saveAll(ArrayList<Account> accounts) throws IOException {
        try (FileWriter fw = new FileWriter(FILE_PATH, false)) {
            for (Account acc : accounts) {
                fw.write(acc.toFileString() + "\n");
            }
        }
    }
}
