
// there are 3 classes 
//Employee ==>position==>company

//===Employee===

class Employee {
private String name;
private Position position;



public Employee(String name,Position position){

    this.name=name;
    this.position = position;
}


public String getName() {
    return name;
}

public Position getPosition(){

    return position;
}

    
}

//==position===

class Position {
//filed
private String title;
private double salary;

//constructor
public Position(String title , double salary){

this.title=title;
this.salary=salary;

}

//getter 

public String getTitle(){

    return title;
}

public double getSalary(){

    return salary;
}



   // public String toString() {
     //   return title + ", " + salary;
    //}

}

//===company==

class Company {

//filed

private String companyName;
private Employee[] employees;
private int count=0;

// constructor

public Company(String companyName ,int capacity) {

this.companyName = companyName;
this.employees = new Employee[capacity];

}

//method

public void addEmployee(Employee e){

if(count<employees.length){
employees[count] = e;
count++;

}

}

public void showDetails(){

System.out.println("Company:"+ companyName);
System.out.println("Employess:");

for(int i =0 ; i<count; i++){

    System.out.println("-"+
      employees[i].getName()+
    " |Position:"+employees[i].getPosition().getTitle()+
    "|salary:"+employees[i].getPosition().getSalary());
  
   }

}


}

public class RelationshipEmployee {

 public static void main(String[] args){

Company company = new Company("Al-fursan", 3);

company.addEmployee(new Employee("abdullah",
    new Position("Cahsier", 300000)));

company.addEmployee(new Employee("jubayer",
    new Position("manager", 25000)));
    
company.addEmployee(new Employee("fahim",
    new Position("attendent", 5000)));    
    
    company.showDetails();

 }

}
