
import java.util.Scanner;
public class MortgageCalculatorv1 {

    public static void main(String[] args)
    {

      Scanner sc =new Scanner(System.in);

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
