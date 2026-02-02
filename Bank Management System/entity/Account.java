package entity;

public class Account implements java.io.Serializable {
    private static final long serialVersionUID = 2L; 
    private String accountNo, name, age, address, email, phone, accType;
    private double balance, salary; 
    private int creditScore; 
    private boolean criminalRecord; 

    // Primary 11-parameter constructor
    public Account(String accountNo, String name, double balance, String age, String address, 
                   String email, String phone, String accType, double salary, int creditScore, boolean criminalRecord) {
        this.accountNo = accountNo != null ? accountNo : "UNKNOWN";
        this.name = name != null ? name : "N/A";
        this.balance = Math.max(0, balance);
        this.age = age != null ? age : "N/A";
        this.address = address != null ? address : "N/A";
        this.email = email != null ? email : "N/A";
        this.phone = phone != null ? phone : "N/A";
        this.accType = accType != null ? accType : "Savings";
        this.salary = Math.max(0, salary);
        this.creditScore = Math.max(0, creditScore);
        this.criminalRecord = criminalRecord;
    }

    // Compatibility constructor (3 parameters)
    public Account(String accNo, String name, double bal) {
        this(accNo, name, bal, "N/A", "N/A", "N/A", "N/A", "Savings", 0.0, 0, false);
    }
    
    // Compatibility constructor (8 parameters from previous iteration)
    public Account(String accountNo, String name, double balance, String age, String address, String email, String phone, String accType) {
         this(accountNo, name, balance, age, address, email, phone, accType, 0.0, 0, false);
    }


    // Getters
    public String getAccountNo() 
       { return accountNo; }
    public String getName()
       { return name; }
    public double getBalance() 
       { return balance; }
    public String getAge() 
       { return age; }
    public String getAddress() 
       { return address; }
    public String getEmail() 
       { return email; }
    public String getPhone()  
       { return phone; }
    public String getAccType() 
       { return accType; }
    public double getSalary()  
       { return salary; }
    public int getCreditScore() 
       { return creditScore; }
    public boolean hasCriminalRecord() 
       { return criminalRecord; }

    // Setters (if balance needs updating after creation)
    public void setBalance(double balance) 
     
        { this.balance = balance; }

    /** Converts object to a CSV string for file storage */
    public String toFileString() {
        return String.join(",", accountNo, name, String.valueOf(balance), age, address, email, phone, accType, 
                           String.valueOf(salary), String.valueOf(creditScore), String.valueOf(criminalRecord));
    }

    /** Factory method to reconstruct an Account from a CSV line */
    public static Account fromFileString(String line) {
        if (line == null || line.trim().isEmpty()) return null;
        String[] data = line.split(",");
        
        try {
            if (data.length >= 11) {
                return new Account(
                    data[0], data[1], Double.parseDouble(data[2]), data[3], data[4], data[5], data[6], data[7], 
                    Double.parseDouble(data[8]), Integer.parseInt(data[9]), Boolean.parseBoolean(data[10])
                );
            } else if (data.length == 8) {
                 return new Account(data[0], data[1], Double.parseDouble(data[2]), data[3], data[4], data[5], data[6], data[7]);
            } else if (data.length == 3) {
                 return new Account(data[0], data[1], Double.parseDouble(data[2]));
            }
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.err.println("Error parsing account data from line: " + line);
        }
        return null;
    }

    @Override
    public String toString() {
        return String.format("Acc: %-10s | Name: %-15s | Type: %-10s | Balance: $%,.2f", accountNo, name, accType, balance);
    }
}
