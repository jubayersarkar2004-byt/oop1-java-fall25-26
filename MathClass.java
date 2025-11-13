public class MathClass {

    public static void main(String[] args)
    {
       double num = 23.7;
         System.out.println("Original number: " + num);

         // Rounding the number
            long roundedNum = Math.round(num);
            System.out.println("Rounded number: " + roundedNum);

            // Finding the ceiling value
            double ceilNum = Math.ceil(num);
            System.out.println("Ceiling value: " + ceilNum);

            // Finding the floor value
            double floorNum = Math.floor(num);
            System.out.println("Floor value: " + floorNum);

            // finding absolute value
            double absNum = Math.abs(-num);
            System.out.println("Absolute value: " + absNum);

            // finding square root
            double sqrtNum = Math.sqrt(num);
            System.out.println("Square root: " + sqrtNum);

            // finding power 
            double powerNum=Math.pow(2,3);
            System.out.println("2 to the power 3 is: " + powerNum);

            //finding maximum and minimum
            double maximum =Math.max(50,20);
            double minimum =Math.min(50,20);
            System.out.println("Maximum value: " + maximum);
            System.out.println("Minimum value: " + minimum);

            //generating random number
            double randomNum =Math.random();
            System.out.println("Random number: " + randomNum);

            //generating random number between 1 to 100
            int randomBetween1And100 = (int)(Math.random() * 100) + 1;
            System.out.println("Random number between 1 and 100: " + randomBetween1And100);

            //generating random number between 50 to 150
            int randomBetween50And150 = (int)(Math.random() * 101) + 50;
            System.out.println("Random number between 50 and 150: " + randomBetween50And150);





    }
    
}
