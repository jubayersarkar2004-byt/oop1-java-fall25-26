public class MathClass {
    public static void main(String[] args) {
        int roundResult = Math.round(1.1f);
        System.out.println("roundResult: " + roundResult);

        double powerResult = Math.pow(2, 3);
        System.out.println("powerResult: " + powerResult);

        double sqrtResult = Math.sqrt(16);
        System.out.println("sqrtResult: " + sqrtResult);

        double randomValue = Math.random();
        System.out.println("randomValue: " + randomValue);

        int ceilValue = (int) Math.ceil(4.3);
        System.out.println("ceilValue: " + ceilValue);

        int floorValue = (int) Math.floor(4.7);
        System.out.println("floorValue: " + floorValue);

        double maxValue = Math.max(10, 20);
        System.out.println("maxValue: " + maxValue);

        double minValue = Math.min(10, 20);
        System.out.println("minValue: " + minValue);
    }
}
 