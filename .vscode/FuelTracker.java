import java.util.Scanner;

public class FuelTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] fuel = new double[7]; // Array to store fuel consumption for 7 days
        double total = 0;
        double maxFuel = 0;
        int maxDay = 0;

        // Input fuel consumption for each day
        for (int i = 0; i < 7; i++) {
            System.out.print("Enter fuel consumed on day " + (i + 1) + " (litres): ");
            fuel[i] = sc.nextDouble();
            total += fuel[i];

            // Check for highest fuel usage
            if (fuel[i] > maxFuel) {
                maxFuel = fuel[i];
                maxDay = i + 1; // store the day (1-based)
            }
        }

        // Display results
        System.out.println("\nTotal fuel consumed in 7 days: " + total + " litres");
        System.out.println("Highest fuel usage was on day " + maxDay + " with " + maxFuel + " litres");

        sc.close();
    }
}
