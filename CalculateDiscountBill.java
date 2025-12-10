
import java.util.Scanner;
public class CalculateDiscountBill {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        float price;
        float discount;

        System.out.print("Enter Price:");
        price = sc.nextFloat();

        System.out.print("Enter discout(%):");
        discount = sc.nextFloat();

        //calculation

    double discountPrice = price*(discount/100.00);

    double finalPrice = price - discountPrice;


    //print product price

    System.out.println("Product price:" + price);
    System.out.println("Prcie less:" + discountPrice);
    System.out.println("Final bill:"+  finalPrice);

    
}
}

