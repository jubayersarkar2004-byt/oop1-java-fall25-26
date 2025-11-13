
import java.util.Scanner;
public class NormalCalculator {
    public static void main(String[] args){
//create a simple calculator by using switch case

//creating user input process

Scanner sc = new Scanner(System.in);

System.out.println("Enter value of a:");
double a = sc.nextDouble();

System.out.println("Enter a method (+, -, /, *):");
char c = sc.next().charAt(0);  // to take character input

System.out.println("Enter value of b");
double b= sc.nextDouble();     

//applying switch case

switch (c) {
    case '+':
    System.out.println("Summation:" + (a+b));// addition
        
        break;

        case '-':
        System.out.println("substraction:" + (a-b));

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
