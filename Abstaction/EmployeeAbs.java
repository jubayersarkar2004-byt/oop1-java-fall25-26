package Abstaction;

abstract class Employee {

  String name;
  
  public Employee(String name){
 
    this.name = name;
 
   }

   public String getName(){
  
    return name;

   }

  //abstruct method
  public abstract double calculateSalary();

  //regular method
  void showDetails(){
  
    System.out.println("called parent abstruct class");

  }

}

class FullTimeEmploye extends Employee {

  double salary;
  int extraHour;

  //constructor

  public FullTimeEmploye(String name, double salary , int extraHour){

    super(name);
    this.salary = salary;
    this.extraHour = extraHour;

  }

  @Override
  public double calculateSalary(){

    double netSalary = salary;//base salary
     
  if(extraHour>=8){

    netSalary = salary + (salary * 0.5);

   }
     return netSalary;
  
}


@Override
void showDetails(){

System.out.println("Employee name:" + super.getName());
System.out.println("Monthly salary:" + calculateSalary());

  }

  }

public class EmployeeAbs {
    
    public static void main(String[] args) {
        
    
        Employee e1 = new FullTimeEmploye("Jubayer", 250000, 10);
       
        e1.showDetails();





    }
}
