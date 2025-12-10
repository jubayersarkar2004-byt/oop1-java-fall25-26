
import java.util.Scanner;
public class SimpleLOginSystem {

    public static void main(String[] args) {



        Scanner sc = new Scanner(System.in);

        String correctPassword = "jub@yer2003";
        int attempts = 3;
        String input;

        while (attempts > 0) {
            System.out.print("Enter password: ");
            input = sc.nextLine();

            if (input.equals(correctPassword)) {
                System.out.println("Login Successful!");
                return; // exit the program
            } else {
                attempts--;
                System.out.println("Wrong password! Attempts left: " + attempts);
            }
        }

        System.out.println("Account Locked! Too many wrong attempts.");
    }
}


    
    
