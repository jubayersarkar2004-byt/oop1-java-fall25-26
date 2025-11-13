

 import java.util.Scanner;
public class Arrays {

    public static void main(String[] args)
    {
    
 Scanner sc = new Scanner(System.in);
 
 System.out.print("Enter array size: ");
 int size = sc.nextInt();

 int[] num = new int[size];

 System.out.println("Enter array elements:");
 for(int i = 0; i < size; i++) {
     System.out.print("Element " + (i + 1) + ": ");
     num[i] = sc.nextInt();
 }

 int sum = 0;
 for(int n : num) {
     sum += n;
 }
 double average = (double) sum / size;

 int largest = num[0];
 int smallest = num[0];
 for (int n : num) {
     if (n > largest) largest = n;
     if (n < smallest) smallest = n;
 }

 System.out.println("Sum: " + sum);
 System.out.println("Average: " + average);
 System.out.println("Largest: " + largest);
 System.out.println("Smallest: " + smallest);

 sc.close();



    }
    
}
