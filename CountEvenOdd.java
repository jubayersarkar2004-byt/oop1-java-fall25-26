
import java.util.Scanner;
public class CountEvenOdd {
    public static void main(String[] args)
    {
   
        //Scanner obj create
        Scanner sc = new Scanner(System.in);

        //array declaration

        int[] arry = new int[5];

        int evenCount = 0;
        int oddCount = 0;
        //input array
        for(int i=0;i<5;i++)
        {
            System.out.print("Enter Number"+" " + (i+1)+":");
            arry[i] = sc.nextInt();
            if(arry[i]%2!=0)
            {
            
                oddCount++;
            }
            else{
            
                evenCount++;
            }

        }

     System.out.println("Even numbers:" + evenCount++);
     System.out.println("Odd number:" +oddCount++);





    }
}
