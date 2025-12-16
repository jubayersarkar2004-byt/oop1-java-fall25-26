public class TernaryOperator {
    public static void main(String[] args) {
        int income = 1200000;
        String className = (income > 100000) ? "First class seat" : "Economy class seat";
        System.out.println("Class: " + className);
    }
} 