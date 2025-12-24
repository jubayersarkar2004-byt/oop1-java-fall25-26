

public class SoftwareEngineer extends Employee {

    private double salary;
    private String company;

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompany() {
        return company;
    }

    public SoftwareEngineer() {
        System.out.println("I am an empty constructor of SoftwareEngineer class");
    }

    public SoftwareEngineer(String name, int id, int experience, double salary, String company) {
        super(name ,id, experience);
        this.salary = salary;
        this.company = company;

        System.out.println("I am a parameterized constructor of SoftwareEngineer class");
    }


    public void showDetails() {
        super.showDetails();
        System.out.println("Salary: " + salary);
        System.out.println("Company: " + company);
    }

    public double calculateBonus() {
        if (getExperience() > 3) {   // FIXED
            return salary * 0.05;
        } else {
            System.out.println("You are not eligible for bonus");
            return 0;
        }
    }
}
