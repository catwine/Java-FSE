import java.util.HashMap;
import java.util.Map;

public class FinancialForecast {

    // --- 1. Recursive forecast with fixed cyclic growth rates ---
    public static double forecast(double principal,
                                  double[] growthRates,
                                  int yearsAhead) {
        if (yearsAhead == 0) return principal;

        // Ensure non-negative index for cyclic access
        int index = (growthRates.length - yearsAhead) % growthRates.length;
        if (index < 0) index += growthRates.length;

        double rate = growthRates[index];
        return forecast(principal * (1 + rate), growthRates, yearsAhead - 1);
    }

    // --- 2. Memoized recursive version ---
    public static double forecastMemo(double principal,
                                      double[] growthRates,
                                      int yearsAhead,
                                      Map<Integer, Double> memo) {
        if (yearsAhead == 0) return principal;
        if (memo.containsKey(yearsAhead)) return memo.get(yearsAhead) * principal;

        int index = (growthRates.length - yearsAhead) % growthRates.length;
        if (index < 0) index += growthRates.length;

        double rate = growthRates[index];
        double result = forecastMemo(principal * (1 + rate), growthRates, yearsAhead - 1, memo);

        memo.put(yearsAhead, result / principal); // store multiplier
        return result;
    }

    // --- 3. Fast exponentiation for constant rate ---
    public static double forecastFast(double principal, double rate, int yearsAhead) {
        if (yearsAhead == 0) return principal;
        if (yearsAhead == 1) return principal * (1 + rate);

        double half = forecastFast(principal, rate, yearsAhead / 2);
        double result = half * Math.pow(1 + rate, yearsAhead / 2);
        if (yearsAhead % 2 == 1) result *= (1 + rate);
        return result;
    }

    // --- Main method for testing ---
    public static void main(String[] args) {
        double principal = 10_000;                     // Initial amount
        double[] growthRates = {0.08, 0.05, 0.07};     // Growth rate per year
        int years = 6;                                 // Forecast for 6 years

        System.out.println("Initial Principal: Rs" + principal);
        System.out.println("Years to Forecast: " + years);
        System.out.print("Growth Rates (cyclic): ");
        for (double r : growthRates) {
            System.out.print((r * 100) + "%  ");
        }
        System.out.println("\n");

        double result1 = forecast(principal, growthRates, years);
        double result2 = forecastMemo(principal, growthRates, years, new HashMap<>());
        double result3 = forecastFast(principal, 0.0667, years); // Approx avg rate

        System.out.printf("1. Recursive Forecast      : Rs%.2f%n", result1);
        System.out.printf("2. Memoized Forecast       : Rs%.2f%n", result2);
        System.out.printf("3. Fast Exponentiation (avg): Rs%.2f%n", result3);
    }
}
