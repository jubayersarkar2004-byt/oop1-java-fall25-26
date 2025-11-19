import java.util.Scanner;

public class ScannerClass1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        byte age = sc.nextByte();   

        System.out.print("Enter your name: ");
        sc.nextLine(); // Consume the leftover newline
        String name = sc.nextLine().trim();

        System.out.println("Your name is: " + name);
        System.out.println("Your age is: " + age);

        sc.close();
    }
}
 