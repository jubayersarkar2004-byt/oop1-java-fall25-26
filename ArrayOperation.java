
import java.util.Scanner;

public class ArrayOperation {

public static void main(String[] args){

//declaration array sized

Scanner sc =  new Scanner(System.in);

System.out.println("Enter array size:");
int size = sc.nextInt();

int[] num = new int[size];

//input array element 

int sum = 0; 

System.out.println("Enter array element:");
for(int i=0; i<size; i++)
{
 System.out.print("elements" + (i+1) + ":");
 num[i] = sc.nextInt();
 sum += num[i];

}

 System.out.println("Sum of array elements:" + sum);

 double average = (double)sum/size;
 System.out.println("Average of array elements:" + average);
    sc.close();
    

 
}

}

