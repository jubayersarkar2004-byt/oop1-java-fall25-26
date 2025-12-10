import java.util.Scanner;
public class NormalCalculator {
    public static void main(String[] args){
//create a simple calculator by using switch case

//creating user input process

Scanner sc = new Scanner(System.in);

double a = 0;
double b = 0;
char c;

System.out.println("Enter value of a:");
if(sc.hasNextDouble()) {

  a = sc.nextDouble();

} else {
    System.out.println("Invalid input. Please enter a numeric value.");
    sc.next();// clear the invalid input
   return;// exit the program

}

System.out.println("Enter a method (+, -, /, *):");
if(sc.hasNext()) {
 c = sc.next().charAt(0);  // to take character input
} else {
    System.out.println("Invalid input. Please enter a valid operator.");
    sc.next(); // clear the invalid input
   return; // exit the program
   
}

System.out.println("Enter value of b");
if(sc.hasNextDouble()) {
 b = sc.nextDouble();
} else {
    System.out.println("Invalid input. Please enter a numeric value.");
    sc.next(); // clear the invalid input
  // return; // exit the program
}
   

//applying switch case

switch (c) {
    case '+':
    System.out.println("Summation:" + (a+b));// addition
        
        break;

        case '-':
        System.out.println("substraction:" + (a-b));// subtraction   

        break;

        case '/':

        System.out.println("Division:" + (a/b));// division

        break;

        case '*':
        System.out.println("Multiplication:" + (a * b));// multiplication

        break;


    default:

      System.out.println("Invalid operator");
        break;
}


    }
    
}
