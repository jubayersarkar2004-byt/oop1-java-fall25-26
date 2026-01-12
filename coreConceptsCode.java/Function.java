

public class Function {

//method to sum two numbers
    void sumOfTwoNumbers(int a,int b)
    {
        int a1=25;
        int b1=35;
        int sum=a1+b1;
        System.out.println("Sum is: " + sum);
    }

    public static void main(String[] args) {
            //create an object of Function class
        Function obj=new Function();
        //call the method
        obj.sumOfTwoNumbers(25,35);
    }
    
}
