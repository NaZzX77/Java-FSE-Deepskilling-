public class Solution {
    public static double calculateFutureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }

        return calculateFutureValue(presentValue, growthRate, years - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {
        double presentValue = 10000.0;
        double growthRate = 0.08;
        int years = 5;

        double futureValue = calculateFutureValue(presentValue, growthRate, years);
        System.out.printf("Future Value: %.2f%n", futureValue);
        System.out.println("Time Complexity: O(n)");
    }
}
