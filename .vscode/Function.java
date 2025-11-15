

public class Function {

    void sumOfTwoNumbers(int a,int b)
    {
        int a1=25;
        int b1=35;
        int sum=a1+b1;
        System.out.println("Sum is: " + sum);
    }

    public static void main(String[] args) {
        Function obj=new Function();
        obj.sumOfTwoNumbers(25,35);
    }
    
}
