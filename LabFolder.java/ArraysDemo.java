
import java.util.Arrays;
public class ArraysDemo {

    public static void main(String[] args) {
    
    int[] array =new int[5];
    array[0]=10;
    array[1]=20;        
    array[2]=30;
    array[3]=40;    

    System.out.println("Array elements: " + Arrays.toString(array));

    //create an array of integers
    int[] numbers = {10, 20, 30, 40, 50};
    //sort the array
    Arrays.sort(numbers);
    //print the sorted array and its length
    System.out.println("Sorted numbers: " + Arrays.toString(numbers));
   //print the length of the array
    System.out.println("Length of numbers array: " + numbers.length);
    

      
            
    }
}