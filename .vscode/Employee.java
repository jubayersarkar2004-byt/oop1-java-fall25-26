public class Employee {
    private int baseSalary; // Encapsulated field
    private int hourlyRate;

    public static int numberOfEmployees; // Static field

    public Employee(int baseSalary) { // Constructor
        // setBaseSalary(baseSalary);
        // setHourlyRate(0);
        this(baseSalary, 0);
    }

    public Employee(int baseSalary, int hourlyRate) { // Constructor
        // this.baseSalary = baseSalary;
        // this.hourlyRate = hourlyRate;
        setBaseSalary(baseSalary);
        setHourlyRate(hourlyRate);
        numberOfEmployees++;
    }

    public static int getNumberOfEmployees() { // Static method
        return numberOfEmployees;
    }

    public int getHourlyRate() { // Getter
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) { // Setter with validation
        if (hourlyRate > 0) {
            this.hourlyRate = hourlyRate;
        } else {
            throw new IllegalArgumentException("Hourly rate cannot be negative.");
        }
    }

    // public int calculateWage() {
    // return baseSalary;
    // }

    public int calculateWage(int extraHours) {
        return baseSalary + (extraHours * hourlyRate);
    }

    public void setBaseSalary(int baseSalary) {
        if (baseSalary >= 0) {
            this.baseSalary = baseSalary;
        } else {
            throw new IllegalArgumentException("Base salary cannot be negative.");
        }
    }

    public int getBaseSalary() {
        return baseSalary;
    }
}
 