
import java.util.Scanner;
public class MortgageEligibilityV1 {

    public static void main(String[] args){

  Scanner sc = new Scanner(System.in);

  //Salary check
 double Salary;
  
while(true) {
  System.out.println("Enter your Salary");
  if(sc.hasNextDouble())
    {
       Salary = sc.nextDouble();
      System.out.println("your monthly saraly"+ Salary);
      if(Salary>100000)
      {
        System.out.println("You are eligible for loan");
      }
      else{
        System.out.println("You are not eligible for loan");
      }
    }
    else{
        System.out.println("Invalid input!,please enter a numeric value.");
    }
  }

  int creditScore;
   //  Credit Score 
        while (true) {
            
            System.out.println("Enter your credit score (0–500): ");
            if (sc.hasNextInt()) {
                creditScore = sc.nextInt();
                if (creditScore >= 0 && creditScore <= 500) {
                    System.out.println("Your credit score: " + creditScore);
                    if (creditScore >= 300) {
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
  
  

      System.out.println("Do you have any criminal record?(true/false)");
       
        while (true) {
          if(!sc.hasNextBoolean())
          { boolean criminal = sc.nextBoolean();
          if(criminal==false)
          {System.out.println("You are eligible for loan");}
          else{
            System.out.println("You are not eligible for loan");
          }
          
        }
      }

          System.out.println("Enter loan amount: ");
      double p = sc.nextDouble();//p

    System.out.println("Enter interest rate:");
    float r = sc.nextFloat();//r

    System.out.println("Enter loan term (in years):");
    int m = sc.nextInt();

    //calculation 

     float interest =((r/100)/12);
     //System.out.println("interest" + interest);

     int n = (m*12);
     //System.out.println("n" + n);
     double pow= Math.pow((1+interest), n);

     double payable = p* ((interest*pow)/(pow-1.00));
     
     System.out.println("payeble amount" + payable);


        

    }


  

    }
  
    

