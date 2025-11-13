
import java.util.Arrays;
public class MultiDimArrays {

    public static void main(String[] args) {

    int[] [] numbers =new int[3][3];
    numbers[0][0]=10;
    numbers[0][1]=20;
    numbers[0][2]=30;
    numbers[1][0]=40;



    System.out.println("Array elements: " + Arrays.toString(numbers));
   //System.out.println(Arrays.deepToString(numbers));

        int[][] predefined = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
       System.out.println(Arrays.deepToString(predefined));
       
    }
}
