public class ProceduralProgramming {

    public static void main(String[] args) {
        var employee1 = new Employee(50000, 20);
        int totalWage = employee1.calculateWage(10);
        System.out.println("Total Wage: " + totalWage);

         var employee2 = new Employee(60000);
         System.out.println("Number of Employees: " + Employee.getNumberOfEmployees());
    }

}