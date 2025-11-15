
import java.util.Scanner;
public class MortgageV1 {

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

  
   //  Credit Score 
   int schore1;
        
        while (true) {
          
            System.out.println("Enter your credit score (0–500): ");
            if (sc.hasNextInt()) 
              {
                 schore1 = sc.nextInt();
                    if (schore1 >= 0 && schore1 <= 500) {
                        System.out.println("Your credit score: " + schore1);
                        if (schore1 >= 300) {
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
            
            }
            sc.next();
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

        

    }


  

    }
  
    

