
import java.util.Scanner;
public class MortgageCalculatorV2 {

    public static void main(String[] args){

  Scanner sc = new Scanner(System.in);

  //Salary check
 double Salary;
  
while(true) {
  System.out.println("Enter your Salary");
  if(sc.hasNextDouble())
    {
       Salary = sc.nextDouble();
      System.out.println("your monthly saraly = "+ Salary);
      if(Salary>100000)
      {
        System.out.println("You are eligible for loan");
      }
      else{
        System.out.println("You are not eligible for loan,rason: your salary is less than 100000");
      }
      break;
    }
    else{
        System.out.println("Invalid input!,please enter a numeric value.");
       }
        sc.next(); // clear invalid input
  }

  int CreditScore;
   //  Credit Score check
        while (true) {
            
            System.out.println("Enter your credit score (0–500): ");
            if (sc.hasNextInt()) {
                CreditScore = sc.nextInt();
                if (CreditScore >= 0 && CreditScore <= 500) {
                    System.out.println("Your credit score: " + CreditScore);
                    if (CreditScore >= 300) {
                        System.out.println("You are eligible for loan based on credit score.");
                    } else {
                        System.out.println(" You are not eligible for loan (score below 300).");
                    }
                    break;
                } else {
                    System.out.println(" Credit score must be between 0 and 500.");
                }
            } else {
                System.out.println(" Invalid input! Please enter an integer value for credit score.");
                sc.next(); // clear invalid input
            }
        }
  
  
       // Criminal Record check
      boolean criminal=false;
       
        while (true) {
            System.out.println("Do you have any criminal record?(true/false)");
          if(sc.hasNextBoolean())
          { criminal = sc.nextBoolean();
          if(criminal==false)
          {
            System.out.println("You are eligible for loan");
            }
          else{
            System.out.println("You are not eligible for loan");
          }
          break;
      }
       else{
            System.out.println("Invalid input! Please enter true or false.");
           sc.next(); // clear invalid input
          
        }
    }

    // Mortgage Calculation

    if(Salary>100000 && CreditScore>=300 && criminal==false)
    {
     System.out.println("Enter your desired loan amount: ");

      double principalAmount = sc.nextDouble();//p

    System.out.println("Enter interest rate(%):");
    float interestRate = sc.nextFloat();//r

    System.out.println("Enter loan term (in years):");
    int year = sc.nextInt();//m
    

    //calculation 

     float interest = (interestRate/100)/12;//monthly interest rate
     //System.out.println("interest" + interest);

     int n = (year*12);//total number of payments

     //System.out.println("n" + n);
     double fractionPart = Math.pow((1 + interest), n);

     double payable = principalAmount * (interest*fractionPart)/(fractionPart-1.00);


     System.out.println("===Mortgage calculation===");
     System.out.println("desired loan amount: " + principalAmount);
     System.out.println("annual interest rate: " + interestRate + "%");
     System.out.println("loan term (in years): " + year);
     System.out.println("Monthly payable amount: " + payable);  


     

    }



  

    }
}
  
    


