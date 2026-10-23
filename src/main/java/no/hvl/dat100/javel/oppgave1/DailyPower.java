package no.hvl.dat100.javel.oppgave1;

public class DailyPower {

    private static final int DAY_HOURS = 24;

    // a) print power prices during a day
    public static void printPowerPrices(double[] prices) {

        for (int h = 0; h < DAY_HOURS; h++) {
            System.out.println("Hour " + h + ": " + prices[h] + " kr/kWh");
        }

    }

    // b) print power usage during a day
    public static void printPowerUsage(double[] usage) {

        for (int h = 0; h < DAY_HOURS; h++) {
            System.out.println("Hour " + h + ": " + usage[h] + " kWh");
        }

    }

    // c) compute power usage for a single day
    public static double computePowerUsage(double[] usage) {

        double sum = 0;

        for (int h = 0; h < DAY_HOURS; h++) {
            sum += usage[h];
        }

        return sum;
    }

    // d) compute spot price for a single day
    public static double computeSpotPrice(double[] usage, double[] prices) {

        double price = 0;

        // Adds computed price for each hour in a day.

        for (int h = 0; h < DAY_HOURS; h++) {
            price += usage[h] * prices[h];
        }


        return price;
    }

    // e) compute power support for a given usage and price
    private static final double THRESHOLD = 0.9375;
    private static final double PERCENTAGE = 0.9;

    private static double getPriceAfterSupport(double usage, double price) {
        double supportPerKwh = Math.max(0, price - THRESHOLD) * PERCENTAGE; // Hvis price < THRESHOLD: ingen støtte.
        return usage * (price - supportPerKwh); // Returnerer pris etter strømstøtten.
    }

    public static double computePowerSupport(double[] usage, double[] prices) {
        double total = 0;

        for (int h = 0; h < DAY_HOURS; h++) {
            total += getPriceAfterSupport(usage[h], prices[h]);
        }

        return total;
    }

    private static final double NORGESPRIS_KWH = 0.5;

    // g) compute norges pris for a single day
    public static double computeNorgesPrice(double[] usage) {

        double price = 0;

        for (int h = 0; h < DAY_HOURS; h++) {
            price += usage[h] * NORGESPRIS_KWH;
        }

        return price;
    }

    // h) compute peak usage during a single day
    public static double findPeakUsage(double[] usage) {

        double temp_max = 0;

        for (int h = 0; h < DAY_HOURS; h++) {
            if (usage[h] > temp_max) {
                temp_max = usage[h];
            }
        }

        return temp_max;
    }

    // i)
    public static double findAvgPower(double[] usage) {

        double sum = 0;

        for (int h = 0; h < DAY_HOURS; h++) {
            sum += usage[h];
        }

        return sum / usage.length;
    }
}